package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LancamentosPO extends BasePO {
	
	//inputs do formulário
	@FindBy(css = "#input_formLancamentos\\:idNotas")
	private WebElement inputIdNotas;

	@FindBy(css = "#input_formLancamentos\\:nota")
	private WebElement inputNota;

	@FindBy(css = "#input_formLancamentos\\:origem")
	private WebElement inputOrigem;

	@FindBy(css = "#input_formLancamentos\\:destino")
	private WebElement inputDestino;

	@FindBy(css = "#formLancamentos\\:dataEnvio_Input")
	private WebElement inputDataEnvio;
	
	//botões do formulário
	@FindBy(css = "#formLancamentos\\:limparNota")
	private WebElement btnLimpar;

	@FindBy(css = "#formLancamentos\\:salvarNota")
	private WebElement btnSalvar;

	//coluna da tabela
	@FindBy(css = "#formListaNotas\\:listaNotas\\:0\\:excluirNota > img")
	private WebElement colBtnExcluir;

	//info da tabela
	@FindBy(css = "#formListaNotas\\:listaNotas_info")
	private WebElement dataTableInfo;
	
	@FindBy(css = "#msgLancamentos_container > div > div > div.ui-growl-message > p")
	private WebElement growlMsg;
	
	@FindBy(css = "#j_idt7\\:menuLogout > span.ui-menuitem-text")
	private WebElement menuLogout;
	
	@FindBy(css = "#j_idt7\\:menuLancamentos")
	private WebElement menuLancamentos;
	
	public LancamentosPO(WebDriver driver) {
		super(driver);
	}

	public WebElement getInputIdNotas() {
		return inputIdNotas;
	}
	public void setInputIdNotas(String inputIdNotas) {
		this.inputIdNotas.sendKeys(inputIdNotas);
	}

	public WebElement getInputNota() {
		return inputNota;
	}
	public void setInputNota(String inputNota) {
		this.inputNota.sendKeys(inputNota);
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
	public WebElement getBtnLimpar() {
		return btnLimpar;
	}
	public WebElement getBtnSalvar() {
		return btnSalvar;
	}
	public WebElement getColBtnExcluir() {
		return colBtnExcluir;
	}
	public WebElement getDataTableInfo() {
		return dataTableInfo;
	}
	public WebElement getGrowlMsg() {
		return growlMsg;
	}
	
	public void setarTodosOsCampos() {
		setInputNota("000000000000");
		setInputOrigem("Cidade A");
		setInputDestino("Cidade B");
		setInputDataEnvio("01/01/2022");
	}
	
	public void salvar() {
		btnSalvar.click();
	}
	
	public void limpar() {
		btnLimpar.click();
	}
	
	public String mostrarMensagem() {
		return growlMsg.getText();
	}
	
	public String mostrarDataTableInfo() {
		return dataTableInfo.getText();
	}
	
	public void deslogar() {
		menuLogout.click();
	}
	
	public void abrirPaginaLancamentos() {
		menuLancamentos.click();
	}

}
