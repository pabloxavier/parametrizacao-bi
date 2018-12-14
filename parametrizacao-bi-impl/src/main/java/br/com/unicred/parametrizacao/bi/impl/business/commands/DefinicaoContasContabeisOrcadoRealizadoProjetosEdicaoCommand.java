package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand {
    private Integer codigo;
    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    private String comparacao;

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
}
