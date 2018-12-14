package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.IgnoraPostoDreRepresentation;
import br.com.unicred.parametrizacao.bi.api.v1.representation.PeriodoFechamentoRRRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.IgnoraPostoDreConverter;
import br.com.unicred.parametrizacao.bi.impl.business.converters.PeriodoFechamentoRRConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RestExceptionHandler;
import br.com.unicred.parametrizacao.bi.impl.business.services.PeriodoFechamentoRRService;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/periodofechamentorr/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Período Fechamento Rating Ranking API")
public class PeriodoFechamentoRRRest extends RestExceptionHandler {

   private PeriodoFechamentoRRService periodoFechamentoRRService;

   @Autowired
   public PeriodoFechamentoRRRest(PeriodoFechamentoRRService periodoFechamentoRRService) {
       this.periodoFechamentoRRService = periodoFechamentoRRService;
   }

   @RequestMapping(value = "/listar'", method = RequestMethod.GET)
   public ResponseEntity<List<PeriodoFechamentoRRRepresentation>> buscar(@RequestHeader("Authorization") final String token) {
       List<PeriodoFechamentoRR> periodoList = periodoFechamentoRRService.buscaPeriodoFechamentoRR();
       return ResponseEntity.ok(PeriodoFechamentoRRConverter.from(periodoList));
   }
     

   @RequestMapping(value = "/inserir", method = RequestMethod.POST)
   public ResponseEntity<PeriodoFechamentoRRRepresentation> inserir(@RequestHeader("Authorization") final String token,
                                                                    @RequestBody PeriodoFechamentoRRCommand comando) {

	   PeriodoFechamentoRR dominio = periodoFechamentoRRService.inserirPeriodoFechamentoRR(comando);
	   
       return ResponseEntity.ok(PeriodoFechamentoRRConverter.from(dominio));
   }

}