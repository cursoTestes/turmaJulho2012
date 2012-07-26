package br.scrumban;

import java.util.List;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.entidade.Venda;

public class CalculadoraRoyalties {
private VendaRepository vendaRepository;
private CalculadoraComissao calculadoraComissao;
	public CalculadoraRoyalties(VendaRepository mockRepository,
			CalculadoraComissao mockCalculadoraComissao) {
		// TODO Auto-generated constructor stub
		vendaRepository = mockRepository;
		calculadoraComissao = mockCalculadoraComissao;
	}

	public double calcularRoyalties(int ano, int mes) {
		// TODO Auto-generated method stub
		List<Venda> lista = vendaRepository.obterVendasPorMesEAno(ano, mes);
		double acumulado = 0;
		for (Venda v : lista) {
			double valorBruto = v.getValor();
			double valorLiquido = valorBruto - calculadoraComissao.calcularComissao(valorBruto);
			acumulado += valorLiquido;
		}
		double res = acumulado * 0.2;

		return res;
	}

}
