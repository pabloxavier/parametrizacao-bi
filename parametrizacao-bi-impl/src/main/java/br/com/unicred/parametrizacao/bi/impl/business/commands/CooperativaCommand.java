package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class CooperativaCommand {
    
    private Integer cdCoop; 
    private String sigla;
    private String nmCoop;
    private String flgAtivo;
  
    public Integer getCdCoop() {
        return cdCoop;
    }
    public void setCdCoop(Integer cdCoop) {
        this.cdCoop = cdCoop;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNmCoop() {
        return nmCoop;
    }
    public void setNmCoop(String nmCoop) {
        this.nmCoop = nmCoop;
    }
    public String getFlgAtivo() {
        return flgAtivo;
    }
    public void setFlgAtivo(String flgAtivo) {
        this.flgAtivo = flgAtivo;
    }
    
}
