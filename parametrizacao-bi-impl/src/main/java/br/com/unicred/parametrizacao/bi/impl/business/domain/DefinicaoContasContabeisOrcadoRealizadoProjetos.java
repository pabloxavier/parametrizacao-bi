package br.com.unicred.parametrizacao.bi.impl.business.domain;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;

public class DefinicaoContasContabeisOrcadoRealizadoProjetos {

    private Integer id;
    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    private String comparacao;
    private Boolean excluir;


    protected DefinicaoContasContabeisOrcadoRealizadoProjetos() {

    }

    public static DefinicaoContasContabeisOrcadoRealizadoProjetos criarDefinicaoContasContabeisOrcadoRealizadoProjetos
            (DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command) {

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

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public void setCodigoContaEstrutural(String codigoContaEstrutural) {
        this.codigoContaEstrutural = codigoContaEstrutural;
    }

    public void setComparacao(String comparacao) {
        this.comparacao = comparacao;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }
}