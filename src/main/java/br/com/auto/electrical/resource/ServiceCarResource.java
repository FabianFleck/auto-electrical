package br.com.auto.electrical.resource;

import br.com.auto.electrical.model.request.ServiceCarRequest;
import br.com.auto.electrical.model.response.ServiceCarResponse;
import br.com.auto.electrical.service.ServiceCarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
