package br.com.iptv.auto;
//
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.iptv.auto.Contador.ArquivoContador;

public class iptvAutoTest {

	private WebDriver driver;
	private iptvHomePage homePage;
	private AmazonHomePage amazonHomePage;
	Dimension d = new Dimension(1920, 1080);
	private ArquivoContador cont = new ArquivoContador();
    
    
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void inicio() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless=chrome");
		//options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		// options.addArguments("--disable-extensions");
		//options.addExtensions(new File("C:\\setProfile\\extension_1_3_1_0.crx"));
		options.addExtensions(new File("extension_1_3_1_0.crx"));
		//options.addArguments("--window-size=1820,1080");
		// options.addArguments(
		// "--user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36
		// (KHTML,like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//		capabilities.setCapability("browserName", "Chrome");
//		capabilities.setCapability("version", "99.0");
//		capabilities.setCapability("platform", "Windows 10");
//		capabilities.setCapability("selenium_version", "3.13.0");
//		capabilities.setCapability("geoLocation", "AM");
//		capabilities.setCapability("driver_version", "97.0");
		// options.merge(capabilities);
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	

//		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--headless");
//		
//		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 OPR/60.0.3255.170";
//		options.addPreference("general.useragent.override",userAgent);
//		
//		
//		
//		//options.addArguments("--window-size=1200,800");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--no-sandbox");
		// options.addArguments("--disable-dev-shm-usage");
//		driver = new FirefoxDriver(options);	
//		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
//     	amazonHomePage = new AmazonHomePage(driver);
//		

//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1200,800");
//		options.addArguments("browserVersion", "99");
//		options.addArguments("platformName", "Windows 10");

		// options.addArguments("--user-agent=\"Mozilla/99.0.4844.51 (X11; Linux x86_64)
		// AppleWebKit/537.36 (KHTML,like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		// options.addArguments("--incognito");
		// driver = new ChromeDriver(options);
		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

		// driver = new ChromeDriver();
//		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		amazonHomePage = new AmazonHomePage(driver);

	}

	@Test
	public void teste() throws InterruptedException, EmailException {

		
		
		driver.get("https://pltf.vip/login");

		homePage = new iptvHomePage(driver);
		amazonHomePage = new AmazonHomePage(driver);
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("input-13")));
		
		
		homePage.preeencherUsuario();
		homePage.preeencherSenha();
		homePage.botaoLogar();
		Thread.sleep(7000);
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[2]/div[2]/iframe")));
//
//		Thread.sleep(3000);
//		
//		WebElement element = wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//*[@id=\"rc-imageselect\"]/div[3]/div[2]/div[1]/div[1]/div[4]")));
//		element.click();
//		Thread.sleep(3000);
		
		
		

		//driver.switchTo().defaultContent();
		// https://crxextractor.com/
	
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/nav/div[1]/div[1]/div/div[2]/div/div[2]/button")));
		                                                                 
		
		String fichas = homePage.obterFichas();
		

		int ficha = Integer.parseInt(fichas);
		Thread.sleep(1000);
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		WebElement element4 = wait4.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a[href=\"/list\"]")));
		homePage.acessarMenuListas();

		String dataExpi = homePage.obterDataExpiracao();
		String dataExpiracao = dataExpi.substring(0, 10);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAtual = dtf.format(LocalDateTime.now());
               System.out.println("data de expira????o "+ dataExpiracao);
	       System.out.println("data atual " + dataAtual);
		
	
	                String contador = cont.lerContador();
			int contArq = Integer.parseInt(contador);
		
		
               System.out.println("Galera " + " "+ dataExpiracao + " " + dataAtual + " " + contArq + ficha);
		dataExpiracao = "23";
		dataAtual = "23";
		if ((dataExpiracao == dataAtual)) {
			//if ((dataExpiracao == dataAtual) && (contArq == 1) && (ficha > 0)) {

				System.out.println("data sao iguais e n??o teve mudan??a");

				

					Thread.sleep(3000);
					homePage.clicarBotaoNilson();
					Thread.sleep(1000);
					homePage.menuRenovar();
					Thread.sleep(5000);

					// https://stackoverflow.com/questions/13936167/how-to-deal-with-modaldialog-using-selenium-webdriver
				
					driver.switchTo().activeElement();
					Thread.sleep(1000);
					homePage.scrollar3();
					Thread.sleep(2000);

					homePage.comboSelecionar();
					Thread.sleep(2000);

					homePage.selecionarPlano25();
					
					// homePage.quantidade();

					homePage.botaoRenovar();

					
					cont.salvarContador("1");
										
					NotificarPorEmail email = new NotificarPorEmail();
					String mensagem = "Renovado os cr??ditos para Nilson agora o saldo ?? de " + (ficha - 1) + "Contador "+ cont.lerContador();
					email.EnviarEmail(mensagem);
					whats wts = new whats();
					wts.mensagem(mensagem);
						
		
		
		
				
			}
		
		
//		if (dataExpiracao != dataAtual && ficha == 0) {

//			cont.salvarContador("0");
						
//			NotificarPorEmail email = new NotificarPorEmail();
//			String mensagem = "A expira????o do IPTV ?? " + dataExpiracao + " por??m o saldo ?? de " + ficha + "Segue o site para creditar: https://simpleiptv.app/cart.php?gid=2 Anna83Iraci, https://pltf.vip/login\r\n"
//					+ "Usuario: hudsonsilva\r\n"
//					+ " hpereira7";
//			whats wts = new whats();
//			wts.mensagem(mensagem);
//			email.EnviarEmail(mensagem);
			
			
//		}

			// driver.get("https://alexa.amazon.com.br/");

//			 amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");

//			driver.manage().window().setSize(d);
//			Thread.sleep(2000);
//			amazonHomePage.usu();
//			amazonHomePage.s();
//			amazonHomePage.b();
//			Thread.sleep(5000);
//			@SuppressWarnings("deprecation")
//			WebDriverWait wait3= new WebDriverWait(driver, 50);
//			WebElement element2 = wait3.until(ExpectedConditions
//					.elementToBeClickable(By.id("iTimersAndAlarms")));	
//			
//			
//			amazonHomePage.clicarMenuLembretesAlarme();
			
			
//			Thread.sleep(5000);
//			amazonHomePage.butonAdicionarLembretes();
//			amazonHomePage
//					.escreverlembrete("A expira????o do IPET??V?? ?? " + dataExpiracao + " por??m o saldo ?? de " + ficha);
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
//			System.out.println("Aqui est?? a hora" + horaA);
//
//			amazonHomePage.setarHora(horaA);
//			Thread.sleep(1000);
//			Thread.sleep(1000);
//			amazonHomePage.clicaComboselect();
//			Thread.sleep(1000);
//			amazonHomePage.select();
//			Thread.sleep(1000);
//			amazonHomePage.butonSalvar();

		
			
			
	

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
//							.escreverlembrete("Renovado os cr??ditos para Nilson agora o saldo ?? de " + (ficha - 1));
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
//					System.out.println("Aqui est?? a hora" + horaA);
//
//					amazonHomePage.setarHora(horaA);
//					Thread.sleep(500);
//					amazonHomePage.clicaComboselect();
//					Thread.sleep(500);
//					amazonHomePage.select();
//					Thread.sleep(1000);
//					amazonHomePage.butonSalvar();

				

//					cont.salvarContador("0");
//					NotificarPorEmail email = new NotificarPorEmail();
//					String mensagem = "Acabaram os cr??ditos do IPET??V?? saldo ?? de " + ficha+  "Segue o site para creditar: https://simpleiptv.app/cart.php?gid=2 Anna83Iraci, https://pltf.vip/login\r\n"
//							+ "Usuario: hudsonsilva\r\n"
//							+ " hpereira7" + "Contador "+ cont.lerContador();
//					whats wts = new whats();
//					wts.mensagem(mensagem);
//					email.EnviarEmail(mensagem);
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
//					amazonHomePage.escreverlembrete("Acabaram os cr??ditos do IPET??V?? saldo ?? de " + ficha);
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
//					System.out.println("Aqui est?? a hora" + horaA);
//
//					amazonHomePage.setarHora(horaA);
//					Thread.sleep(500);
//					Thread.sleep(500);
//					amazonHomePage.clicaComboselect();
//					Thread.sleep(500);
//					amazonHomePage.select();
//					Thread.sleep(1000);
//					amazonHomePage.butonSalvar();

				

//			} else {
//
//				cont.salvarContador("0");
//				NotificarPorEmail email = new NotificarPorEmail();
//				String mensagem = "A data de expira????o ser?? " + dataExpiracao + " e t??m " + ficha + " cr??ditos no momento" + "Contador "+ cont.lerContador();
//				whats wts = new whats();
//				wts.mensagem(mensagem);
//				email.EnviarEmail(mensagem);
				
                         
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
//						"A data de expira????o ser?? " + dataExpiracao + " e t??m " + ficha + " cr??ditos no momento");
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

		

	}


}
