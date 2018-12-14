package br.com.unicred.parametrizacao.bi.impl.business.converters;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.api.v1.representation.SiglaContabilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.SiglaContabil;

@Component
public class SiglaContabilConverter {
	
	public SiglaContabilCommand toDTO(SiglaContabil entity) {
		SiglaContabilCommand command = new SiglaContabilCommand();
		command.setCodigo(entity.getCodigo());
		command.setSiglaContabil(entity.getSiglaContabil());
		command.setOrdem(entity.getOrdem());
		
		return(command);
		
	}
	
	public List<SiglaContabilCommand> convertList(List<SiglaContabil> entityList){
		List<SiglaContabilCommand> listCommand = new ArrayList<SiglaContabilCommand>();
		
		for (SiglaContabil entity : entityList) {
			SiglaContabilCommand c =  toDTO(entity);
			listCommand.add(c);
		}
		return listCommand;
	}

}
