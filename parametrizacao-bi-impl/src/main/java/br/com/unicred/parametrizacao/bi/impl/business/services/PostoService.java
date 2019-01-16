package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PostoDAO;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.utils.Constants;

@Service
public class PostoService {

    @Autowired
    private PostoDAO dao;

    public List<Posto> buscaPostos(final Integer cdCoop, final Integer cdPosto, final Boolean inAtivos) {
        List<Posto> postos = dao.buscaPostos(cdCoop, cdPosto, inAtivos); 
        if (postos.isEmpty()) {
            throw new NotFoundException("Nenhum posto foi encontrado com os parâmetros informados.");
        }    
        return postos;
    }

    public Posto getPostoById(final Integer cdCoop, final Integer cdPosto, Boolean isValidacao) {
        Posto posto = dao.getPostoByPostoAndCoop(cdCoop, cdPosto);
        if ((null == posto && !isValidacao) || (isValidacao && !cdCoop.equals(Constants.COOP_UBR))) {
            throw new NotFoundException(String.format("Não foi encontrado o posto %d da cooperativa %d.", cdPosto, cdCoop));
        }
        return posto;
    }
}
