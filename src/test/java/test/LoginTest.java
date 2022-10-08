package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page_object.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
	}
	
	@Test
	public void TC01_naoDeveLogarComLoginESenhaVazios() {
		
		loginPO.informarLoginESenha("", "");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Informe o login!"));
		
	}
	
	@Test
	public void TC02_naoDeveLogarComLoginInvalidoESenhaVazia() {
		
		loginPO.informarLoginESenha("jaghdjhag", "");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Informe a senha!"));
		
	}
	
	@Test
	public void TC03_naoDeveLogarComLoginVazioESenhaInvalida() {
		
		loginPO.informarLoginESenha("", "sajhsduaghs");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Informe o login!"));
		
	}
	
	@Test
	public void TC04_naoDeveLogarComLoginValidoESenhaVazia() {
		
		loginPO.informarLoginESenha("admin", "");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Informe a senha!"));
		
	}
	
	@Test
	public void TC05_naoDeveLogarComLoginVazioESenhaValida() {
		
		loginPO.informarLoginESenha("", "admin");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Informe o login!"));
		
	}
	
	@Test
	public void TC06_naoDeveLogarComLoginESenhaInvalidos() {
		
		loginPO.informarLoginESenha("uhaushausu", "sajhsduaghs");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Usuário não encontrado!"));
		
	}
	
	@Test
	public void TC07_naoDeveLogarComLoginValidoESenhaInvalida() {
		
		loginPO.informarLoginESenha("admin", "sajhsduaghs");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Usuário não encontrado!"));
		
	}
	
	@Test
	public void TC08_naoDeveLogarComLoginInvalidoESenhaValida() {
		
		loginPO.informarLoginESenha("asghduais", "admin");
		loginPO.acessar();
		
		String resultado = loginPO.mostrarMensagem();
		
		assertTrue(resultado, resultado.contains("Usuário não encontrado!"));
		
	}
	
	@Test
	public void TC09_deveLogarComLoginESenhaValidos() {
		
		loginPO.informarLoginESenha("admin", "admin");
		loginPO.acessar();
		
		String tituloPagina = loginPO.retornarTituloDaPagina();
		
		assertTrue(tituloPagina, tituloPagina.contains("Cadastro de Usuário"));
		
	}

}
