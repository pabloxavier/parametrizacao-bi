package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;

public class PeriodoFechamentoRR {

	private LocalDate dataCompetencia;
	private LocalDate dataUltimoProcessamento;
	private boolean isFechado;
	
	protected PeriodoFechamentoRR() {
		
	}
	
	private PeriodoFechamentoRR (PeriodoFechamentoRRCommand comando) {
		this.dataCompetencia = comando.getDataCompetenciaRankingRating();
		this.dataUltimoProcessamento = comando.getDataUltimoPocessamento();
		this.isFechado = comando.isFlagFechado();		
	}	

	public static PeriodoFechamentoRR criar(PeriodoFechamentoRRCommand comando){
	    comando.validate();
	    return new PeriodoFechamentoRR(comando);
	}	
	
	public LocalDate getDataCompetencia() {
		return dataCompetencia;
	}

	public LocalDate getDataUltimoProcessamento() {
		return dataUltimoProcessamento;
	}

	public boolean isFechado() {
		return isFechado;
	}	
	
}
