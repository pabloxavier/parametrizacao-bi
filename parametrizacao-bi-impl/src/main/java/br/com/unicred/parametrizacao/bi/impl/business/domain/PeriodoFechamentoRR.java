package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;

public class PeriodoFechamentoRR {

    private LocalDate dataCompetencia;
    private LocalDate dataUltimoPocessamento;
    private String flagFechado;
    
    protected PeriodoFechamentoRR() {
        
    }
    
    private PeriodoFechamentoRR (PeriodoFechamentoRRCommand comando) {
        this.dataCompetencia = comando.getDataCompetenciaRankingRating();
        this.dataUltimoPocessamento = comando.getDataUltimoPocessamento();
        this.flagFechado = comando.getFlagFechado();        
    }    

    public static PeriodoFechamentoRR criar(PeriodoFechamentoRRCommand comando){
        comando.validate();
        return new PeriodoFechamentoRR(comando);
    }    
    
    public LocalDate getDataCompetencia() {
        return dataCompetencia;
    }

    public LocalDate getDataUltimoPocessamento() {
        return dataUltimoPocessamento;
    }

    public String getFlagFechado() {
        return flagFechado;
    }    
    
}