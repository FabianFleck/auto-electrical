package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.request.CarRequest;
import br.com.auto.electrical.model.response.CarResponse;
import br.com.auto.electrical.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
public class CarResource {

    @Autowired
    private CarService service;

    @PostMapping
    public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
