package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PostoDAO;

@Service
public class PostoService {

    @Autowired
    private PostoDAO dao;

    public List<Posto> buscaPostos(final Integer cooperativa, final Integer posto, final Boolean inAtivos) {
        List<Posto> postos = dao.buscaPostos(cooperativa, posto, inAtivos); 
        if (postos.isEmpty()) {
            throw new NotFoundException("Não foi encontrado nenhum posto.");
        }    
        return postos;
    }

    public Posto getPostoById(final Integer cooperativa, final Integer posto) {
        return dao.getPostoByPostoAndCoop(cooperativa, posto);
    }
}
