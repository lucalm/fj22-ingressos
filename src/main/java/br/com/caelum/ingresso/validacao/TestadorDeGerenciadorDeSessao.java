package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class TestadorDeGerenciadorDeSessao {

	public static void main(String[] args) {

		// Teste 1
		Filme f = new Filme("Terminator", Duration.ofHours(1), "Ação", BigDecimal.ONE);
		Sala s = new Sala("Sala VIP", BigDecimal.TEN);
		Sessao sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		List<Sessao> sessoes = new ArrayList<>();
		GerenciadorDeSessao ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == true ? "ok" : "falhou");

		// Teste 2
		f = new Filme("Terminator", Duration.ofHours(3), "Ação", BigDecimal.ONE);
		s = new Sala("Sala VIP", BigDecimal.ONE);
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		sessoes = new ArrayList<>();
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == false ? "ok" : "falhou");

		// Teste 3
		f = new Filme("Terminator", Duration.ofHours(1), "Ação", BigDecimal.ONE);
		s = new Sala("Sala VIP", BigDecimal.ONE);
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		Sessao sessaoAtual = new Sessao(LocalTime.of(19, 0), f, s);
		sessoes = Arrays.asList(sessaoAtual);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == true ? "ok" : "falhou");

		// Teste 4
		f = new Filme("Terminator", Duration.ofHours(1), "Ação", BigDecimal.ONE);
		s = new Sala("Sala VIP", BigDecimal.ONE);
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		sessaoAtual = new Sessao(LocalTime.of(21, 30), f, s);
		sessoes = Arrays.asList(sessaoAtual);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == false ? "ok" : "falhou");

	}

}
