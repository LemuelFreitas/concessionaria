package com.Concessionaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Concessionaria.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {
		//Query Method
		List<Veiculo>findByNome(String nome);

	}
