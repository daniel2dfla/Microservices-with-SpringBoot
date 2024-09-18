package com.microservices.spring.controller;

import com.microservices.spring.dto.PropostaRequestDto;
import com.microservices.spring.dto.PropostaResponseDto;
import com.microservices.spring.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
@AllArgsConstructor
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @CrossOrigin(origins = "http://localhost:80")
    @PostMapping
    public ResponseEntity<PropostaResponseDto> create(@RequestBody PropostaRequestDto propostaRequestDto) {
        PropostaResponseDto response = propostaService.criar(propostaRequestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @CrossOrigin(origins = "http://localhost:80")
    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> getProposta() {
        return ResponseEntity.ok(propostaService.getProposta());
    }
}
