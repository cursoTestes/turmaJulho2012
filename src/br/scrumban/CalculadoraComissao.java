package br.scrumban;

public class CalculadoraComissao {

	public double calcularComissao(double valorVenda) {
		// TODO Auto-generated method stub
		
		double comissao;
		if(valorVenda <= 10000.0)
			comissao = valorVenda * 0.05;
		else
			comissao = valorVenda * 0.06;
		
		comissao *= 100.0;
		comissao = Math.floor(comissao);
		comissao /= 100.0;
		
		return comissao;

	}


}
