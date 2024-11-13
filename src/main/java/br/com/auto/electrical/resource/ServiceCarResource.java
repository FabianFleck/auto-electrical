package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;
import br.com.auto.electrical.model.request.ServiceCarRequest;
import br.com.auto.electrical.model.response.ServiceCarResponse;
import br.com.auto.electrical.model.response.ServiceCarSimpleResponse;
import br.com.auto.electrical.service.ServiceCarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Service Car")
@RequestMapping("/api/v1/service-car")
public class ServiceCarResource {

    @Autowired
    private ServiceCarService service;

    @PostMapping
    public ResponseEntity<ServiceCarResponse> create(@RequestBody ServiceCarRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    @Operation(summary = "Get service car by filters", description = "Retrieve a service car page by filters")
    public ResponseEntity<Page<ServiceCarSimpleResponse>> getAll(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) Long carId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) ServiceCarStatusEnum status,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getServicesCar(id, customerId, carId, description, status, startDate, endDate, pageable));
    }
}
