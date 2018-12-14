package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.SiglaContabilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.SiglaContabilConverter;
import br.com.unicred.parametrizacao.bi.impl.business.services.SiglaContabilService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/siglacontabil/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Sigla Contabil API")
public class SiglaContabilRest {

	private SiglaContabilService siglaContabilService;
	
	private SiglaContabilConverter siglaContabilConverter;
	
	@Autowired
	public SiglaContabilRest(SiglaContabilService siglaContabilService, SiglaContabilConverter siglaContabilConverter) {
		this.siglaContabilService = siglaContabilService;
		this.siglaContabilConverter = siglaContabilConverter;
	}
	
	@RequestMapping(value = "/listar'", method = RequestMethod.GET)
    public ResponseEntity<List<SiglaContabilCommand>> buscar(@RequestHeader("Authorization") final String token) {
        List<SiglaContabilCommand> siglas = siglaContabilConverter.convertList(siglaContabilService.buscaSiglasContabeis());
        return ResponseEntity.ok(siglas);
    }
	
}
