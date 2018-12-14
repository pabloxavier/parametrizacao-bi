package br.com.unicred.parametrizacao.bi.api.v1.representation;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation {

    private Integer codigo;
    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    private String comparacao;
    private Boolean status;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public String getCodigoContaEstrutural() {
        return codigoContaEstrutural;
    }

    public void setCodigoContaEstrutural(String codigoContaEstrutural) {
        this.codigoContaEstrutural = codigoContaEstrutural;
    }

    public String getComparacao() {
        return comparacao;
    }

    public void setComparacao(String comparacao) {
        this.comparacao = comparacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
