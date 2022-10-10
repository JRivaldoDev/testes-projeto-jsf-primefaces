package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page_object.LoginPO;
import page_object.RelatorioUsuarioPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelatorioUsuarioTest extends BaseTest{
	
	private static LoginPO loginPO;
	private static RelatorioUsuarioPO relatorioUsuarioPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
		relatorioUsuarioPO = new RelatorioUsuarioPO(driver);
	}
	
	@Test
	public void TC01_deveAcessarAPaginaRelatorioDeUsuariosAoClicarNoMenuRelatorioUsuario() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();
		assertTrue(resultado, resultado.contains("Relatório de Usuários"));
		
	}
	
	@Test
	public void TC02_deveDeslogarAoClicarEmLogout() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();
		relatorioUsuarioPO.deslogar();
		String resultado2 = loginPO.retornarTituloDaPagina();
		
		assertTrue(resultado, resultado.contains("Relatório de Usuários"));
		assertTrue(resultado2, resultado2.contains("Login"));
		
	}
	
	@Test
	public void TC03_deveListarTodosOsUsuariosCadastradosAoPesquisarComTodosOsCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		String dataTableInfo1 = relatorioUsuarioPO.mostrarDatatableInfo();
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String dataTableInfo2 = relatorioUsuarioPO.mostrarDatatableInfo();
		
		assertTrue(dataTableInfo1, !dataTableInfo1.contains(dataTableInfo2));
		
	}
	
	@Test
	public void TC04_naoDeveListarUsuariosCadastradosAoPesquisarComNomeInvalidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputNome("suahsudasdadasd");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioUsuarioPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC05_deveListarUsuariosCadastradosAoPesquisarComNomeValidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputNome("administrador");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String colNome = relatorioUsuarioPO.getColNome().getText();
		
		assertTrue("ADMINISTRADOR", "ADMINISTRADOR".contains(colNome));
		
	}
	
	@Test
	public void TC06_naoDeveListarUsuariosCadastradosAoPesquisarPorProgramadorNaoSalvoNoBancoDeDadosEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputProgramadorInner("Esp");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioUsuarioPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC07_deveListarUsuariosCadastradosAoPesquisarPorProgramadorEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputProgramadorInner("Sen");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String colProgramador = relatorioUsuarioPO.getColProgramador().getText();
		
		assertTrue("SENIOR", "SENIOR".contains(colProgramador));
		
	}
	
	@Test
	public void TC08_naoDeveListarUsuariosCadastradosAoPesquisarPorEstadoNaoSalvoNoBancoDeDadosEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputEstadoInner("pern");;
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioUsuarioPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC09_deveListarUsuariosCadastradosAoPesquisarPorEstadoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputEstadoInner("Paraí");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String colEstado = relatorioUsuarioPO.getColEstado().getText();
		
		assertTrue("Paraíba", "Paraíba".contains(colEstado));
		
	}
	
	@Test
	public void TC10_naoDeveListarUsuariosCadastradosAoPesquisarPorDataNaoSalvaNoBancoDeDadosEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputDataNascimento("01/01/2030");;
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioUsuarioPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC11_deveListarUsuariosCadastradosAoPesquisarPorDataEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputDataNascimento("01/01/2000");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String colData = relatorioUsuarioPO.getInputDataNascimento().getText();
		
		assertTrue("2000-01-01", "2000-01-01".contains(colData));
		
	}
	
	@Test
	public void TC12_deveListarUsuariosCadastradosAoPesquisarPorCamposValidos() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioUsuarioPO.acessarPaginaDeRelatorioUser();
		Thread.sleep(500);
		relatorioUsuarioPO.setInputNome("administrador");
		relatorioUsuarioPO.setInputProgramadorInner("Sen");
		relatorioUsuarioPO.setInputEstadoInner("Paraí");
		relatorioUsuarioPO.setInputDataNascimento("01/01/2000");
		Thread.sleep(500);
		relatorioUsuarioPO.getBtnPesquisar().click();
		String colNome = relatorioUsuarioPO.getColNome().getText();
		String colProgramador = relatorioUsuarioPO.getColProgramador().getText();
		String colEstado = relatorioUsuarioPO.getColEstado().getText();
		String colData = relatorioUsuarioPO.getInputDataNascimento().getText();
		
		assertTrue("ADMINISTRADOR", "ADMINISTRADOR".contains(colNome));
		assertTrue("SENIOR", "SENIOR".contains(colProgramador));
		assertTrue("Paraíba", "Paraíba".contains(colEstado));
		assertTrue("2000-01-01", "2000-01-01".contains(colData));
		
	}

}
