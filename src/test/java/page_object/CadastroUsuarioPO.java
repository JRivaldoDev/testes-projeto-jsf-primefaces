package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroUsuarioPO extends BasePO{
	
	//input de dados pessoais
	@FindBy(css = "#input_formCadastro\\:idUser")
	private WebElement inputIdUser;
	
	@FindBy(css = "#input_formCadastro\\:nome")
	private WebElement inputNome;
	
	@FindBy(css = "#input_formCadastro\\:sobrenome")
	private WebElement inputSobrenome;
	
	@FindBy(css = "#input_formCadastro\\:idade")
	private WebElement inputIdade;
	
	@FindBy(css = "#formCadastro\\:dataNascimento_Input")
	private WebElement inputDataNascimento;
	
	@FindBy(css = "#formCadastro\\:campoSexoInner")
	private WebElement inputSexo;
	
	@FindBy(css = "#input_formCadastro\\:cpf")
	private WebElement inputCpf;
	
	//input de endereço
	@FindBy(css = "#input_formCadastro\\:cep")
	private WebElement inputCep;
	
	@FindBy(css = "#input_formCadastro\\:uf")
	private WebElement inputUf;
	
	@FindBy(css = "#input_formCadastro\\:cidade")
	private WebElement inputCidade;
	
	//input de dados profissionais
	@FindBy(css = "#formCadastro\\:campoProgramadorInner")
	private WebElement inputProgramador;
	
	@FindBy(css = "#input_formCadastro\\:salario")
	private WebElement inputSalario;
	
	@FindBy(css = "#formCadastro\\:estadosInner")
	private WebElement inputEstadosInner;
	
	@FindBy(css = "#formCadastro\\:cidadesInner")
	private WebElement inputCidadesInner;
	
	@FindBy(css = "#input_formCadastro\\:login")
	private WebElement inputLogin;
	
	@FindBy(css = "#input_formCadastro\\:senha")
	private WebElement inputSenha;
	
	@FindBy(css = "#formCadastro\\:campoPerfilInner")
	private WebElement inputPerfil;
	
	//botões do cadastro
	@FindBy(css = "#formCadastro\\:novoCadastro")
	private WebElement btnNovoCadastro;
	
	@FindBy(css = "#formCadastro\\:limpar")
	private WebElement btnLimpar;
	
	@FindBy(css = "#formCadastro\\:salvar")
	private WebElement btnSalvar;
	
	@FindBy(css = "#formCadastro\\:deletar")
	private WebElement btnDeletar;
	
	//botões da lista na posição 0
	@FindBy(css = "#formListaUsuarios\\:j_idt102\\:0\\:editarUsuario > img")
	private WebElement btnEditarUsuario0;
	
	@FindBy(css = "#formListaUsuarios\\:j_idt102\\:0\\:deletarUsuario > img")
	private WebElement btnDeletarUsuario0;
	
	//botões da lista na posição 1
	@FindBy(css = "#formListaUsuarios\\:j_idt102\\:1\\:editarUsuario > img")
	private WebElement btnEditarUsuario1;
	
	@FindBy(css = "#formListaUsuarios\\:j_idt102\\:1\\:deletarUsuario > img")
	private WebElement btnDeletarUsuario1;
	
	//mensagem
	@FindBy(css = "#msgGrowl_container > div > div > div.ui-growl-message > span")
	private WebElement growlMsg;
	
	@FindBy(css = "#j_idt7\\:menuLogout > span.ui-menuitem-text")
	private WebElement menuLogout;
			
	public CadastroUsuarioPO(WebDriver driver) {
		super(driver);
	}


	public WebElement getInputIdUser() {
		return inputIdUser;
	}
	public void setInputIdUser(String inputIdUser) {
		this.inputIdUser.sendKeys(inputIdUser);;
	}
	public WebElement getInputNome() {
		return inputNome;
	}
	public void setInputNome(String inputNome) {
		this.inputNome.sendKeys(inputNome);
	}
	public WebElement getInputSobrenome() {
		return inputSobrenome;
	}
	public void setInputSobrenome(String inputSobrenome) {
		this.inputSobrenome.sendKeys(inputSobrenome);
	}
	public WebElement getInputIdade() {
		return inputIdade;
	}
	public void setInputIdade(String inputIdade) {
		this.inputIdade.sendKeys(inputIdade);
	}
	public WebElement getInputDataNascimento() {
		return inputDataNascimento;
	}
	public void setInputDataNascimento(String inputDataNascimento) {
		this.inputDataNascimento.clear();;
		this.inputDataNascimento.sendKeys(inputDataNascimento);
	}
	public WebElement getInputSexo() {
		return inputSexo;
	}
	public void setInputSexo(String inputSexo) {
		this.inputSexo.click();
		this.inputSexo.sendKeys(inputSexo);
		this.inputSexo.click();
	}
	public WebElement getInputCpf() {
		return inputCpf;
	}
	public void setInputCpf(String inputCpf) {
		this.inputCpf.sendKeys(inputCpf);
	}
	public WebElement getInputCep() {
		return inputCep;
	}
	public void setInputCep(String inputCep) {
		this.inputCep.sendKeys(inputCep);
	}
	public WebElement getInputUf() {
		return inputUf;
	}
	public void setInputUf(String inputUf) {
		this.inputUf.sendKeys(inputUf);
	}
	public WebElement getInputCidade() {
		return inputCidade;
	}
	public void setInputCidade(String inputCidade) {
		this.inputCidade.sendKeys(inputCidade);
	}
	public WebElement getInputProgramador() {
		return inputProgramador;
	}
	public void setInputProgramador(String inputProgramador) {
		this.inputProgramador.click();
		this.inputProgramador.sendKeys(inputProgramador);
		this.inputProgramador.click();
	}
	public WebElement getInputSalario() {
		return inputSalario;
	}
	public void setInputSalario(String inputSalario) {
		this.inputSalario.sendKeys(inputSalario);
	}
	public WebElement getInputEstadosInner() {
		return inputEstadosInner;
	}
	public void setInputEstadosInner(String inputEstadosInner) {
		this.inputEstadosInner.click();
		this.inputEstadosInner.sendKeys(inputEstadosInner);
		this.inputEstadosInner.click();
	}
	public WebElement getInputCidadesInner() {
		return inputCidadesInner;
	}
	public void setInputCidadesInner(String inputCidadesInner) {
		this.inputCidadesInner.click();
		this.inputCidadesInner.sendKeys(inputCidadesInner);
		this.inputCidadesInner.click();
	}
	public WebElement getInputLogin() {
		return inputLogin;
	}
	public void setInputLogin(String inputLogin) {
		this.inputLogin.sendKeys(inputLogin);
	}
	public WebElement getInputSenha() {
		return inputSenha;
	}
	public void setInputSenha(String inputSenha) {
		this.inputSenha.sendKeys(inputSenha);
	}
	public WebElement getInputPerfil() {
		return inputPerfil;
	}
	public void setInputPerfil(String inputPerfil) {
		this.inputPerfil.sendKeys(inputPerfil);
	}
	public WebElement getBtnNovoCadastro() {
		return btnNovoCadastro;
	}
	public void setBtnNovoCadastro(WebElement btnNovoCadastro) {
		this.btnNovoCadastro = btnNovoCadastro;
	}
	public WebElement getBtnLimpar() {
		return btnLimpar;
	}
	public void setBtnLimpar(WebElement btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
	public WebElement getBtnSalvar() {
		return btnSalvar;
	}
	public void setBtnSalvar(WebElement btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	public WebElement getBtnDeletar() {
		return btnDeletar;
	}
	public void setBtnDeletar(WebElement btnDeletar) {
		this.btnDeletar = btnDeletar;
	}
	public WebElement getBtnEditarUsuario0() {
		return btnEditarUsuario0;
	}
	public void setBtnEditarUsuario0(WebElement btnEditarUsuario0) {
		this.btnEditarUsuario0 = btnEditarUsuario0;
	}
	public WebElement getBtnDeletarUsuario0() {
		return btnDeletarUsuario0;
	}
	public void setBtnDeletarUsuario0(WebElement btnDeletarUsuario0) {
		this.btnDeletarUsuario0 = btnDeletarUsuario0;
	}
	public WebElement getBtnEditarUsuario1() {
		return btnEditarUsuario1;
	}
	public void setBtnEditarUsuario1(WebElement btnEditarUsuario1) {
		this.btnEditarUsuario1 = btnEditarUsuario1;
	}
	public WebElement getBtnDeletarUsuario1() {
		return btnDeletarUsuario1;
	}
	public void setBtnDeletarUsuario1(WebElement btnDeletarUsuario1) {
		this.btnDeletarUsuario1 = btnDeletarUsuario1;
	}
	public WebElement getGrowlMsg() {
		return growlMsg;
	}
	public void setGrowlMsg(WebElement growlMsg) {
		this.growlMsg = growlMsg;
	}
	public WebElement getMenuLogout() {
		return menuLogout;
	}
	
	
	public void setarTodosOsInputsPadrao() {
	
		setInputNome("Fulano");
		setInputSobrenome("Ciclano");
		setInputIdade("22");
		setInputDataNascimento("01/01/2000");
		setInputSexo("M");
		setInputCpf("99999999999");
		
		setInputCep("58295000");
		
		setInputProgramador("J");
		setInputSalario("2000");
		setInputEstadosInner("Paraíba");
		setInputCidadesInner("Baía");
		setInputLogin("teste");
		setInputSenha("teste");
		setInputPerfil("Sec");
		
	}
	
	public void salvarCadastro() {
		btnSalvar.click();
	}
	
	public String mostrarMensagem() {
		return growlMsg.getText();
	}
	
	public void limparTodosOsInputs() {
		getBtnLimpar().click();
	}
	
	public void deslogar() {
		menuLogout.click();
	}
	
	
}
