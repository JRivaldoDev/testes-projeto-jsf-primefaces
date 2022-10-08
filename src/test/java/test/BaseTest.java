package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

	protected static WebDriver driver;
	private static final String URL_BASE = "http://localhost:8080/projeto-jsf-primefaces/";
	private static final String CAMINHO = "src/test/java/resource/chromedriver.exe";

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", CAMINHO);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}

	@AfterClass
	public static void encerrar() {
		driver.quit();
	}

}
