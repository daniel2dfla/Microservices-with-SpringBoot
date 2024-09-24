package com.microservices.spring.controller;

import com.microservices.spring.dto.PropostaRequestDto;
import com.microservices.spring.dto.PropostaResponseDto;
import com.microservices.spring.service.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @CrossOrigin(origins = "http://localhost:80")
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaRequestDto requestDto) {
        PropostaResponseDto response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(response.getId())
                        .toUri())
                .body(response);
    }

    @CrossOrigin(origins = "http://localhost:80")
    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
