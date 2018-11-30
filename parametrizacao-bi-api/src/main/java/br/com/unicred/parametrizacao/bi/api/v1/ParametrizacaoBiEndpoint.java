package br.com.unicred.parametrizacao.bi.api.v1;

import org.springframework.http.ResponseEntity;

public interface ParametrizacaoBiEndpoint {


	ResponseEntity<BancoPagadorDTO> buscarBancoPagador(final String tipoCodigoTributo, final Integer cooperativa,
			final String token);

}
