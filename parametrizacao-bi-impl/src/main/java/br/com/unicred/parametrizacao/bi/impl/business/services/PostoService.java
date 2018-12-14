package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PostoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PostoDAO;

@Service
public class PostoService {

    @Autowired
    private PostoDAO dao;

    public List<PostoCommand> buscaPostos() {
        return dao.buscaPostos();
    }

    public boolean inserirPosto(Posto posto) {
        return dao.inserirPosto(posto);
    }
}
