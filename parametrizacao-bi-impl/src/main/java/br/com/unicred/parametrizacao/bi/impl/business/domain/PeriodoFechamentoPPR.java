package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;

public class PeriodoFechamentoPPR {

	private LocalDate dtCompetencia;
	private LocalDate dtUltProcessamento;
	private boolean isFechado;
	
	public LocalDate getDtCompetencia() {
		return dtCompetencia;
	}
	public LocalDate getDtUltProcessamento() {
		return dtUltProcessamento;
	}
	public boolean isFechado() {
		return isFechado;
	}
	
	
	
}
