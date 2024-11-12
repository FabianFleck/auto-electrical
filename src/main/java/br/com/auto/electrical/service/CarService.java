package br.com.auto.electrical.service;

import br.com.auto.electrical.error.exception.UnprocessableEntityException;
import br.com.auto.electrical.mapper.CarMapper;
import br.com.auto.electrical.model.enumeration.CarColorEnum;
import br.com.auto.electrical.model.request.CarRequest;
import br.com.auto.electrical.model.response.CarResponse;
import br.com.auto.electrical.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;
    @Autowired
    private CarMapper mapper;
    @Autowired
    private CustomerService customerService;

    public CarResponse create(CarRequest request) {
        if (repository.existsByPlate(request.plate())) {
            throw new UnprocessableEntityException("O carro com a placa " + request.plate() + " já existe.");
        }
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(request,
                                customerService.findById(
                                        request.clientID())
                        )
                )
        );
    }

    public Page<CarResponse> getCars(Long id, String plate, CarColorEnum color, String model, Integer year, Long customerId, Pageable pageable) {
        return repository.findByFilters(id, plate, color, model, year, customerId, pageable)
                .map(mapper::toResponse);
    }
}
