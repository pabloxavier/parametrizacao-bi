package br.com.unicred.parametrizacao.bi.api.v1.representation;

public class DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation {

    private Integer codigoCooperativa;
    private String comparacao;
    private String codigoPosto;    
    private String isExcluido;
    
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public String getComparacao() {
        return comparacao;
    }

    public void setComparacao(String comparacao) {
        this.comparacao = comparacao;
    }

    public String getCodigoPosto() {
        return codigoPosto;
    }

    public void setCodigoPosto(String codigoPosto) {
        this.codigoPosto = codigoPosto;
    }

    public String getIsExcluido() {
        return isExcluido;
    }

    public void setIsExcluido(String isExcluido) {
        this.isExcluido = isExcluido;
    }

 
}
