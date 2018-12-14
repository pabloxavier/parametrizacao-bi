package br.com.unicred.parametrizacao.bi.impl.business.commands;

import java.time.LocalDate;

public class PeriodoFechamentoRRCommand {

   private LocalDate dataCompetenciaRankingRating;
   private LocalDate dataUltimoPocessamento;
   private String flagFechado;

   public PeriodoFechamentoRRCommand(){

   }

   public void validate() {
      //TODO realizar validacao
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