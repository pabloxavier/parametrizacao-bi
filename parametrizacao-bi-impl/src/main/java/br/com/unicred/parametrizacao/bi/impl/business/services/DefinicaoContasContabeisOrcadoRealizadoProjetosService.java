package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand;
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

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContas(){
        return dao.buscarContas();
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasAtivas(){
        return dao.buscarContasAtivas();
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasInativas(){
        return dao.buscarContasInativas();
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorCooperativa(Integer cdCoop){
        return dao.buscarContasPorCooperativa(cdCoop);
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorContaEstrutural(String conta){
        return dao.buscarContasPorContaEstrutural(conta);
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos listarContasPorCodigo(Integer id){
        return dao.buscaPorId(id);
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos salvarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command) {
        validator.validateInsert(command);
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = DefinicaoContasContabeisOrcadoRealizadoProjetos.criarDefinicaoContasContabeisOrcadoRealizadoProjetos(command);
        return dao.inserirContaContabil(conta);
    }
    public boolean editarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand command){
        validator.validateEdicao(command);
        return dao.editarContaContabil(command);
    }

    public boolean excluirContaContabilPorId(Integer id){
        validator.validateExclusao(id);
        return dao.excluirContaContabelPorId(id);
    }

    public boolean excluirContaContabilPorContaEStrutural(String codigoContaEstrutural){
        return dao.excluirContaContabelPorContaEstrutural(codigoContaEstrutural);
    }

    public boolean excluirContaContabilPorCooperativa(Integer codigoCooperativa){
        return dao.excluirContaContabelPorCooperativa(codigoCooperativa);
    }
}
