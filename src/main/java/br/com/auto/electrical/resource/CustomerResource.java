package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.request.CustomerRequest;
import br.com.auto.electrical.model.request.CustomerUpdateRequest;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Customer")
@RequestMapping("/api/v1/customer")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer with basic details")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    @Operation(summary = "Get customer by filters", description = "Retrieve a customer page by filters")
    public ResponseEntity<Page<CustomerResponse>> getAll(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String document,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getCustomers(id, name, document, phone, email, pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Customer details", description = "Update existing customer details by ID")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateRequest request) {
        return ResponseEntity.ok(service.updateCustomer(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer by ID", description = "Delete a customer by its ID")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
