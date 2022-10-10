package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RelatorioNotasPO extends BasePO {

	@FindBy(css = "#j_idt7\\:menuRelatorios > a > span.ui-menuitem-text")
	private WebElement menuRelatorios;
	
	@FindBy(css = "#j_idt7\\:menuRelNotas > span.ui-menuitem-text")
	private WebElement menuRelNotas;
	
	@FindBy(css = "#j_idt7\\:menuLogout > span.ui-menuitem-text")
	private WebElement menuLogout;
	
	@FindBy(css = "#input_relatorioNotas\\:usuario")
	private WebElement inputUsuario;

	@FindBy(css = "#input_relatorioNotas\\:origem")
	private WebElement inputOrigem;

	@FindBy(css = "#input_relatorioNotas\\:destino")
	private WebElement inputDestino;

	@FindBy(css = "#relatorioNotas\\:dataEnvio_Input")
	private WebElement inputDataEnvio;

	@FindBy(css = "#relatorioNotas\\:pesquisar")
	private WebElement btnPesquisar;

	@FindBy(css = "#formListaNotas\\:listaNotas > tbody > tr > td")
	private WebElement dataTableVazio;

	@FindBy(css = "#formListaNotas\\:listaNotas_info")
	private WebElement dataTableInfo;

	@FindBy(css = "#formListaNotas\\:listaNotas > tbody > tr > td:nth-child(2)")
	private WebElement colUsuario;

	@FindBy(css = "#formListaNotas\\:listaNotas > tbody > tr > td:nth-child(4)")
	private WebElement colOrigem;

	@FindBy(css = "#formListaNotas\\:listaNotas > tbody > tr > td:nth-child(5)")
	private WebElement colDestino;

	@FindBy(css = "#formListaNotas\\:listaNotas > tbody > tr > td:nth-child(6)")
	private WebElement colData;
	
	public RelatorioNotasPO(WebDriver driver) {
		super(driver);
	}

	public WebElement getMenuRelatorios() {
		return menuRelatorios;
	}
	public WebElement getMenuRelNotas() {
		return menuRelNotas;
	}
	public WebElement getMenuLogout() {
		return menuLogout;
	}
	public WebElement getInputUsuario() {
		return inputUsuario;
	}
	public void setInputUsuario(String inputUsuario) {
		this.inputUsuario.sendKeys(inputUsuario);
	}
	public WebElement getInputOrigem() {
		return inputOrigem;
	}
	public void setInputOrigem(String inputOrigem) {
		this.inputOrigem.sendKeys(inputOrigem);
	}
	public WebElement getInputDestino() {
		return inputDestino;
	}
	public void setInputDestino(String inputDestino) {
		this.inputDestino.sendKeys(inputDestino);
	}
	public WebElement getInputDataEnvio() {
		return inputDataEnvio;
	}
	public void setInputDataEnvio(String inputDataEnvio) {
		this.inputDataEnvio.sendKeys(inputDataEnvio);
	}
	public WebElement getBtnPesquisar() {
		return btnPesquisar;
	}
	public WebElement getDataTableVazio() {
		return dataTableVazio;
	}
	public WebElement getDataTableInfo() {
		return dataTableInfo;
	}
	public WebElement getColUsuario() {
		return colUsuario;
	}
	public WebElement getColOrigem() {
		return colOrigem;
	}
	public WebElement getColDestino() {
		return colDestino;
	}
	public WebElement getColData() {
		return colData;
	}
	
	public String mostrarDatatableInfo() {
		return dataTableInfo.getText();
	}
	
	public void acessarPaginaDeRelatorioNotas() {
		menuRelatorios.click();
		menuRelatorios.click();
		menuRelNotas.click();
	}
	
	public String mostrarResultadoDataTableVazio() {
		return dataTableVazio.getText();
	}
	
	public void deslogar() {
		menuLogout.click();
	}
	
}
