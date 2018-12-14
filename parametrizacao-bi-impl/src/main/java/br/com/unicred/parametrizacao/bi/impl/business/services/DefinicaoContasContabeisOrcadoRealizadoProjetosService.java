package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.DefinicaoContasContabeisOrcadoRealizadoProjetosDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosService {

    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosDAO dao;

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasAtivas(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasInativas(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorCooperativa(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorConta(){
        return null;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos buscaPorId(Integer id){
        return dao.buscaPorId(id);
    }

    public boolean salvarContaContabel(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command){
        DefinicaoContasContabeisOrcadoRealizadoProjetos.criarDefinicaoContasContabeisOrcadoRealizadoProjetos(command);
        return dao.inserirContaContabel(command.getCodigoCooperativa(), command.getComparacao(), command.getCodigoContaEstrutural());
    }

    public boolean editarContaContabel(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command, Integer id){
        return dao.editarContaContabel(command.getCodigoCooperativa(), command.getComparacao(), command.getCodigoContaEstrutural(), command.getExcluir(), id);
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
