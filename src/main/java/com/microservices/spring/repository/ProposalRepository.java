package com.microservices.spring.repository;

import com.microservices.spring.entity.Proposal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
}
