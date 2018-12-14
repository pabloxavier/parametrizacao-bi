package dominio;

import org.junit.Before;
import org.junit.Test;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;

public class PostoTest {

	Cooperativa cooperativa;

	@Before
	public void inicializa() {
		cooperativa = new Cooperativa();
		cooperativa.setCdCoop(1);
		cooperativa.setFlgAtivo("S");
		cooperativa.setNmCoop("123");
		cooperativa.setSigla("RS");

	}

	@Test
	public void cadastrarCooperativa() {

		cooperativa.setCdCoop(1);
		cooperativa.setFlgAtivo("S");
		cooperativa.setNmCoop("123");
		cooperativa.setSigla("RS");

	}
	
	

}
