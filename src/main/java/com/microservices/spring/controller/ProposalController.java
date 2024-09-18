package com.microservices.spring.controller;

import com.microservices.spring.dto.ProposalRequestDto;
import com.microservices.spring.dto.ProposalResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto proposalRequestDto) {
        return null;
    }
}
