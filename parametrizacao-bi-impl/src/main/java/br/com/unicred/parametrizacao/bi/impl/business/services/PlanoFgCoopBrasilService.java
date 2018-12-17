package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PlanoFgCoopBrasil;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PlanoFgCoopBrasilDAO;

@Service
public class PlanoFgCoopBrasilService {

    private PlanoFgCoopBrasilDAO planoFgCoopBrasilDAO;

    @Autowired
    public PlanoFgCoopBrasilService(PlanoFgCoopBrasilDAO planoFgCoopBrasilDAO) {
        this.planoFgCoopBrasilDAO = planoFgCoopBrasilDAO;
    }

    public List<PlanoFgCoopBrasil> buscaContaBacen() {
        List<PlanoFgCoopBrasil> planoFgCoopBrasil = planoFgCoopBrasilDAO.buscaContaBacen();

        if (planoFgCoopBrasil.isEmpty()) {
            throw new NotFoundException("Não foram encontradas contas bacen.");
        }    
        return planoFgCoopBrasil;
    }
    
    public PlanoFgCoopBrasil buscaContaBacenByCodigo(final String codigoContaBacen) {
    	PlanoFgCoopBrasil planoFgCoopBrasil = planoFgCoopBrasilDAO.buscaContaBacenByCodigo(codigoContaBacen);

        return planoFgCoopBrasil;
    }

    public PlanoFgCoopBrasil inserirContaBacen(final PlanoFgCoopBrasilCommand comando) {
    	
    	PlanoFgCoopBrasil planoFgCoopBrasil = PlanoFgCoopBrasil.criar(comando);
    	planoFgCoopBrasilDAO.inserirContaBacen(planoFgCoopBrasil);
    	return planoFgCoopBrasil;
    }

    public PlanoFgCoopBrasil alterarContaBacen(final PlanoFgCoopBrasilCommand comando, final String codigoContaBacen) {
        
    	PlanoFgCoopBrasil planoFgCoopBrasil = PlanoFgCoopBrasil.alterar(comando ,codigoContaBacen);
    	planoFgCoopBrasilDAO.alterarContaBacen(planoFgCoopBrasil, codigoContaBacen);
    	return planoFgCoopBrasil;
    }

    public String excluirContaBacen(final String codigoContaBacen) {
    	
    	planoFgCoopBrasilDAO.excluirContaBacen(codigoContaBacen);
        return String.format("Conta Bacen %s excluída com sucesso.", codigoContaBacen);
    }    
    

}
