package com.andrade.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrade.helpdesk.domain.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer>{

}