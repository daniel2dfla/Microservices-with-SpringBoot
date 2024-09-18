package com.microservices.spring.service;

import com.microservices.spring.dto.PropostaRequestDto;
import com.microservices.spring.dto.PropostaResponseDto;
import com.microservices.spring.entity.Proposta;
import com.microservices.spring.mapper.PropostaMapper;
import com.microservices.spring.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropostaService {

    private PropostaRepository propostaRepository;
    private NotificacaoService notificacaoService;

    private String exchange;

    public PropostaService(PropostaRepository propostaRepository,
                           @Value("${spring.property.propostapendente}") String exchange,
                           NotificacaoService notificacaoService) {
        this.propostaRepository = propostaRepository;
        this.exchange = exchange;
        this.notificacaoService = notificacaoService;
    }

    public PropostaResponseDto criar(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        propostaRepository.save(proposta);

        PropostaResponseDto response = PropostaMapper.INSTANCE.convertPropostaToDto(proposta);
        notificacaoService.notificar(response, exchange);
        return response;
    }

    public List<PropostaResponseDto> getProposta() {
        return PropostaMapper.INSTANCE.convertLstEntityToListDto(propostaRepository.findAll());
    }
}
