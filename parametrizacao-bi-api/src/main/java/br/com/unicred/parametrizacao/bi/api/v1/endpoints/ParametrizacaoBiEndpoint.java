package br.com.unicred.parametrizacao.bi.api.v1.endpoints;

import org.springframework.http.ResponseEntity;

public interface ParametrizacaoBiEndpoint {

    ResponseEntity<?> buscarAlgo(final Integer cooperativa, final String token);
	//ResponseEntity<?> buscarCooperativa(final Integer cooperativa, final String token);
}