package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page_object.LoginPO;
import page_object.RelatorioNotasPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelatorioNotasTest extends BaseTest {
	
	private static LoginPO loginPO;
	private static RelatorioNotasPO relatorioNotasPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
		relatorioNotasPO = new RelatorioNotasPO(driver);
	}
	
	@Test
	public void TC01_deveAcessarAPaginaRelatorioNotasAoClicarNoMenuRelatorioNotas() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();
		relatorioNotasPO.deslogar();
		assertTrue(resultado, resultado.contains("Relatório de Notas"));
		
	}
	
	@Test
	public void TC02_deveDeslogarAoClicarEmLogout() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();
		relatorioNotasPO.deslogar();
		String resultado2 = loginPO.retornarTituloDaPagina();
		
		assertTrue(resultado, resultado.contains("Relatório de Notas"));
		assertTrue(resultado2, resultado2.contains("Login"));
		
	}
	
	@Test
	public void TC03_deveListarTodasAsNotasCadastradasAoPesquisarComTodosOsCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		String dataTableInfo1 = relatorioNotasPO.mostrarDatatableInfo();
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String dataTableInfo2 = relatorioNotasPO.mostrarDatatableInfo();
		
		assertTrue(dataTableInfo1, !dataTableInfo1.contains(dataTableInfo2));
		
	}
	
	@Test
	public void TC04_naoDeveListarNotasCadastradasAoPesquisarComUsuarioInvalidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputUsuario("suahsudasdadasd");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioNotasPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC05_deveListarNotasCadastradasAoPesquisarComUsuarioValidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputUsuario("administrador");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String colUsuario = relatorioNotasPO.getColUsuario().getText();
		
		assertTrue("ADMINISTRADOR", "ADMINISTRADOR".contains(colUsuario));
		
	}
	
	@Test
	public void TC06_naoDeveListarNotasCadastradasAoPesquisarComOrigemInvalidaEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputOrigem("suahsudasdadasd");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioNotasPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC07_deveListarNotasCadastradasAoPesquisarComOrigemValidaEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputOrigem("Empresa A");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String colOrigem = relatorioNotasPO.getColOrigem().getText();
		
		assertTrue("Empresa A", "Empresa A".contains(colOrigem));
		
	}
	
	@Test
	public void TC08_naoDeveListarNotasCadastradasAoPesquisarComDestinoInvalidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputDestino("suahsudasdadasd");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioNotasPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC09_deveListarNotasCadastradasAoPesquisarComDestinoValidoEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputDestino("Empresa B");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String colDestino = relatorioNotasPO.getColDestino().getText();
		
		assertTrue("Empresa B", "Empresa B".contains(colDestino));
		
	}
	
	@Test
	public void TC10_naoDeveListarNotasCadastradasAoPesquisarComDataInvalidaEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputDataEnvio("01/01/2000");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String dataTableVazio = relatorioNotasPO.mostrarResultadoDataTableVazio();
		
		assertTrue(dataTableVazio, dataTableVazio.contains("Nenhum registro encontrado"));
		
	}
	
	@Test
	public void TC11_deveListarNotasCadastradasAoPesquisarComDataValidaEOsOutrosCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputDataEnvio("01/01/2022");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String colData = relatorioNotasPO.getColData().getText();
		
		assertTrue("2022-01-01", "2022-01-01".contains(colData));
		
	}
	
	@Test
	public void TC12_deveListarNotasCadastradasAoPesquisarComTodosOsCamposValidos() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		relatorioNotasPO.acessarPaginaDeRelatorioNotas();
		Thread.sleep(500);
		relatorioNotasPO.setInputUsuario("administrador");
		relatorioNotasPO.setInputOrigem("Empresa A");
		relatorioNotasPO.setInputDestino("Empresa B");
		relatorioNotasPO.setInputDataEnvio("01/01/2022");
		Thread.sleep(500);
		relatorioNotasPO.getBtnPesquisar().click();
		String colUsuario = relatorioNotasPO.getColUsuario().getText();
		String colOrigem = relatorioNotasPO.getColOrigem().getText();
		String colDestino = relatorioNotasPO.getColDestino().getText();
		String colData = relatorioNotasPO.getColData().getText();
		
		assertTrue("ADMINISTRADOR", "ADMINISTRADOR".contains(colUsuario));
		assertTrue("Empresa A", "Empresa A".contains(colOrigem));
		assertTrue("Empresa B", "Empresa B".contains(colDestino));
		assertTrue("2022-01-01", "2022-01-01".contains(colData));
		
	}

}
