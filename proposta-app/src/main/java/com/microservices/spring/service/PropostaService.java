package com.microservices.spring.service;

import com.microservices.spring.dto.PropostaRequestDto;
import com.microservices.spring.dto.PropostaResponseDto;
import com.microservices.spring.entity.Proposta;
import com.microservices.spring.mapper.PropostaMapper;
import com.microservices.spring.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final NotificacaoRabbitService notificacaoRabbitService;

    private final String exchange;

    public PropostaService(PropostaRepository propostaRepository,
                           @Value("${spring.property.propostapendente}") String exchange,
                           NotificacaoRabbitService notificacaoRabbitService) {
        this.propostaRepository = propostaRepository;
        this.exchange = exchange;
        this.notificacaoRabbitService = notificacaoRabbitService;
    }

    public PropostaResponseDto criar(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);
        return PropostaMapper.INSTANCE.convertPropostaToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificacaoRabbitService.notificar(proposta, exchange);
        } catch (RuntimeException ex) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDto> getProposta() {
        return PropostaMapper.INSTANCE.convertLstEntityToListDto(propostaRepository.findAll());
    }
}
