package br.com.auto.electrical.service;

import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse createCustomer(CustomerRequest request){
        CustomerEntity entity = new CustomerEntity();

        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPhone(request.getPhone());
        entity.setDocument(request.getDocument());
        entity.setCreationDate(LocalDateTime.now());
        entity.setUpdateDate(LocalDateTime.now());

        CustomerEntity entitySave = repository.save(entity);

        CustomerResponse response = new CustomerResponse();

        response.setId(entitySave.getId());
        response.setName(entitySave.getName());
        response.setEmail(entitySave.getEmail());
        response.setPhone(entitySave.getPhone());
        response.setDocument(entitySave.getDocument());
        response.setCreationDate(entitySave.getCreationDate());
        response.setUpdateDate(entitySave.getUpdateDate());

        return response;
    }
}
