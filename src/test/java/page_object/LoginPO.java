package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
	
	@FindBy(css = "#input_formLogin\\:inputLogin")
	private WebElement inputLogin;
	@FindBy(css = "#input_formLogin\\:inputSenha")
	private WebElement inputSenha;
	@FindBy(css = "#formLogin\\:btnAcessar")
	private WebElement btnAcessar;
	@FindBy(css = "#msg_container > div > div > div.ui-growl-message > p")
	private WebElement mensagem;
	
	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	public void informarLoginESenha(String login, String senha) {
		inputLogin.clear();
		inputSenha.clear();
		
		inputLogin.sendKeys(login);
		inputSenha.sendKeys(senha);
	}
	
	public void acessar() {
		btnAcessar.click();
	}
	
	public String mostrarMensagem() {
		
		return mensagem.getText();
	}
	
	public String retornarTituloDaPagina() {
		return driver.getTitle();
	}
	
	public void logarComoAdmin() {
		informarLoginESenha("admin", "admin");
		acessar();
	}
	
	public void logarComoSecretario() {
		informarLoginESenha("secretario", "secretario");
		acessar();
	}
	

}
