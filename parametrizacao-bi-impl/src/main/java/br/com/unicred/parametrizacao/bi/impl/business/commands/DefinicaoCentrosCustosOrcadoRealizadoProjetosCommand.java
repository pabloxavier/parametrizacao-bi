package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand {
    
    private Integer codigoCooperativa;
    private String comparacao;
    private String codigoPosto;    

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
    
}
