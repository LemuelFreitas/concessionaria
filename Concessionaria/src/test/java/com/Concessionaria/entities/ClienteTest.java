package com.Concessionaria.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente;

	@BeforeEach
	void setUp() {
		// Arrange
		cliente = new Cliente(1L, "Lemuel Freitas", "(00)000000", "15156161568", "355446421");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		// Act
		cliente.setId(2L);
		// Assert
		assertEquals(2L, cliente.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		cliente.setNome("fausto");
		// Assert
		assertEquals("fausto", cliente.getNome());
	}



	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		// Act
		cliente.setTelefone("(15)996677425");
		// Assert
		assertEquals("(15)996677425", cliente.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo cpf")
	void testCpf() {
		// Act
		cliente.setCpf("8888888");
		// Assert
		assertEquals("8888888", cliente.getCpf());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo rg")
	void testRg() {
		// Act
		cliente.setRg("999999");
		// Assert
		assertEquals("999999", cliente.getRg());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Cliente novoCliente = new Cliente(3L, "luis", "(15)998745217", "1654615156", "68468158");
		// Assertion
		assertAll("novoCliente", () -> assertEquals(3L, novoCliente.getId(), "Error ID"),
				() -> assertEquals("luis", novoCliente.getNome(), "Error nome"),
				() -> assertEquals("(15)998745217", novoCliente.getTelefone(), "Error telefone"),
				() -> assertEquals("1654615156", novoCliente.getCpf(), "Error cpf"),
				() -> assertEquals("68468158", novoCliente.getRg(), "Error rg"));
				

	}
}