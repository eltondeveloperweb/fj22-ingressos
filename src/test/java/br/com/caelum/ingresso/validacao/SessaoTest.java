package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoTest {
	
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		
		Sala sala = new Sala("Eltorado - IMAX", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12.0"));
				
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), sala, filme);
		
		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
	}

}
