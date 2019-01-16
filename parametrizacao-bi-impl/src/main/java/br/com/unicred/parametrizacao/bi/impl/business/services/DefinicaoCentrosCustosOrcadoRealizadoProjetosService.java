package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoCentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.validators.DefinicaoCentrosCustosOrcadoRealizadoProjetosValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO;

@Service
public class DefinicaoCentrosCustosOrcadoRealizadoProjetosService {

    private DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO dao;
    private DefinicaoCentrosCustosOrcadoRealizadoProjetosValidator validator;
    private static final String MENSAGEM = "Definicao Centros Custos Orcado Realizado Projetos";
    
    @Autowired
    public DefinicaoCentrosCustosOrcadoRealizadoProjetosService(DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO dao, DefinicaoCentrosCustosOrcadoRealizadoProjetosValidator validator) {
        this.dao = dao;
        this.validator = validator;
    }
    
    public List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> listar() {
        List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> list = dao.listar();
        if (list.isEmpty()) {
            throw new NotFoundException(String.format("Não foram encontrados %s.", MENSAGEM));
        }    
        return list;
    }

    public List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> listarComFiltros(Integer cdCoop, String comparacao, String cdPosto, Boolean isExcluido) {
        List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> list = dao.listarComFiltros(cdCoop, comparacao, cdPosto, isExcluido);
        if (list.isEmpty()) {
            throw new NotFoundException(String.format("Não foram encontrados %s.", MENSAGEM));
        }
        return list;
    }
    
    public DefinicaoCentrosCustosOrcadoRealizadoProjetos inserir(final DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        validator.validateInsertUpdate(comando);
        
        DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio = DefinicaoCentrosCustosOrcadoRealizadoProjetos.criar(comando);
        dao.inserir(dominio);
        return dominio;
    }
    
    public DefinicaoCentrosCustosOrcadoRealizadoProjetos editar(Integer cdCoop, String comparacao, String cdPosto, DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        validator.validateInsertUpdate(comando);
        
        DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio = DefinicaoCentrosCustosOrcadoRealizadoProjetos.editar(comando);
        dao.editar(cdCoop, comparacao, cdPosto, dominio);
        return listarComFiltros(comando.getCodigoCooperativa(), comando.getComparacao(), comando.getCodigoPosto(), null).get(0);
    }
    
    public String excluir(final DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        validator.validateDelete(comando);
        
        dao.excluir(comando);
        return String.format("%s excluído com sucesso.", MENSAGEM);
    } 

}
