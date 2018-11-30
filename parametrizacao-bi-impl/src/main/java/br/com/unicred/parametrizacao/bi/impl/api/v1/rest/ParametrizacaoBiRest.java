package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.multidb.config.DatasourceContextHolder;
import br.com.unicred.parametrizacao.bi.api.v1.BancoPagadorDTO;
import br.com.unicred.parametrizacao.bi.api.v1.ParametrizacaoBiEndpoint;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping(value = "/parametrizacao/bi/v1")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1", version="v1", title="ParametrizacaoBi API")
public class ParametrizacaoBiRest implements ParametrizacaoBiEndpoint {

	public static final Logger LOGGER = LoggerFactory.getLogger(ParametrizacaoBiRest.class);

	@Autowired
	public ParametrizacaoBiRest() {
		
	}

	@RequestMapping(value = "/bancos", method = RequestMethod.GET)
	@ApiOperation(value = "Busca o banco pagador do tributo.", response = BancoPagadorDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tipoCodigoTributo", required = true, dataType = "string", paramType = "query", value = "'D' para Darf - 'S' para GPS adicionado o Código da Receita ou da Previdência - Exemplo: S2909 para GPS de Reclamatória Trabalhista CNPJ."),
		@ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa"),
		@ApiImplicitParam(name = "token", required = true, dataType = "string", paramType = "header", value = "Token JWT de Autenticação"), })
	@ApiResponses({ @ApiResponse(code = 200, message = "Requisição executada com sucesso."),
		@ApiResponse(code = 400, message = "Requisição com parâmetros ruins."),
		@ApiResponse(code = 422, message = "Erro de negócio ou validação."),
		@ApiResponse(code = 500, message = "Erro não esperado.") })
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping(value = "/bancos")
	@Override
	public ResponseEntity<BancoPagadorDTO> buscarBancoPagador(
			@RequestParam("tipoCodigoTributo") final String tipoCodigoTributo,
			@RequestHeader("cooperativa") final Integer cooperativa, @RequestHeader("token") final String token) {

		DatasourceContextHolder.setCooperativa(cooperativa);
		

		return  null;

	}
}
