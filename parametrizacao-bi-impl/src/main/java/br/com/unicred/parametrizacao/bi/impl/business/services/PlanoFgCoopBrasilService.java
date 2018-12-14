package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PlanoFgCoopBrasilDAO;

@Service
public class PlanoFgCoopBrasilService {

    @Autowired
    private PlanoFgCoopBrasilDAO dao;

    public List<PlanoFgCoopBrasilCommand> buscaContaBacen() {
        return dao.buscaContaBacen();
    }

}
