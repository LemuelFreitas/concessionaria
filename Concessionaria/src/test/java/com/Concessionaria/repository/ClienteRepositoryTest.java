package com.Concessionaria.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Concessionaria.entities.Cliente;


@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@DisplayName("Testando o Save") 
		@Test
		void testSalvarRepository() {
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julia Maria",		
											 "(00)0000-0000",
											 "6186462972",
											 "15151515115");
		
		// When / Act
		Cliente saveCliente = clienteRepository.save(cliente1);
		
		// Then / Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Clientes")
	@Test
	void testGetAllRepository() {
		
		// Given / Arrangs
		Cliente cliente1 = new Cliente(null, "Julia Maria",		
												"(00)0000-0000",
													"6186462972",
														"15151515115");
		
		Cliente cliente2 = new Cliente(null, "Julio Fernando",
												"(00)0000-0000",
													"8884848484848",
														"2626266262626");
		
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
		
		// when / act
		List<Cliente> clienteList = clienteRepository.findAll();
		
		// Then / Assert
		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());
		
											
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
	Cliente cliente1 = new Cliente(null, "Julio Fernando",
											"(00)0000-0000",
												"8884848484848",
													"2626266262626");
	
	clienteRepository.save(cliente1);
	
	// When / Act
	Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
	
	// Then / Assert
	assertNotNull(saveCliente);
	assertEquals(cliente1.getId(), saveCliente.getId());
	}
	
	@DisplayName("Testando o Update")
	@Test
	void testUpdateCliente() {
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julio Fernando",
												"(00)0000-0000",
													"8884848484848",
														"2626266262626");
		
		clienteRepository.save(cliente1);
		
		// When / Act
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
		cliente1.setNome("Leonardo");
		cliente1.setTelefone("(00)0000-0001");
		cliente1.setCpf("55545454545");
		cliente1.setRg("89898989898989");

		
		Cliente updateCliente = clienteRepository.save(saveCliente);
		
		// Then / Assert
		assertNotNull(updateCliente);
		assertEquals("Leonardo", updateCliente.getNome());
		assertEquals("(00)0000-0001", updateCliente.getTelefone());
		assertEquals("55545454545", updateCliente.getCpf());
		assertEquals("89898989898989", updateCliente.getRg());
	}
	
	@DisplayName("Testando o delete")
	@Test
	void testDeleteCliente() {
		
		// Given / Arrange
		Cliente cliente1 = new Cliente(null, "Julio Fernando",
													"(00)0000-0000",
														"8884848484848",
															"2626266262626");
		
		clienteRepository.save(cliente1);
		
		// When / Act
		
	clienteRepository.deleteById(cliente1.getId());
	
	Optional<Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());
	
	//Then / Assert
	assertTrue(clienteOptional.isEmpty());
	}


}
