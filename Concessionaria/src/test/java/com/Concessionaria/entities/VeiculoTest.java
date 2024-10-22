package com.Concessionaria.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VeiculoTest {

	private Veiculo veiculo;

	@BeforeEach
	void setUp() {
		// Arrange
		veiculo = new Veiculo(1L, "creta", "ultimate", 2024, "branco");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		// Act
		veiculo.setId(2L);
		// Assert
		assertEquals(2L, veiculo.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo marca")
	void testMarca() {
		// Act
		veiculo.setMarca("creta");
		// Assert
		assertEquals("creta", veiculo.getMarca());
	}



	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testModelo() {
		// Act
		veiculo.setModelo("ultimate");
		// Assert
		assertEquals("ultimate", veiculo.getModelo());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ano")
	void testAno() {
		// Act
		veiculo.setAno(2024);
		// Assert
		assertEquals(2024, veiculo.getAno());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo cor")
	void testCor() {
		// Act
		veiculo.setCor("branco");
		// Assert
		assertEquals("branco", veiculo.getCor());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Veiculo novoVeiculo = new Veiculo(3L, "creta", "ultimate", 2024, "branco");
		// Assertion
		assertAll("novoVeiculo", () -> assertEquals(3L, novoVeiculo.getId(), "Error ID"),
				() -> assertEquals("luis", novoVeiculo.getMarca(), "Error Marca"),
				() -> assertEquals("(15)998745217", novoVeiculo.getModelo(), "Error Modelo"),
				() -> assertEquals("1654615156", novoVeiculo.getAno(), "Error Ano"),
				() -> assertEquals("68468158", novoVeiculo.getCor(), "Error Cor"));
				

	}
}