package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

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
		usuarioPO.deslogar();
		assertTrue(resultado, !resultado.contains("Operação realizada com sucesso!!!"));
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
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o nome!"));
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
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o sobrenome!"));
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
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o nível de programador!"));
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
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o estado!"));
	}
	
	@Test
	public void TC07_naoDeveSalvarUsuarioSemCidadeSelecionado() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.setInputCidadesInner("Sele");;
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe a cidade!"));
	}
	
	@Test
	public void TC08_naoDeveSalvarUsuarioSemLoginInformado() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputLogin().clear();
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o login!"));
	}
	
	@Test
	public void TC09_naoDeveSalvarUsuarioSemSenhaInformada() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputSenha().clear();
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe a senha!"));
	}
	
	@Test
	public void TC10_naoDeveSalvarUsuarioComNomeInferiorA3Caracteres() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputNome().clear();
		usuarioPO.setInputNome("ab");
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Nome deve ter entre 3 a 21 caracteres!"));
	}
	
	@Test
	public void TC11_naoDeveSalvarUsuarioComNomeSuperiorA21Caracteres() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputNome().clear();
		usuarioPO.setInputNome("abcdefghijklmnopqrstuvwyxz");
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Nome deve ter entre 3 a 21 caracteres!"));
	}
	
	@Test
	public void TC12_naoDeveSalvarUsuarioComSobrenomeInferiorA3Caracteres() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputSobrenome().clear();
		usuarioPO.setInputSobrenome("ab");
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Sobrenome deve ter entre 3 a 21 caracteres!"));
	}
	
	@Test
	public void TC13_naoDeveSalvarUsuarioComSobrenomeSuperiorA21Caracteres() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputSobrenome().clear();
		usuarioPO.setInputSobrenome("abcdefghijklmnopqrstuvwyxz");
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Sobrenome deve ter entre 3 a 21 caracteres!"));
	}
	
	@Test
	public void TC14_deveApresentarCamposVaziosDeUfECidadeAoInformarUmCepInvalido() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		
		usuarioPO.setInputCep("1111111111");
		usuarioPO.getInputCep().sendKeys(Keys.TAB);
		Thread.sleep(500);
		String uf = usuarioPO.getInputUf().getAttribute("value");
		String cidade = usuarioPO.getInputCidade().getAttribute("value");
		
		usuarioPO.deslogar();
		assertTrue(uf, uf.contains(""));
		assertTrue(cidade, cidade.contains(""));
	}
	
	@Test
	public void TC15_deveApresentarResultadoCorrespondenteNosCamposDeUfECidadeAoInformarCepValido() throws InterruptedException{
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		
		usuarioPO.setInputCep("58295000");
		usuarioPO.getInputCep().sendKeys(Keys.TAB);
		Thread.sleep(500);
		String uf = usuarioPO.getInputUf().getAttribute("value");
		String cidade = usuarioPO.getInputCidade().getAttribute("value");
 		
		usuarioPO.deslogar();
		assertTrue(uf, uf.contains("PB"));
		assertTrue(cidade, cidade.contains("Baía da Traição"));
	}
	
	@Test
	public void TC16_naoDeveSalvarUsuarioComLoginJaUtilizadoPorOutroUsuario() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		usuarioPO.getInputLogin().clear();
		usuarioPO.setInputLogin("admin");
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Já existe um usuário com o login informado!"));
	}
	
	@Test
	public void TC17_deveSalvarUsuarioComAsInformacaoesValidas() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		usuarioPO.setarTodosOsInputsPadrao();
		Thread.sleep(500);
		usuarioPO.salvarCadastro();

		String resultado = usuarioPO.mostrarMensagem();
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Operação realizada com sucesso!!!"));
	}
	
	@Test
	public void TC18_deveMostrarAsInformacoesSalvasCorrespondentesDoUsuarioQuandoEscolhidoAOpcaoDeEditar() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String colId = usuarioPO.getColUserId1().getText();
		
		usuarioPO.getBtnEditarUsuario1().click();
		
		String id = usuarioPO.getInputIdUser().getText();
		
		usuarioPO.deslogar();
		assertTrue(colId, colId.contains(id));
	}
	
	@Test
	public void TC19_deveSalvarAsInformacoesEditadasDoUsuario() {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String colNome = usuarioPO.getColUserNome1().getText();
		
		usuarioPO.getBtnEditarUsuario1().click();
		usuarioPO.setInputNome(" Editado");
		String nome = usuarioPO.getInputNome().getAttribute("value");
		usuarioPO.salvarCadastro();
		
		String colNomeEditado = usuarioPO.getColUserNome1().getText();
		
		usuarioPO.deslogar();
		assertTrue(colNome, !colNome.contains(nome));
		assertTrue(colNomeEditado, colNomeEditado.contains(nome));
	}
	
	@Test
	public void TC20_deveLimparApenasAsInformacoesQuePodemSerEditadasDoUsuario() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String colId = usuarioPO.getColUserId1().getText();
		String colNome = usuarioPO.getColUserNome1().getText();
		
		usuarioPO.getBtnEditarUsuario1().click();
		usuarioPO.limparTodosOsInputs();
		
		Thread.sleep(500);
		
		String id = usuarioPO.getInputIdUser().getAttribute("value");
		String nome = usuarioPO.getInputNome().getAttribute("value");
		
		usuarioPO.deslogar();
		assertTrue(colId, colId.contains(id));
		assertTrue(colNome, !colNome.equals(nome));
		assertTrue(nome.isEmpty());
	}
	
	@Test
	public void TC21_deveLimparTodasAsInformacoesAoClicarEmNovo() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String colId = usuarioPO.getColUserId1().getText();
		
		usuarioPO.getBtnEditarUsuario1().click();
		usuarioPO.getBtnNovoCadastro().click();
		
		Thread.sleep(500);
		
		String id = usuarioPO.getInputIdUser().getAttribute("value");
		String nome = usuarioPO.getInputNome().getAttribute("value");
		
		usuarioPO.deslogar();
		assertTrue(colId, !colId.equals(id));
		assertTrue(id.isEmpty());
		assertTrue(nome.isEmpty());
	}
	
	@Test
	public void TC22_deveExcluirOUsuarioAoClicarEmExcluir() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		String dataTableInfo1 = usuarioPO.getDataTableInfo().getText();
		usuarioPO.getBtnDeletarUsuario1().click();
		String resultado = usuarioPO.mostrarMensagem();

		Thread.sleep(500);
		
		String dataTableInfo2 = usuarioPO.getDataTableInfo().getText();
		
		usuarioPO.deslogar();
		assertTrue(resultado, resultado.contains("Cadastro deletado com sucesso!!!"));
		assertTrue(dataTableInfo1, !dataTableInfo1.equals(dataTableInfo2));
		
	}

}
