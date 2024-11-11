package br.com.auto.electrical.service;

import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerResponse create(CustomerRequest request) {
        if (repository.findByDocument(request.document()).isPresent()) {
            throw new RuntimeException("Cliente já existe");
        }
        return new CustomerResponse(
                repository.save(
                        new CustomerEntity(request)
                )
        );
    }
}
