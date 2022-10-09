package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page_object.LancamentosPO;
import page_object.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LancamentosTest extends BaseTest {
	
	private static LoginPO loginPO;
	private static LancamentosPO lancamentosPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
		lancamentosPO = new LancamentosPO(driver);
	}
	
	@Test
	public void TC01_deveAcessarAPaginaLancamentosAoClicarNoMenuLancamentos() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		lancamentosPO.abrirPaginaLancamentos();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();
		
		assertTrue(resultado, resultado.contains("Lançamentos"));
		
	}
	
	@Test
	public void TC02_deveDeslogarAoClicarEmLogout() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		lancamentosPO.abrirPaginaLancamentos();
		
		Thread.sleep(500);
		String resultado = loginPO.retornarTituloDaPagina();

		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Lançamentos"));
		
		resultado = loginPO.retornarTituloDaPagina();
		assertTrue(resultado, resultado.contains("Login"));
	}
	
	@Test
	public void TC03_naoDeveSalvarNotaComOsCamposVazios() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		lancamentosPO.deslogar();
		assertTrue(resultado, !resultado.contains("Operação realizada com sucesso!"));
	}
	
	@Test
	public void TC04_naoDeveSalvarNotaComOCampoDeNotaVazia() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		lancamentosPO.setarTodosOsCampos();
		lancamentosPO.getInputNota().clear();
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o número da nota!"));
	}
	
	@Test
	public void TC05_naoDeveSalvarNotaComOCampoDeOrigemVazio() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		lancamentosPO.setarTodosOsCampos();
		lancamentosPO.getInputOrigem().clear();
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe a origem!"));
	}
	
	@Test
	public void TC06_naoDeveSalvarNotaComOCampoDeDestinoVazio() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		lancamentosPO.setarTodosOsCampos();
		lancamentosPO.getInputDestino().clear();
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe o destino!"));
	}
	
	@Test
	public void TC07_naoDeveSalvarNotaComOCampoDeDataVazia() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		lancamentosPO.setarTodosOsCampos();
		lancamentosPO.getInputDataEnvio().clear();
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Informe a data da nota!"));
	}
	
	@Test
	public void TC08_deveSalvarNotaComTodosOsCamposPreenchidos() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		String dataTableInfo1 = lancamentosPO.mostrarDataTableInfo();
		lancamentosPO.setarTodosOsCampos();
		lancamentosPO.salvar();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		String dataTableInfo2 = lancamentosPO.mostrarDataTableInfo();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Operação realizada com sucesso!"));
		assertTrue(!dataTableInfo1.equals(dataTableInfo2));
	}
	
	@Test
	public void TC09_deveExcluirNota() throws InterruptedException {
		if(loginPO.retornarTituloDaPagina().equalsIgnoreCase("Login")) {
			loginPO.logarComoAdmin();
		}
		Thread.sleep(500);
		lancamentosPO.abrirPaginaLancamentos();
		Thread.sleep(500);
		String dataTableInfo1 = lancamentosPO.mostrarDataTableInfo();
		lancamentosPO.getColBtnExcluir().click();
		Thread.sleep(500);
		String resultado = lancamentosPO.mostrarMensagem();
		String dataTableInfo2 = lancamentosPO.mostrarDataTableInfo();
		lancamentosPO.deslogar();
		assertTrue(resultado, resultado.contains("Operação realizada com sucesso!"));
		assertTrue(!dataTableInfo1.equals(dataTableInfo2));
	}

}
