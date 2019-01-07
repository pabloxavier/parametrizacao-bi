package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.ContasContabeisOrcadoRealizadoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.ContasContabeisOrcadoRealizado;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.validators.ContasContabeisOrcadoRealizadoValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.ContasContabeisOrcadoRealizadoDAO;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.utils.ContasContabeisOrcadoRealizadoUtils;

@Service
public class ContasContabeisOrcadoRealizadoService {

    private ContasContabeisOrcadoRealizadoDAO dao;
    private ContasContabeisOrcadoRealizadoValidator validator;
    
    @Autowired
    public ContasContabeisOrcadoRealizadoService(ContasContabeisOrcadoRealizadoDAO dao, ContasContabeisOrcadoRealizadoValidator validator) {
        this.dao = dao;
        this.validator = validator;
    }
    
    public List<ContasContabeisOrcadoRealizado> listarContasContabeisOrcadoRealizado(Boolean isProjeto) {
        List<ContasContabeisOrcadoRealizado> contasContabeisOrcadoRealizado = dao.listarContasContabeisOrcadoRealizado(isProjeto);
        if (contasContabeisOrcadoRealizado.isEmpty()) {
            String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
            throw new NotFoundException(String.format("Não foram encontradas %s.", mensagem));
        }    
        return contasContabeisOrcadoRealizado;
    }

    public List<ContasContabeisOrcadoRealizado> listarContasContabeisOrcadoRealizadoByCoop(final Integer cdCoop, final Boolean isProjeto) {
        List<ContasContabeisOrcadoRealizado> list = dao.listarContasContabeisOrcadoRealizadoByCoop(cdCoop, isProjeto);
        if (list.isEmpty()) {
            String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
            throw new NotFoundException(String.format("Não foram encontradas %s na cooperativa %d.", mensagem, cdCoop));
        }
        return list;
    }
    
    public ContasContabeisOrcadoRealizado buscaContaContabilOrcadoRealizadoByCoopAndConta(final Integer cdCoop, String cdConta, final Boolean isProjeto) {
        ContasContabeisOrcadoRealizado result = dao.buscaContaContabilOrcadoRealizadoByCoopAndConta(cdCoop, cdConta, isProjeto);
        if (null == result) {
            String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
            throw new NotFoundException(String.format("Não foram encontradas %s na cooperativa %d e conta %s.", mensagem, cdCoop, cdConta));
        }
        return result;
    }    
    
    public ContasContabeisOrcadoRealizado inserir(final ContasContabeisOrcadoRealizadoCommand comando, Boolean isProjeto) {
        validator.validateInsert(comando, isProjeto);
        
        ContasContabeisOrcadoRealizado contasContabeisOrcadoRealizado = ContasContabeisOrcadoRealizado.criar(comando);
        dao.inserir(contasContabeisOrcadoRealizado, isProjeto);
        return contasContabeisOrcadoRealizado;
    }
    
    public String excluir(final ContasContabeisOrcadoRealizadoCommand comando, Boolean isProjeto) {
        validator.validateDelete(comando, isProjeto);
        
        dao.excluirPostoIgnorado(comando, isProjeto);
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        return String.format("%s da cooperativa %d e conta %s excluída com sucesso.", mensagem, comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural());
    }     

}
