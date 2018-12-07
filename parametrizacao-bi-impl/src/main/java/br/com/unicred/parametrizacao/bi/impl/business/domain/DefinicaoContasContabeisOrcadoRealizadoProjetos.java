package br.com.unicred.parametrizacao.bi.impl.business.domain;
import br.com.unicred.parametrizacao.bi.api.v1.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;

public class DefinicaoContasContabeisOrcadoRealizadoProjetos {

    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    private String comparacao;
    private Boolean excluir;

    protected DefinicaoContasContabeisOrcadoRealizadoProjetos() {

    }

    public static DefinicaoContasContabeisOrcadoRealizadoProjetos criarDefinicaoContasContabeisOrcadoRealizadoProjetos
            (DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command) {

        command.validate();

        return new DefinicaoContasContabeisOrcadoRealizadoProjetos(command);
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command) {
        this.codigoCooperativa = command.getCodigoCooperativa();
        this.codigoContaEstrutural = command.getCodigoContaEstrutural();
        this.comparacao = command.getComparacao();
        this.excluir = Boolean.FALSE;
    }

    public String getCodigoContaEstrutural() {
        return codigoContaEstrutural;
    }

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public String getComparacao() {
        return comparacao;
    }

    public Boolean getExcluir() {
        return excluir;
    }
}