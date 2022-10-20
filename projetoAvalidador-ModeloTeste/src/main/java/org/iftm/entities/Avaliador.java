package org.iftm.entities;

import test.model.List;

public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	public void avalia(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
			if (lance.getValor() < maiorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
	}
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	public double getMenorLance() {
		return maiorDeTodos;
	}
	public List<Lance> getTresMaiores() {
		// TODO Auto-generated method stub
		return null;
	}
}
