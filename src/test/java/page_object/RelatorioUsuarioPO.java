package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RelatorioUsuarioPO extends BasePO{

	@FindBy(css = "#j_idt7\\:menuRelatorios > a > span.ui-menuitem-text")
	private WebElement menuRelatorios;

	@FindBy(css = "#j_idt7\\:menuRelUsuarios > span.ui-menuitem-text")
	private WebElement menuRelUsuarios;
	
	@FindBy(css = "#j_idt7\\:menuLogout > span.ui-menuitem-text")
	private WebElement menuLogout;

	@FindBy(css = "#input_relatorioUsuarios\\:nome")
	private WebElement inputNome;

	@FindBy(css = "#relatorioUsuarios\\:programadorInner")
	private WebElement inputProgramadorInner;

	@FindBy(css = "#relatorioUsuarios\\:estadoInner")
	private WebElement inputEstadoInner;

	@FindBy(css = "#relatorioUsuarios\\:dataNascimento_Input")
	private WebElement inputDataNascimento;

	@FindBy(css = "#relatorioUsuarios\\:pesquisar")
	private WebElement btnPesquisar;
	
	@FindBy(css = "#j_idt31\\:listaUsuarios > tbody > tr > td")
	private WebElement dataTableVazio;

	@FindBy(css = "#j_idt31\\:listaUsuarios_info")
	private WebElement dataTableInfo;
	
	@FindBy(css = "#j_idt31\\:listaUsuarios > tbody > tr > td:nth-child(2)")
	private WebElement colNome;

	@FindBy(css = "#j_idt31\\:listaUsuarios > tbody > tr > td:nth-child(3)")
	private WebElement colEstado;

	@FindBy(css = "#j_idt31\\:listaUsuarios > tbody > tr > td:nth-child(4)")
	private WebElement colProgramador;

	@FindBy(css = "#j_idt31\\:listaUsuarios > tbody > tr > td:nth-child(5)")
	private WebElement colData;
	
	public RelatorioUsuarioPO(WebDriver driver) {
		super(driver);
	}

	public WebElement getMenuRelatorios() {
		return menuRelatorios;
	}
	public WebElement getMenuRelUsuarios() {
		return menuRelUsuarios;
	}
	public WebElement getMenuLogout() {
		return menuLogout;
	}
	public WebElement getInputNome() {
		return inputNome;
	}
	public void setInputNome(String inputNome) {
		this.inputNome.sendKeys(inputNome);
	}
	public WebElement getInputProgramadorInner() {
		return inputProgramadorInner;
	}
	public void setInputProgramadorInner(String inputProgramadorInner) {
		this.inputProgramadorInner.click();
		this.inputProgramadorInner.sendKeys(inputProgramadorInner);
		this.inputProgramadorInner.click();
	}
	public WebElement getInputEstadoInner() {
		return inputEstadoInner;
	}
	public void setInputEstadoInner(String inputEstadoInner) {
		this.inputEstadoInner.click();
		this.inputEstadoInner.sendKeys(inputEstadoInner);
		this.inputEstadoInner.click();
	}
	public WebElement getInputDataNascimento() {
		return inputDataNascimento;
	}
	public void setInputDataNascimento(String inputDataNascimento) {
		this.inputDataNascimento.sendKeys(inputDataNascimento);
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
	public WebElement getColNome() {
		return colNome;
	}
	public WebElement getColEstado() {
		return colEstado;
	}
	public WebElement getColProgramador() {
		return colProgramador;
	}
	public WebElement getColData() {
		return colData;
	}
	
	public String mostrarDatatableInfo() {
		return dataTableInfo.getText();
	}
	
	public void acessarPaginaDeRelatorioUser() {
		menuRelatorios.click();
		menuRelatorios.click();
		menuRelUsuarios.click();
	}
	
	public String mostrarResultadoDataTableVazio() {
		return dataTableVazio.getText();
	}
	
	public void deslogar() {
		menuLogout.click();
	}

}
