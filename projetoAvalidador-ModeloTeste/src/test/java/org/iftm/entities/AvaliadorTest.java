package org.iftm.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvaliadorTest {

	@Test
	public void testaMaiorLanceSemOrdem() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		Avaliador avaliador = new Avaliador();
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 300));
		leilao.propoe(new Lance(maria, 300));
		
		avaliador.avalia(leilao);
		
		Double valorEsperado = 400.0;
		assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
		
		//criar a testaMaiorLanceComOrdem	
	}
	
	@Test
	public void testaMaiorLanceComOrdem() {
		Usuario joao = new Usuario("Joaquim");
		Usuario jose = new Usuario("Joselito");
		Usuario maria = new Usuario("Marta");
		
		Leilao leilao = new Leilao("Playstation 4 novo");
		Avaliador avaliador = new Avaliador();
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 300));
		leilao.propoe(new Lance(maria, 300));
		
		avaliador.avalia(leilao);
		
		Double valorEsperado = 400.0;
		assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

}
