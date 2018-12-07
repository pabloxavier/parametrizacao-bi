package br.com.unicred.parametrizacao.bi.impl.business.commands;

import br.com.unicred.parametrizacao.bi.impl.business.exceptions.FieldName;
import br.com.unicred.parametrizacao.bi.impl.business.validators.CommandValidator;

import javax.validation.constraints.NotNull;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosCommand {

    @NotNull
    @FieldName("Id")
    private Integer id;
    @FieldName("Codigo Cooperativa")
    private Integer codigoCooperativa;
    @FieldName("Codigo Conta Estrutural")
    private String codigoContaEstrutural;
    @FieldName("Comparacao")
    private String comparacao;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void validate() {
        CommandValidator<DefinicaoContasContabeisOrcadoRealizadoProjetosCommand> validator =
                new CommandValidator<DefinicaoContasContabeisOrcadoRealizadoProjetosCommand>();
        validator.validate(this);
    }
}