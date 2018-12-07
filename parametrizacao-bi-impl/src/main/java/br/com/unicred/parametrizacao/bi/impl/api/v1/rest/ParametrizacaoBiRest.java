package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.impl.business.commands.CooperativaCommand;
import br.com.unicred.parametrizacao.bi.impl.business.services.CooperativaService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/parametrizacao/bi/v1")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1", version="v1", title="ParametrizacaoBi API")
public class ParametrizacaoBiRest extends DefaultEndpoint {

	public static final Logger LOGGER = LoggerFactory.getLogger(ParametrizacaoBiRest.class);
    private CooperativaService cooperativaService;
    
    @Autowired
    public ParametrizacaoBiRest(CooperativaService cooperativaService) {
        this.cooperativaService = cooperativaService;
    }

	@RequestMapping(value = "/algo", method = RequestMethod.GET)
	@ApiOperation(value = "Busca algo.", response = String.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa") })
	@ApiResponses({ @ApiResponse(code = 200, message = "Requisição executada com sucesso."),
		@ApiResponse(code = 400, message = "Requisição com parâmetros ruins."),
		@ApiResponse(code = 422, message = "Erro de negócio ou validação."),
		@ApiResponse(code = 500, message = "Erro não esperado.") })
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping(value = "/algo")
	public ResponseEntity<?> buscarAlgo(
			@RequestHeader("cooperativa") final Integer cooperativa, 
			@RequestHeader("Authorization") final String token) {

        List<CooperativaCommand> coopsList = cooperativaService.buscaCooperativas(cooperativa);
        for (CooperativaCommand coop : coopsList) {
            System.out.println(coop.getCdCoop() + " - " + coop.getSigla().trim() + " - " + coop.getNmCoop());
        }
        System.out.println("------------------------------------------------");
        
        return ok();

	}
}
