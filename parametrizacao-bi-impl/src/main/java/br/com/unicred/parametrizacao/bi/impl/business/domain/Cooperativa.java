package br.com.unicred.parametrizacao.bi.impl.business.domain;

public class Cooperativa {
    
    private Integer cdCoop; 
    private String sigla;
    private String nmCoop;
    private String flgAtivo;
    
    public Integer getCdCoop() {
        return cdCoop;
    }
    public String getSigla() {
        return sigla;
    }
    public String getNmCoop() {
        return nmCoop;
    }
    public String getFlgAtivo() {
        return flgAtivo;
    }
    @Override
    public String toString() {
        return "Cooperativa ["
                + "cdCoop=" + cdCoop + ", "
                + "sigla=" + sigla + ", "
                + "nmCoop=" + nmCoop + ", "
                + "flgAtivo=" + flgAtivo
                + "]";
    }
    
}
