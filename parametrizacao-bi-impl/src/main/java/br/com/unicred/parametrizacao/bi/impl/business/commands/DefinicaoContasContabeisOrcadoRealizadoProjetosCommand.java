package br.com.unicred.parametrizacao.bi.api.v1.commands;
br.com.unicred.parametrizacao.bi.impl.business.validators;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosCommand {

    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
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

    public void validate() {
        CommandValidator<DefinicaoContasContabeisOrcadoRealizadoProjetosCommand> validator =
                new CommandValidator<DefinicaoContasContabeisOrcadoRealizadoProjetosCommand>();
        validator.validate(this);
    }
}