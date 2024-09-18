package com.microservices.spring.service;

import com.microservices.spring.dto.ProposalRequestDto;
import com.microservices.spring.dto.ProposalResponseDto;
import com.microservices.spring.entity.Proposal;
import com.microservices.spring.repository.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProposalService {

    private ProposalRepository proposalRepository;

    public ProposalResponseDto create(ProposalRequestDto proposalRequestDto) {
        proposalRepository.save(new Proposal());
        return null;
    }
}
