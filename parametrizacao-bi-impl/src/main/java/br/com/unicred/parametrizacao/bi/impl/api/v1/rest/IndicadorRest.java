package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.impl.business.services.IndicadorService;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Indicador;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/cooperativa/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Indicador API")
public class IndicadorRest extends DefaultEndpoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(IndicadorRest.class);
    private IndicadorService indicadorService;

    @Autowired
    public IndicadorRest(IndicadorService indicadorService) {
        this.indicadorService = indicadorService;
    }

    @RequestMapping(value = "/indicador", method = RequestMethod.GET)
    @ApiOperation(value = "Busca a lista de indicadores.", response = Indicador.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa")})
    @ApiResponses({@ApiResponse(code = 200, message = "Requisição executada com sucesso."),
            @ApiResponse(code = 400, message = "Requisição com parâmetros ruins."),
            @ApiResponse(code = 422, message = "Erro de negócio ou validação."),
            @ApiResponse(code = 500, message = "Erro não esperado.")})
    @CrossOrigin(allowedHeaders = "*")
    public ResponseEntity<?> buscarIndicadores(
            @RequestHeader("cooperativa") final Integer cooperativa,
            @RequestHeader("Authorization") final String token) {
        return ok("Não implementado");
    }

    @RequestMapping(value = "/indicador/{codigo}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca um indicador específico.", response = Indicador.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperativa", required = true, dataType = "integer", paramType = "header", value = "código da cooperativa")})
    @ApiResponses({@ApiResponse(code = 200, message = "Requisição executada com sucesso."),
            @ApiResponse(code = 400, message = "Requisição com parâmetros ruins."),
            @ApiResponse(code = 422, message = "Erro de negócio ou validação."),
            @ApiResponse(code = 500, message = "Erro não esperado.")})
    @CrossOrigin(allowedHeaders = "*")
    public ResponseEntity<?> buscarIndicador(
            @RequestHeader("cooperativa") final Integer cooperativa,
            @RequestHeader("Authorization") final String token,
            @PathVariable("codigo") Integer codigo) {
        return ok("Não implementado");
    }
}
