package br.com.unicred.parametrizacao.bi.api.v1.representation;

public class CooperativaRepresentation {
    
    private Integer codigoCooperativa; 
    private String siglaCooperativa;
    private String nomeCooperativa;
    private String ativo;
    
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }
    public String getSiglaCooperativa() {
        return siglaCooperativa;
    }
    public void setSiglaCooperativa(String siglaCooperativa) {
        this.siglaCooperativa = siglaCooperativa;
    }
    public String getNomeCooperativa() {
        return nomeCooperativa;
    }
    public void setNomeCooperativa(String nomeCooperativa) {
        this.nomeCooperativa = nomeCooperativa;
    }
    public String getAtivo() {
        return ativo;
    }
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
}
