package com.microservices.spring.mapper;

import com.microservices.spring.dto.ProposalRequestDto;
import com.microservices.spring.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProposalMapper {

    @Mapping(target = "customer.name", source = "name")
    @Mapping(target = "customer.lastName", source = "lastName")
    @Mapping(target = "customer.cellphone", source = "cellphone")
    @Mapping(target = "customer.rent", source = "rent")
    @Mapping(target = "customer.cpf", source = "cpf")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", ignore = true)
    @Mapping(target = "integrated", ignore = true)
    @Mapping(target = "observation", ignore = true)
    Proposal convertDtoToProposal(ProposalRequestDto proposalRequestDto);
}
