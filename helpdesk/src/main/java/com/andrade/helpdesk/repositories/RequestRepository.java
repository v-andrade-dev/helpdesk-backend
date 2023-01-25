package com.andrade.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrade.helpdesk.domain.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{

}
