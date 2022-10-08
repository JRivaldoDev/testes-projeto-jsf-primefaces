package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page_object.CadastroUsuarioPO;
import page_object.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroUsuarioTest extends BaseTest {

	private static LoginPO loginPO;
	private static CadastroUsuarioPO usuarioPO;

	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
		usuarioPO = new CadastroUsuarioPO(driver);
	}
	
	@Test
	public void TC01_deveDeslogarAoClicarEmLogout() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String resultado = loginPO.retornarTituloDaPagina();
		assertTrue(resultado, resultado.contains("Cadastro de Usuário"));
		
		usuarioPO.deslogar();
		
		resultado = loginPO.retornarTituloDaPagina();
		assertTrue(resultado, resultado.contains("Login"));
	}
	
	@Test
	public void TC02_naoDeveSalvarUsuarioComTodosOsCamposVazios() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.salvarCadastro();
		
		String resultado = usuarioPO.mostrarMensagem();
		assertTrue(resultado, !resultado.contains("Operação realizada com sucesso!!!"));
		usuarioPO.deslogar();
	}
	
	@Test
	public void TC03_naoDeveSalvarUsuarioSemNome() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputNome().clear();
		usuarioPO.salvarCadastro();
		
		String resultado = usuarioPO.mostrarMensagem();
		assertTrue(resultado, resultado.contains("Informe o nome!"));
		usuarioPO.deslogar();
	}
	
	@Test
	public void TC04_naoDeveSalvarUsuarioSemSobrenome() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputSobrenome().clear();
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		assertTrue(resultado, resultado.contains("Informe o sobrenome!"));
		usuarioPO.deslogar();
	}
	
	@Test
	public void TC05_naoDeveSalvarUsuarioSemProgramadorSelecionado() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.setInputProgramador("Sele");;
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		assertTrue(resultado, resultado.contains("Informe o nível de programador!"));
		usuarioPO.deslogar();
	}
	
	@Test
	public void TC06_naoDeveSalvarUsuarioSemEstadoSelecionado() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.setInputEstadosInner("Sele");;
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		assertTrue(resultado, resultado.contains("Informe o estado!"));
		usuarioPO.deslogar();
	}

}
