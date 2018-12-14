package br.com.unicred.parametrizacao.bi.api.v1.representation;

public class PostoRepresentation {
    
    private Integer codigoCooperativa; 
    private Integer codigoPosto; 
    private String siglaPosto;
    private String nomePosto;
    private String ativo;

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }
    public Integer getCodigoPosto() {
        return codigoPosto;
    }
    public void setCodigoPosto(Integer codigoPosto) {
        this.codigoPosto = codigoPosto;
    }
    public String getSiglaPosto() {
        return siglaPosto;
    }
    public void setSiglaPosto(String siglaPosto) {
        this.siglaPosto = siglaPosto;
    }
    public String getNomePosto() {
        return nomePosto;
    }
    public void setNomePosto(String nomePosto) {
        this.nomePosto = nomePosto;
    }
    public String getAtivo() {
        return ativo;
    }
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
}
