package br.scrumban;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.entidade.Venda;

public class CalculadoraRoyaltiesTeste {
	VendaRepository mockRepository;
	CalculadoraComissao mockCalculadoraComissao;
	CalculadoraRoyalties calculadoraRoyalties;
	
	@Before
	public void inicializacao(){
		
		mockRepository = mock(VendaRepository.class);
		mockCalculadoraComissao = mock(CalculadoraComissao.class);
		calculadoraRoyalties = new CalculadoraRoyalties(mockRepository, mockCalculadoraComissao);
	}
	
	@Test
	public void teste1vendaDe100eComissao0Retorna20() {
		int ano = 2012;
		int mes = 1;
		double esperado = 20;
		double valorVenda = 100.0;
		double comissao = 0;
		
		List<Venda> vendas = new ArrayList<Venda>();
		Venda v = new Venda(1, 1, mes, ano, valorVenda);
		vendas.add(v);
	
		when(mockRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		when(mockCalculadoraComissao.calcularComissao(valorVenda)).thenReturn(comissao);

		double retorno = calculadoraRoyalties.calcularRoyalties(ano, mes);
		
		Assert.assertEquals(esperado, retorno);
	}
	@Test
	public void teste2vendaDe300eComissao0Retorna60() {
		int ano = 2012;
		int mes = 2;
		double esperado = 60;
		double valorVenda = 100.0;		
		double valorVenda2 = 200.0;
		double comissao = 0;
		
		List<Venda> vendas = new ArrayList<Venda>();
		Venda v1 = new Venda(1, 1, mes, ano, valorVenda);
		Venda v2 = new Venda(2, 1, mes, ano, valorVenda2);
		vendas.add(v1);
		vendas.add(v2);
		
		when(mockRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		when(mockCalculadoraComissao.calcularComissao(valorVenda)).thenReturn(comissao);
		
		double retorno = calculadoraRoyalties.calcularRoyalties(ano, mes);
		
		Assert.assertEquals(esperado, retorno);
		
		verify(mockCalculadoraComissao).calcularComissao(100.0);
		verify(mockCalculadoraComissao).calcularComissao(200.0);
	}
}
