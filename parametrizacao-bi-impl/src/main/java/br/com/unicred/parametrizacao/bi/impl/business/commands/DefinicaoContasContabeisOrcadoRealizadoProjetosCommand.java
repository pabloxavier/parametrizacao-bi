package br.com.unicred.parametrizacao.bi.impl.business.commands;

import br.com.unicred.parametrizacao.bi.impl.business.exceptions.FieldName;
import br.com.unicred.parametrizacao.bi.impl.business.validators.CommandValidator;

import javax.validation.constraints.NotNull;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosCommand {

    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    private String comparacao;
    private Boolean excluir;

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

    public Boolean getExcluir() { return excluir; }

    public void  setExcluir(Boolean excluir) { this.excluir = excluir; }

}