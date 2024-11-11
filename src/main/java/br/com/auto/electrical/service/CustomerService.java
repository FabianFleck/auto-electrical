package br.com.auto.electrical.service;

import br.com.auto.electrical.error.exception.UnprocessableEntityException;
import br.com.auto.electrical.mapper.CustomerMapper;
import br.com.auto.electrical.model.entity.CustomerEntity;
import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.request.CustomerUpdateRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerMapper mapper;

    public CustomerResponse create(CustomerRequest request) {
        if (repository.findByDocument(request.document()).isPresent()) {
            throw new UnprocessableEntityException("Cliente já existe");
        }
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(request)
                )
        );
    }

    public Page<CustomerResponse> getCustomers(Long id, String name, Long document, Long phone, String email, Pageable pageable) {
        return repository.findByFilters(id, name, document, phone, email, pageable)
                .map(mapper::toResponse);
    }

    public CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request) {
        var existingClient = findById(id);

        mapper.toEntity(request, existingClient);

        return mapper.toResponse(repository.save(existingClient));
    }

    private CustomerEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UnprocessableEntityException("Cliente não existe com id: " + id));
    }

    public void deleteCustomer(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
