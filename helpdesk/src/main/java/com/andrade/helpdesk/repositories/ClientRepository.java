package com.andrade.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrade.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
