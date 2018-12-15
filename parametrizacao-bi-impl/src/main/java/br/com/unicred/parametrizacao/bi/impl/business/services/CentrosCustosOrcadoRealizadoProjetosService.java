package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.arch.handler.exception.BusinessException;
import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.validators.CentrosCustosOrcadoRealizadoProjetosValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CentrosCustosOrcadoRealizadoProjetosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentrosCustosOrcadoRealizadoProjetosService {

    private Logger log = LoggerFactory.getLogger(CentrosCustosOrcadoRealizadoProjetosService.class);
    private CentrosCustosOrcadoRealizadoProjetosDAO dao;
    private CentrosCustosOrcadoRealizadoProjetosValidator validator;

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosService(CentrosCustosOrcadoRealizadoProjetosDAO dao,
                                                       CentrosCustosOrcadoRealizadoProjetosValidator validator) {
        this.dao = dao;
        this.validator = validator;
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarTodos(){
        return dao.buscarTodos();
    }

    public CentrosCustosOrcadoRealizadoProjetos salvar(CentrosCustosOrcadoRealizadoProjetosCommand comando){
        validator.validate(comando);
        validaExistenciaPorCooperativaEPosto(comando.getCodigoCooperativa(), comando.getCodigoPosto());
        CentrosCustosOrcadoRealizadoProjetos centrosCustosOrcadoRealizadoProjetos = CentrosCustosOrcadoRealizadoProjetos.criar(comando);
        return dao.inserir(centrosCustosOrcadoRealizadoProjetos);
    }

    public CentrosCustosOrcadoRealizadoProjetos atualizar(CentrosCustosOrcadoRealizadoProjetosCommand comando, Integer cooperativa, Integer posto){
        validator.validate(comando);
        validaExistenciaPorCooperativaEPosto(comando.getCodigoCooperativa(), comando.getCodigoPosto());
        CentrosCustosOrcadoRealizadoProjetos centrosCustosOrcadoRealizadoProjetos = CentrosCustosOrcadoRealizadoProjetos.criar(comando);
        return dao.atualizar(centrosCustosOrcadoRealizadoProjetos, cooperativa, posto);
    }

    public CentrosCustosOrcadoRealizadoProjetos excluir(CentrosCustosOrcadoRealizadoProjetosCommand comando){
        validator.validate(comando);
        CentrosCustosOrcadoRealizadoProjetos centrosCustosOrcadoRealizadoProjetos = CentrosCustosOrcadoRealizadoProjetos.criar(comando);
        return dao.excluir(centrosCustosOrcadoRealizadoProjetos);
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarPorCooperativa(Integer cooperativa){
        validator.validate(cooperativa);
        return dao.buscarByCooperativa(cooperativa);
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarPorPosto(Integer posto){
        validator.validate(posto);
        return dao.buscarByPosto(posto);
    }

    public CentrosCustosOrcadoRealizadoProjetos buscarPorCooperativaEPosto(Integer cooperativa, Integer posto){
        CentrosCustosOrcadoRealizadoProjetosCommand command = new CentrosCustosOrcadoRealizadoProjetosCommand();
        command.setCodigoCooperativa(cooperativa);
        command.setCodigoPosto(posto);
        validator.validate(command);
        return dao.buscarByCooperativaEPosto(cooperativa, posto);
    }

    private void validaExistenciaPorCooperativaEPosto(Integer cooperativa, Integer posto){
        if (dao.isCentroCustoExistsPorCooperativaEPosto(cooperativa, posto)) {
            log.warn("Centro custo orçado realizado por projetos já existente.");
            throw new BusinessException("Centro custo orçado realizado por projetos já existente.");
        }
    }
}
