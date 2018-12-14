package dominio;

import org.junit.Before;
import org.junit.Test;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;

public class coperativaTest {

	Posto posto;
	

	@Before
	public void inicializa() {
		posto = new Posto();
		posto.setCdCoop(123);
		posto.setFlgAtivo("S");
		posto.setNmPosto("Porto Alegre");
		posto.setCdPosto(222);
		posto.setSiglaPosto("POA");

	}

	@Test
	public void cadastrarPosto() {

		posto.setCdCoop(123);
		posto.setFlgAtivo("S");
		posto.setNmPosto("Porto Alegre");
		posto.setCdPosto(222);
		posto.setSiglaPosto("POA");

	}
	
	

}
