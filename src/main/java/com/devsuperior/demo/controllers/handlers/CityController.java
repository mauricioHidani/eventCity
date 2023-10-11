package com.devsuperior.demo.controllers.handlers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO city) {
        CityDTO saved = service.insert(city);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved)
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(saved);
    }
}
