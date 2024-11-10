package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerResource {

    private final CustomerService service;

    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(service.createCustomer(request));
    }
}
