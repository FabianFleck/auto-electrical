package br.com.auto.electrical.service;

import br.com.auto.electrical.error.exception.UnprocessableEntityException;
import br.com.auto.electrical.mapper.ServiceCarMapper;
import br.com.auto.electrical.model.entity.CarEntity;
import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.entity.ProductCarEntity;
import br.com.auto.electrical.model.entity.ServiceCarEntity;
import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;
import br.com.auto.electrical.model.request.ServiceCarRequest;
import br.com.auto.electrical.model.response.ServiceCarResponse;
import br.com.auto.electrical.model.response.ServiceCarSimpleResponse;
import br.com.auto.electrical.repository.ServiceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceCarService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CarService carService;
    @Autowired
    private ServiceCarMapper mapper;
    @Autowired
    private ServiceCarRepository repository;

    public ServiceCarResponse create(ServiceCarRequest request) {
        CustomerEntity customerEntity = customerService.findById(request.customerId());
        CarEntity carEntity = carService.findById(request.carId());

        ServiceCarEntity entity = mapper.toEntity(request, customerEntity, carEntity);

        request.products().forEach(productRequest -> {
            ProductCarEntity product = mapper.toProductEntity(productRequest);
            entity.addProduct(product);
        });

        ServiceCarEntity save = repository.save(entity);

        return mapper.toResponse(save);
    }

    public Page<ServiceCarSimpleResponse> getServicesCar(
            Long id,
            Long customerId,
            Long carId,
            String description,
            ServiceCarStatusEnum status,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Pageable pageable) {
        return repository.findByFilters(id,
                        customerId,
                        carId,
                        description,
                        status,
                        startDate,
                        endDate,
                        pageable)
                .map(mapper::toSimpleResponse);
    }

    public ServiceCarResponse getById(Long id) {
        return mapper.toResponse(findById(id));
    }

    public ServiceCarEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UnprocessableEntityException("Serviço não existe com id " + id));
    }
}
