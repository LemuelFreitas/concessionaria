package com.Concessionaria.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;

	@BeforeEach
	void setUp() {
		// Arrange
		produto = new Produto(1L, "carro", 250000);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		// Act
		produto.setId(2L);
		// Assert
		assertEquals(2L, produto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		produto.setNome("carro");
		// Assert
		assertEquals("carro", produto.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testPreco() {
		// Act
		produto.setPreco(250000);
		// Assert
		assertEquals(250000, produto.getPreco());
	}



	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Produto novoProduto = new Produto(3L, "carro", 250000);
		// Assertion
		assertAll("novoProduto", () -> assertEquals(3L, novoProduto.getId(), "Error ID"),
				() -> assertEquals("luis", novoProduto.getNome(), "Error nome"),
				() -> assertEquals("(15)998745217", novoProduto.getPreco(), "Error preco"));
				

	}
}