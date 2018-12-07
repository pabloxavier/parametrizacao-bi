package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.domain.SiglaContabil;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.SiglaContabilDAO;

@Service
public class SiglasContabilService {

	@Autowired
	private SiglaContabilDAO dao;
	
	public List<SiglaContabil> buscaSiglasContabeis() {
        return dao.buscaSiglasContabeis();
    }
	
}
