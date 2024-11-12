package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.enumeration.CarColorEnum;
import br.com.auto.electrical.model.request.CarRequest;
import br.com.auto.electrical.model.response.CarResponse;
import br.com.auto.electrical.model.response.CustomerResponse;
import br.com.auto.electrical.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
public class CarResource {

    @Autowired
    private CarService service;

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    @Operation(summary = "Get car by filters", description = "Retrieve a car page by filters")
    public ResponseEntity<Page<CarResponse>> getAll(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String plate,
            @RequestParam(required = false) CarColorEnum color,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Long customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getCars(id, plate, color, model, year, customerId, pageable));
    }
}
