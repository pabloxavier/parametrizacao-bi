package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;

public class PeriodoFechamentoRR {

    private LocalDate dataCompetenciaRankingRating;
    private LocalDate dataUltimoPocessamento;
    private String flagFechado;
    
    protected PeriodoFechamentoRR() {
        
    }
    
    private PeriodoFechamentoRR (PeriodoFechamentoRRCommand comando) {
        this.dataCompetenciaRankingRating = comando.getDataCompetenciaRankingRating();
        this.dataUltimoPocessamento = comando.getDataUltimoPocessamento();
        this.flagFechado = comando.getFlagFechado();        
    }    

    public static PeriodoFechamentoRR criar(PeriodoFechamentoRRCommand comando){
        comando.validate();
        return new PeriodoFechamentoRR(comando);
    }

	
	public LocalDate getDataCompetenciaRankingRating() {
		return dataCompetenciaRankingRating;
	}

	public void setDataCompetenciaRankingRating(LocalDate dataCompetenciaRankingRating) {
		this.dataCompetenciaRankingRating = dataCompetenciaRankingRating;
	}

	public LocalDate getDataUltimoPocessamento() {
		return dataUltimoPocessamento;
	}

	public void setDataUltimoPocessamento(LocalDate dataUltimoPocessamento) {
		this.dataUltimoPocessamento = dataUltimoPocessamento;
	}

	public String getFlagFechado() {
		return flagFechado;
	}

	public void setFlagFechado(String flagFechado) {
		this.flagFechado = flagFechado;
	}    
    
}