package br.com.unicred.parametrizacao.bi.impl.business.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.ContasContabeisOrcadoRealizadoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.ContasContabeisOrcadoRealizado;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RegistroJaExistenteException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.ContasContabeisOrcadoRealizadoDAO;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.utils.ContasContabeisOrcadoRealizadoUtils;

@Component
public class ContasContabeisOrcadoRealizadoValidator {
    
    private CooperativaValidator cooperativaValidator;
    private ContasContabeisOrcadoRealizadoDAO dao;
    
    @Autowired    
    public ContasContabeisOrcadoRealizadoValidator(CooperativaValidator cooperativaValidator, ContasContabeisOrcadoRealizadoDAO dao) {
        this.cooperativaValidator = cooperativaValidator;
        this.dao = dao;
    }

    public void validateInsert(ContasContabeisOrcadoRealizadoCommand comando, final Boolean isProjeto) {      
        cooperativaValidator.existeCoop(comando.getCodigoCooperativa());
        validaConta(comando.getCodigoContaEstrutural());
        previneUnicidade(comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural(), isProjeto);
    }
    
    public void validateDelete(ContasContabeisOrcadoRealizadoCommand comando, final Boolean isProjeto) {      
        if (!existeRegistro(comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural(), isProjeto)){
            String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
            throw new NotFoundException(String.format("Não foi encontrada a %s da cooperativa %d e conta %s.", mensagem, comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural()));
        }
    }
    
    public void validaConta(String cdConta) {
        //TO-DO
    }
    
    public void previneUnicidade(final Integer cdCoop, final String cdConta, final Boolean isProjeto) {
        if (existeRegistro(cdCoop, cdConta, isProjeto)) {
            String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
            throw new RegistroJaExistenteException(String.format("Já existe %s para cooperativa %d e conta %s.", mensagem, cdCoop, cdConta));
        }
    }
    
    public Boolean existeRegistro(final Integer cdCoop, final String cdConta, final Boolean isProjeto) {
        ContasContabeisOrcadoRealizado registro = dao.buscaContaContabilOrcadoRealizadoByCoopAndConta(cdCoop, cdConta, isProjeto);
        return registro == null ? Boolean.FALSE : Boolean.TRUE;
    }

}
