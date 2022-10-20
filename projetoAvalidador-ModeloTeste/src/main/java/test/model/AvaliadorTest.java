package test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.iftm.entities.Avaliador;
import org.iftm.entities.Lance;
import org.iftm.entities.Leilao;
import org.iftm.entities.Usuario;
import org.junit.jupiter.api.Test;

class AvaliadorTest {
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	private Leilao leilao;
	private Avaliador avaliador;
	
	
	@BeforeEach
	public void instanciarObjetos(){
		joao = new Usuario("Joao");
		jose = new Usuario("Jose");
		maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		Avaliador avaliador = new Avaliador();
	}
	
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
		
		Double valorEsperado = 200.0;
		assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
	}
	
	@Test
	public void testaMaiorLanceComOrdemCrescente() {
		Usuario joao = new Usuario("Joaquim");
		Usuario jose = new Usuario("Joselito");
		Usuario maria = new Usuario("Marta");
		
		Leilao leilao = new Leilao("Playstation 4 novo");
		Avaliador avaliador = new Avaliador();
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 500));
		
		avaliador.avalia(leilao);
		
		Double valorEsperado = 1200.0;
		assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
	}
	
	@Test
	public void testaMaiorLanceComOrdemDecrescente() {
		Usuario joao = new Usuario("Joaquim");
		Usuario jose = new Usuario("Joselito");
		Usuario maria = new Usuario("Marta");
		
		Leilao leilao = new Leilao("Playstation 4 novo");
		Avaliador avaliador = new Avaliador();
		
		leilao.propoe(new Lance(joao, 500));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 300));
		
		avaliador.avalia(leilao);
		
		Double valorEsperado = 1100.0;
		assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
	}
	
	@Test
	public void testarMenorLancesOrdemCrescente2() {

		Usuario joao = new Usuario("Joaquim");
		Usuario jose = new Usuario("Joselito");
		Usuario maria = new Usuario("Marta");
		
		leilao.propoe(new Lance(joao, 500));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 300));
		
		double resultadoEsperado = 250;

		avaliador.avalia(leilao);

		double resultadoObtido = avaliador.getMenorLance();
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	@Test
		public void testarMenorLancesUmLance() {

		leilao.propoe(new Lance(joao,250.0));
		double resultadoEsperado = 250;

		avaliador.avalia(leilao);

		double resultadoObtido = avaliador.getMenorLance();
		assertEquals(resultadoEsperado, resultadoObtido, 0.0001);
	}
	
	@Test
		public void testarTresMaioresLancesOrdemCrescente() {
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(jose, 200.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(joao, 400.0));
		avaliador.avalia(leilao);
		List<Lance> maiores = avaliador.getTresMaiores();
		assertEquals(3, maiores.size());

	}

}
