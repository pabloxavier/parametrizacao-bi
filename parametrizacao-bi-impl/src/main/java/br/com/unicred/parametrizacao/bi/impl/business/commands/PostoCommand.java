package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class PostoCommand {
    
    private Integer cdCoop; 
    private Integer cdPosto; 
    private String siglaPosto;
    private String nmPosto;
    private String flgAtivo;

    public Integer getCdCoop() {
        return cdCoop;
    }

    public void setCdCoop(Integer cdCoop) {
        this.cdCoop = cdCoop;
    }

    public Integer getCdPosto() {
        return cdPosto;
    }

    public void setCdPosto(Integer cdPosto) {
        this.cdPosto = cdPosto;
    }

    public String getSiglaPosto() {
        return siglaPosto;
    }

    public void setSiglaPosto(String siglaPosto) {
        this.siglaPosto = siglaPosto;
    }

    public String getNmPosto() {
        return nmPosto;
    }

    public void setNmPosto(String nmPosto) {
        this.nmPosto = nmPosto;
    }

    public String getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(String flgAtivo) {
        this.flgAtivo = flgAtivo;
    }
    
}
