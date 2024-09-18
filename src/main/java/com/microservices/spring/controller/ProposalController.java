package com.microservices.spring.controller;

import com.microservices.spring.dto.ProposalRequestDto;
import com.microservices.spring.dto.ProposalResponseDto;
import com.microservices.spring.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal")
@AllArgsConstructor
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDto> create(@RequestBody ProposalRequestDto proposalRequestDto) {
        ProposalResponseDto response = proposalService.create(proposalRequestDto);
        return ResponseEntity.ok(response);
    }
}
