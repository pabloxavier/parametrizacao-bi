package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.validators.IgnoraPostoDreValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IgnoraPostoDreDAO;

@Service
public class IgnoraPostoDreService {

    private IgnoraPostoDreDAO ignoraPostoDreDAO;
    private IgnoraPostoDreValidator validator;
    
    @Autowired
    public IgnoraPostoDreService(IgnoraPostoDreDAO ignoraPostoDreDAO, IgnoraPostoDreValidator validator) {
        this.ignoraPostoDreDAO = ignoraPostoDreDAO;
        this.validator = validator;
    }
    
    public List<IgnoraPostoDre> buscaPostosIgnorados() {
        List<IgnoraPostoDre> postosIgnorados = ignoraPostoDreDAO.buscaPostosIgnorados();
        if (postosIgnorados.isEmpty()) {
            throw new NotFoundException("Não foram encontrados postos ignorados.");
        }    
        return postosIgnorados;
    }

    public List<IgnoraPostoDre> buscaPostosIgnoradosByCoop(final Integer cdCoop) {
        List<IgnoraPostoDre> postosIgnoradosList = ignoraPostoDreDAO.buscaPostosIgnoradosByCoop(cdCoop);
        if (postosIgnoradosList.size() == 0) {
            throw new NotFoundException(String.format("Não foram encontrados postos ignorados na cooperativa %d.", cdCoop));
        }
        return postosIgnoradosList;
    }
    
    public IgnoraPostoDre inserirPostoIgnorado(final IgnoraPostoDreCommand comando) {
        validator.validateInsert(comando);
        
        IgnoraPostoDre ignoraPostoDre = IgnoraPostoDre.criar(comando);
        ignoraPostoDreDAO.inserirPostoIgnorado(ignoraPostoDre);
        return ignoraPostoDre;
    }
    
    public String excluirPostoIgnorado(final IgnoraPostoDreCommand comando) {
        validator.validateDelete(comando);
        
        ignoraPostoDreDAO.excluirPostoIgnorado(comando);
        return String.format("Posto %d ignorado na cooperativa %d excluído com sucesso.", comando.getCodigoPosto(), comando.getCodigoCooperativa());
    }    

}
