package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.validators.DefinicaoContasContabeisOrcadoRealizadoProjetosValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.DefinicaoContasContabeisOrcadoRealizadoProjetosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefinicaoContasContabeisOrcadoRealizadoProjetosService {


    private DefinicaoContasContabeisOrcadoRealizadoProjetosDAO dao;
    private DefinicaoContasContabeisOrcadoRealizadoProjetosValidator validator;

    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosService(
            DefinicaoContasContabeisOrcadoRealizadoProjetosDAO dao,
            DefinicaoContasContabeisOrcadoRealizadoProjetosValidator validator) {
        this.dao = dao;
        this.validator = validator;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasAtivas(){
        return dao.buscarContasAtivas();
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasInativas(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorCooperativa(Integer cdCoop){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorConta(String conta){
        return null;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos buscaPorId(Integer id){
        return dao.buscaPorId(id);
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos salvarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command) {
        validator.validateInsert(command);
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = DefinicaoContasContabeisOrcadoRealizadoProjetos.criarDefinicaoContasContabeisOrcadoRealizadoProjetos(command);
        return dao.inserirContaContabil(conta);
    }
    public boolean editarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command, Integer id){
        return dao.editarContaContabil(command, id);
    }

    public boolean excluirContaContabelPorId(Integer id){
        return dao.excluirContaContabelPorId(id);
    }

    public boolean excluirContaContabelPorConta(String codigoContaEstrutural){
        return dao.excluirContaContabelPorConta(codigoContaEstrutural);
    }

    public boolean excluirContaContabelPorCooperativa(Integer codigoCooperativa){
        return dao.excluirContaContabelPorCooperativa(codigoCooperativa);
    }
}
