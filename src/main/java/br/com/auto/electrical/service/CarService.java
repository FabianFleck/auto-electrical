package br.com.auto.electrical.service;

import br.com.auto.electrical.error.exception.UnprocessableEntityException;
import br.com.auto.electrical.mapper.CarMapper;
import br.com.auto.electrical.model.request.CarRequest;
import br.com.auto.electrical.model.response.CarResponse;
import br.com.auto.electrical.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
