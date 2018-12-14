package endpoit;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;


public class CooperativaRestTest {

	
	
	@Test
	public void deveListarCooperarivas() {
		
	String baseUrl = "http://localhost:8080/parametrizacao/bi/v1/cooperativa/listar";
	
	given()
	.header("Authorization","1")
	.when()
	   .get(baseUrl)
	.then()
	   .statusCode(200);
	 
	}
	
//	@Test
//	public void deveBuscarCooperativaPeloCodigo() {
//		
//	String baseUrl = "http://localhost:8080/parametrizacao/bi/v1/cooperativa/listar";
//	
//	given()
//	.header("Authorization","1")
//	.param("")
//	.when()
//	   .get(baseUrl)
//	.then()
//	   .statusCode(200);
//	 
//	}
}
