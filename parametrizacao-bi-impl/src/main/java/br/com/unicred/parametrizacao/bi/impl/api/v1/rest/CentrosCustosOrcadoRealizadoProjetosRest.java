package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.representation.CentrosCustosOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.api.v1.representation.CooperativaRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.converters.CentrosCustosOrcadoRealizadoProjetosConverter;
import br.com.unicred.parametrizacao.bi.impl.business.converters.CooperativaConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.services.CentrosCustosOrcadoRealizadoProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/parametrizacao/bi/v1/centros-custos-realizados-orcado-projetos/")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Centros Custos Orcado Realizado Projetos API")
public class CentrosCustosOrcadoRealizadoProjetosRest {

    private CentrosCustosOrcadoRealizadoProjetosService serviceCentrosCustosOrcadoRealizadoProjetosService;

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosRest(CentrosCustosOrcadoRealizadoProjetosService serviceCentrosCustosOrcadoRealizadoProjetosService) {
        this.serviceCentrosCustosOrcadoRealizadoProjetosService = serviceCentrosCustosOrcadoRealizadoProjetosService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CentrosCustosOrcadoRealizadoProjetosRepresentation>> buscarTodos(@RequestHeader(name = "Authorization") final String token) {

        List<CentrosCustosOrcadoRealizadoProjetos> comando = serviceCentrosCustosOrcadoRealizadoProjetosService.buscarTodos();
        return ResponseEntity.ok(CentrosCustosOrcadoRealizadoProjetosConverter.from(comando));
    }
}

