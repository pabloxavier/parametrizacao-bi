package br.com.unicred.parametrizacao.bi.impl.api.v1.rest;

import br.com.unicred.arch.swagger.annotation.UnicredSwaggerAPI;
import br.com.unicred.parametrizacao.bi.api.v1.endpoints.DefaultEndpoint;
import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.converters.DefinicaoContasContabeisOrcadoRealizadoProjetosConverter;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.services.DefinicaoContasContabeisOrcadoRealizadoProjetosService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*")
@UnicredSwaggerAPI(basePath="/parametrizacao/bi/v1/", version="v1", title="Contas Contabeis Orcado Realizado Projetos API")
@RestController
@RequestMapping("/parametrizacao/bi/v1/ContasContabeisOrcadoRealizadoProjetos")
public class DefinicaoContasContabeisOrcadoRealizadoProjetosRest extends DefaultEndpoint {
    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosService service;


    @RequestMapping(value = "/listarContas", method = RequestMethod.GET)
    public ResponseEntity<?> listarContas(@RequestHeader("Authorization") final String token) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarContas();
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }

    @RequestMapping(value = "/listarContasInativas", method = RequestMethod.GET)
    public ResponseEntity<?> listarContasInativas(@RequestHeader("Authorization") final String token) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarContasInativas();
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }


    @RequestMapping(value = "/listarContasAtivas", method = RequestMethod.GET)
    public ResponseEntity<?> listarContasAtivas(@RequestHeader("Authorization") final String token) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarContasAtivas();
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }

    @RequestMapping(value = "/listarContasPorCooperativa/{codigoCooperativa}", method = RequestMethod.GET)
    public ResponseEntity<?> listarPorCooperativa(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigoCooperativa") final Integer cdCoop) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarPorCooperativa(cdCoop);
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }

    @RequestMapping(value = "/listarContasPorContaEstrutural/{codigoConta}", method = RequestMethod.GET)
    public ResponseEntity<?> listarPorContaEstrutural(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigoConta") final String codigoConta) {
        List<DefinicaoContasContabeisOrcadoRealizadoProjetos> contas = service.listarPorContaEstrutural(codigoConta);
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(contas));
    }

    @RequestMapping(value = "/listarContasPorCodigo/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<?> listarPorCodigo(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigo") final Integer codigo) {
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = service.listarContasPorCodigo(codigo);
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(conta));
    }


    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<?> inserir(@RequestHeader("Authorization") final String token,
                                               @RequestBody DefinicaoContasContabeisOrcadoRealizadoProjetosCommand comando) {
        DefinicaoContasContabeisOrcadoRealizadoProjetos conta = service.salvarContaContabil(comando);
        return ok(DefinicaoContasContabeisOrcadoRealizadoProjetosConverter.from(conta));
    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<?> alterar(@RequestHeader("Authorization") final String token,
                                     @RequestBody DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand comando) {
     boolean confirma = service.editarContaContabil(comando);
        return ok("Conta alterada com sucesso");
    }

    @RequestMapping(value = "/excluirContasPorCodigo/{codigo}", method = RequestMethod.PUT)
    public ResponseEntity<?> excluirContaPorId(@RequestHeader("Authorization") final String token,
                                               @PathVariable("codigo") final Integer codigo) {
        boolean excluido = service.excluirContaContabilPorId(codigo);
        return ok("Codigo excluido com sucesso");
    }

    @RequestMapping(value = "/excluirContasPorContaEstrutural/{conta}", method = RequestMethod.PUT)
    public ResponseEntity<?> excluirContaEstrutural(@RequestHeader("Authorization") final String token,
                                          @PathVariable("conta") final String conta) {
        boolean excluido = service.excluirContaContabilPorContaEStrutural(conta);
        return ok("Conta excluida com sucesso");
    }

    @RequestMapping(value = "/excluirContasPorCooperativa/{codigoCooperativa}", method = RequestMethod.PUT)
    public ResponseEntity<?> excluirConta(@RequestHeader("Authorization") final String token,
                                          @PathVariable("codigoCooperativa") final Integer cdCoop) {
        boolean excluido = service.excluirContaContabilPorCooperativa(cdCoop);
        return ok("Contas da Cooperativa excluidas com sucesso");
    }

}