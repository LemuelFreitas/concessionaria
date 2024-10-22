package com.Concessionaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	
	@Column(name = "marca",nullable = false, length = 100)
	private String marca;
	
	@Column(name = "modelo",nullable = false, length = 100)
	private String modelo;
	
	@Column(name = "ano",nullable = false, length = 100)
	private int ano;

	@Column(name = "cor",nullable = false, length = 100)
	private String cor;

	

}


