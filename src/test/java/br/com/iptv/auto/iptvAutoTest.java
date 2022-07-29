package br.com.iptv.auto;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iptvAutoTest {

	private WebDriver driver;
	private iptvHomePage homePage;
	private AmazonHomePage amazonHomePage;
	Dimension d = new Dimension(1080, 1000);

	@BeforeEach
	public void inicio() {

		

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("-user-agent=\"Mozilla/103.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML,like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		//options.addArguments("--window-size=1200,800");
		options.addArguments("--window-size=1080,1000");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new FirefoxDriver(options);	
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		
		
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1200,800");
//		 options.addArguments("-user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML,like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		//driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
//
//		// driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		amazonHomePage = new AmazonHomePage(driver);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void teste() throws InterruptedException {
		
		
		driver.get("https://alexa.amazon.com.br/");
        
		//amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
		
		//driver.manage().window().setSize(d);
		
		
		Thread.sleep(2000);
//		WebElement texto = driver.findElement(By.id("auth-signin-button-announce"));
		
		System.out.println("PRIMEIRA TELA" + driver.getWindowHandle());
//		System.out.println("TEXTO " + texto.getText());
		
		
		amazonHomePage.usu();
		amazonHomePage.s();
		amazonHomePage.b();
		//Thread.sleep(9000);
		
	
		//driver.navigate().refresh();
		
		System.out.println("SEGUNDA TELA" + driver.getWindowHandle());
		
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.elementToBeClickable(By.id("iTimersAndAlarms")));
		
		WebElement menu = driver.findElement(By.cssSelector("#d-navigate"));
		Thread.sleep(500);
		menu.findElement(By.id("iTimersAndAlarms")).click();
		

//		Thread.sleep(5000);
//		
		//amazonHomePage.clicarMenuLembretesAlarme();
//		WebElement lembrete = driver.findElement(By.cssSelector("#d-app"));
//		WebElement  lembrete2= lembrete.findElement(By.id("d-page"));
//		lembrete2.findElement(By.id("d-content"));
//		WebElement lembrete3 = lembrete2.findElement(By.cssSelector("a[class=\"standard-component image-text-nav\"]"));

//		lembrete3.click();

		
		
   amazonHomePage.butonAdicionarLembretes();
		amazonHomePage
				.escreverlembrete("A expiração do IPETÊVÊ é 28/08/2022 porém o saldo é de 3");
		amazonHomePage.clicarData();
		Thread.sleep(3000);

		amazonHomePage.clicarHora();
		Thread.sleep(1000);
		amazonHomePage.clicarHora();
		Thread.sleep(1000);

		Date dataHoraAtual = new Date();

		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
		String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
		System.out.println("Aqui está a hora" + horaA);

		amazonHomePage.setarHora(horaA);
		Thread.sleep(1000);
		Thread.sleep(1000);
		amazonHomePage.clicaComboselect();
		Thread.sleep(1000);
		amazonHomePage.select();
		Thread.sleep(1000);
		amazonHomePage.butonSalvar();
		
		
		
		
		
		
		
		
		
		
		
		
		

//		driver.get("https://pltf.vip/login");
//
//		homePage = new iptvHomePage(driver);
//		amazonHomePage = new AmazonHomePage(driver);
//		Thread.sleep(6000);
//		homePage.preeencherUsuario();
//		homePage.preeencherSenha();
//		homePage.botaoLogar();
//
//		Thread.sleep(7000);
//		String fichas = homePage.obterFichas();
//		int ficha = Integer.parseInt(fichas);
//		homePage.acessarMenuListas();
//
//		String dataExpi = homePage.obterDataExpiracao();
//		String dataExpiracao = dataExpi.substring(0, 10);
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String dataAtual = dtf.format(LocalDateTime.now());
//
//		ficha = 0;
//
//		if (dataExpiracao != dataAtual && ficha == 0) {
//
//			driver.get("https://alexa.amazon.com.br/");
//
//			//amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
//			
//			driver.manage().window().setSize(d);
//			Thread.sleep(2000);
//			amazonHomePage.usu();
//			amazonHomePage.s();
//			amazonHomePage.b();
//			Thread.sleep(9000);
//			amazonHomePage.clicarMenuLembretesAlarme();
//			Thread.sleep(5000);
//			amazonHomePage.butonAdicionarLembretes();
//			amazonHomePage
//					.escreverlembrete("A expiração do IPETÊVÊ é " + dataExpiracao + " porém o saldo é de " + ficha);
//			amazonHomePage.clicarData();
//			Thread.sleep(3000);
//
//			amazonHomePage.clicarHora();
//			Thread.sleep(1000);
//			amazonHomePage.clicarHora();
//			Thread.sleep(1000);
//
//			Date dataHoraAtual = new Date();
//
//			String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//
//			dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
//			String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
//			System.out.println("Aqui está a hora" + horaA);
//
//			amazonHomePage.setarHora(horaA);
//			Thread.sleep(1000);
//			Thread.sleep(1000);
//			amazonHomePage.clicaComboselect();
//			Thread.sleep(1000);
//			amazonHomePage.select();
//			Thread.sleep(1000);
//			amazonHomePage.butonSalvar();
//
//		} else {
//
//			if (dataExpiracao.equals(dataAtual)) {
//
//				System.out.println("data sao iguais");
//
//				if (ficha > 0) {
//
//					Thread.sleep(3000);
//					homePage.clicarBotaoNilson();
//					Thread.sleep(1000);
//					homePage.menuRenovar();
//					Thread.sleep(5000);
//
//					// https://stackoverflow.com/questions/13936167/how-to-deal-with-modaldialog-using-selenium-webdriver
//					driver.switchTo().activeElement();
//					Thread.sleep(1000);
//					homePage.scrollar3();
//
//					Thread.sleep(2000);
//
//					// homePage.comboSelecionar();
//					Thread.sleep(2000);
//
//					// homePage.selecionarPlano25();
//					// homePage.quantidade();
//
//					homePage.botaoRenovar();
//
//					amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
//
//					Thread.sleep(1000);
//
//					
//					Thread.sleep(2000);
//					amazonHomePage.usu();
//					amazonHomePage.s();
//					amazonHomePage.b();
//					driver.manage().window().setSize(d);
//					Thread.sleep(9000);
//					amazonHomePage.clicarMenuLembretesAlarme();
//					Thread.sleep(5000);
//					amazonHomePage.butonAdicionarLembretes();
//					amazonHomePage
//							.escreverlembrete("Renovado os créditos para Nilson agora o saldo é de " + (ficha - 1));
//					amazonHomePage.clicarData();
//					Thread.sleep(3000);
//
//					amazonHomePage.clicarHora();
//					Thread.sleep(1000);
//					amazonHomePage.clicarHora();
//					Thread.sleep(500);
//
//					Date dataHoraAtual = new Date();
//
//					String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//
//					dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
//					String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
//					System.out.println("Aqui está a hora" + horaA);
//
//					amazonHomePage.setarHora(horaA);
//					Thread.sleep(500);
//					amazonHomePage.clicaComboselect();
//					Thread.sleep(500);
//					amazonHomePage.select();
//					Thread.sleep(1000);
//					amazonHomePage.butonSalvar();
//
//				} else {
//
//					amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
//					driver.manage().window().setSize(d);
//
//					Thread.sleep(1000);
//
//					amazonHomePage.usu();
//					amazonHomePage.s();
//					amazonHomePage.b();
//					Thread.sleep(9000);
//					amazonHomePage.clicarMenuLembretesAlarme();
//					Thread.sleep(5000);
//					amazonHomePage.butonAdicionarLembretes();
//					amazonHomePage.escreverlembrete("Acabaram os créditos do IPETÊVÊ saldo é de " + ficha);
//					amazonHomePage.clicarData();
//					Thread.sleep(3000);
//
//					amazonHomePage.clicarHora();
//					Thread.sleep(1000);
//					amazonHomePage.clicarHora();
//					Thread.sleep(500);
//
//					Date dataHoraAtual = new Date();
//					String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//
//					dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
//					String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
//					System.out.println("Aqui está a hora" + horaA);
//
//					amazonHomePage.setarHora(horaA);
//					Thread.sleep(500);
//					Thread.sleep(500);
//					amazonHomePage.clicaComboselect();
//					Thread.sleep(500);
//					amazonHomePage.select();
//					Thread.sleep(1000);
//					amazonHomePage.butonSalvar();
//
//				}
//
//			} else {
//
//				amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
//
//				driver.manage().window().setSize(d);
//
//				Thread.sleep(1000);
//				amazonHomePage.usu();
//				amazonHomePage.s();
//				amazonHomePage.b();
//				Thread.sleep(9000);
//				amazonHomePage.clicarMenuLembretesAlarme();
//				Thread.sleep(5000);
//				amazonHomePage.butonAdicionarLembretes();
//				amazonHomePage.escreverlembrete(
//						"A data de expiração será " + dataExpiracao + " e têm " + ficha + " créditos no momento");
//				amazonHomePage.clicarData();
//				Thread.sleep(3000);
//
//				amazonHomePage.clicarHora();
//				Thread.sleep(1000);
//				amazonHomePage.clicarHora();
//				Thread.sleep(500);
//
//				Date dataHoraAtual = new Date();
//
//				String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//
//				dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
//				String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
//
//				amazonHomePage.setarHora(horaA);
//				Thread.sleep(500);
//				amazonHomePage.clicaComboselect();
//				Thread.sleep(500);
//				amazonHomePage.select();
//				Thread.sleep(1000);
//				amazonHomePage.butonSalvar();
//
//			}
//
//		}

	}

}
