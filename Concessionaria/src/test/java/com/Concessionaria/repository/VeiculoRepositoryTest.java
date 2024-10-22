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

import com.Concessionaria.entities.Veiculo;


@DataJpaTest
class VeiculoRepositoryTest {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@DisplayName("Testando o Save") 
		@Test
		void testSalvarRepository() {
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "creta",		
											 "ultimate",
											 2024,
											 "branco");
		
		// When / Act
		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);
		
		// Then / Assert
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Veiculos")
	@Test
	void testGetAllRepository() {
		
		// Given / Arrangs
		Veiculo veiculo1 = new Veiculo(null,"creta",		
											"ultimate",
												2024,
												"branco");
		
		Veiculo veiculo2 = new Veiculo(null, "RangeRover",		
												"land",
													2024,
													"branco");
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		
		// when / act
		List<Veiculo> veiculoList = veiculoRepository.findAll();
		
		// Then / Assert
		assertNotNull(veiculoList);
		assertEquals(2, veiculoList.size());
		
											
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
	Veiculo veiculo1 = new Veiculo(null, "RangeRover",		
											"land",
											2024,
											"branco");
	
	veiculoRepository.save(veiculo1);
	
	// When / Act
	Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
	
	// Then / Assert
	assertNotNull(saveVeiculo);
	assertEquals(veiculo1.getId(), saveVeiculo.getId());
	}
	
	@DisplayName("Testando o Update")
	@Test
	void testUpdateVeiculo() {
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "RangeRover",		
													"land",
														2023,
														"branco");
		
		veiculoRepository.save(veiculo1);
		
		// When / Act
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("Fiat");
		veiculo1.setModelo("UNO");
		veiculo1.setAno(2015);
		veiculo1.setCor("Preto");
		
		Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);
		
		// Then / Assert
		assertNotNull(updateVeiculo);
		assertEquals("Fiat", updateVeiculo.getMarca());
		assertEquals("UNO", updateVeiculo.getModelo());
		assertEquals(2015, updateVeiculo.getAno());
		assertEquals("Preto", updateVeiculo.getCor());
	}
	
	@DisplayName("Testando o delete")
	@Test
	void testDeleteVeiculo() {
		
		// Given / Arrange
		Veiculo veiculo1 = new Veiculo(null, "RangeRover",		
												"land",
												2023,
												"branco");
		
		veiculoRepository.save(veiculo1);
		
		// When / Act
		
	veiculoRepository.deleteById(veiculo1.getId());
	
	Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo1.getId());
	
	//Then / Assert
	assertTrue(veiculoOptional.isEmpty());
	}


}
