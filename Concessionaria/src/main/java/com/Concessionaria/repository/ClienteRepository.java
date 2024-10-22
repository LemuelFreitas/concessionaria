package com.Concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Concessionaria.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
		//Query Method
		List<Cliente>findByNome(String nome);

	}