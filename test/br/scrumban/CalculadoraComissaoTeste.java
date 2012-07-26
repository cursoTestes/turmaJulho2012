package br.scrumban;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraComissaoTeste {

	@Test
	public void testeVendaDe100Retorna5Reais() {
		double valorVenda = 100;
		double comissaoEsperada = 5;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0);
	}

	@Test
	public void testeVendaDe200Retorna10Reais() {
		double valorVenda = 200;
		double comissaoEsperada = 10;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0);
	}
	
	@Test
	public void testeVendaDe10000Retorna500Reais() {
		double valorVenda = 10000;
		double comissaoEsperada = 500;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0);
	}
	
	@Test
	public void testeVendaDe100000Retorna6000Reais() {
		double valorVenda = 100000;
		double comissaoEsperada = 6000;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0);
	}
	@Test
	public void testeVendaDe9999Retorna499_95Reais() {
		double valorVenda = 9999;
		double comissaoEsperada = 499.95;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0.001);
	}
	
	@Test
	public void testeVendaDe55_59Retorna2_77Reais() {
		double valorVenda = 55.59;
		double comissaoEsperada = 2.77;
		
		CalculadoraComissao calculadoraComissao = new CalculadoraComissao();
		
		double comissaoAtual= calculadoraComissao.calcularComissao(valorVenda);
		assertEquals(comissaoEsperada, comissaoAtual, 0.001);
	}
}
