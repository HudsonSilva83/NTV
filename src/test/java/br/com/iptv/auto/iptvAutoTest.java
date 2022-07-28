package br.com.iptv.auto;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iptvAutoTest {

	private WebDriver driver;
	private iptvHomePage homePage;
	private AmazonHomePage amazonHomePage;

	@BeforeEach
	public void inicio() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--window-size=1200,800");
		options.addArguments(
				"-user-agent=\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

		// driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get("https://pltf.vip/login");
		homePage = new iptvHomePage(driver);
		amazonHomePage = new AmazonHomePage(driver);

	}

	@Test
	public void teste() throws InterruptedException {
		Thread.sleep(3000);
		homePage.lo();
		Thread.sleep(6000);
		String fichas = homePage.obterFichas();
		int ficha = Integer.parseInt(fichas);
		homePage.acessarMenuListas();

		String dataExpi = homePage.obterDataExpiracao();
		String dataExpiracao = dataExpi.substring(0, 10);
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy/MM/dd
		// HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAtual = dtf.format(LocalDateTime.now());

		if (dataExpiracao != dataAtual && ficha == 0) {

			amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
			amazonHomePage.autenticarAmazon();
			Thread.sleep(7000);
			amazonHomePage.clicarMenuLembretesAlarme();
			Thread.sleep(1000);
			amazonHomePage.butonAdicionarLembretes();
			amazonHomePage
					.escreverlembrete("A expiração do IPETÊVÊ é " + dataExpiracao + " porém o saldo é de " + ficha);
			amazonHomePage.clicarData();
			// Thread.sleep(3000);
			// amazonHomePage.enterData();
			Thread.sleep(3000);

			amazonHomePage.clicarHora();
			Thread.sleep(1000);
			amazonHomePage.clicarHora();
			Thread.sleep(500);

			Date dataHoraAtual = new Date();

			// String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

			dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
			String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
			System.out.println("Aqui está a hora" + horaA);

			amazonHomePage.setarHora(horaA);
			Thread.sleep(500);
			amazonHomePage.enterHora();
			Thread.sleep(500);
			amazonHomePage.clicaComboselect();
			Thread.sleep(500);
			amazonHomePage.select();
			Thread.sleep(1000);
			amazonHomePage.butonSalvar();

		} else {

			if (dataExpiracao.equals(dataExpiracao)) {

				System.out.println("data sao iguais");

				if (ficha > 0) {

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

					// homePage.comboSelecionar();
					Thread.sleep(2000);

					// homePage.selecionarPlano25();

					// WebElement myDynamicElement = (new WebDriverWait(driver, 15))
					// .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div

					// homePage.quantidade();

					homePage.botaoRenovar();

					Thread.sleep(1000);
					amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
					amazonHomePage.autenticarAmazon();
					Thread.sleep(7000);
					amazonHomePage.clicarMenuLembretesAlarme();
					Thread.sleep(1000);
					amazonHomePage.butonAdicionarLembretes();
					amazonHomePage
							.escreverlembrete("Renovado os créditos para Nilson agora o saldo é de " + (ficha - 1));
					amazonHomePage.clicarData();
					// Thread.sleep(3000);
					// amazonHomePage.enterData();
					Thread.sleep(3000);

					amazonHomePage.clicarHora();
					Thread.sleep(1000);
					amazonHomePage.clicarHora();
					Thread.sleep(500);

					Date dataHoraAtual = new Date();

					// String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
					String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

					dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
					String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
					System.out.println("Aqui está a hora" + horaA);

					amazonHomePage.setarHora(horaA);
					Thread.sleep(500);
					amazonHomePage.enterHora();
					Thread.sleep(500);
					amazonHomePage.clicaComboselect();
					Thread.sleep(500);
					amazonHomePage.select();
					Thread.sleep(1000);
					amazonHomePage.butonSalvar();

				} else {

					Thread.sleep(1000);
					amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
					amazonHomePage.autenticarAmazon();
					Thread.sleep(7000);
					amazonHomePage.clicarMenuLembretesAlarme();
					Thread.sleep(1000);
					amazonHomePage.butonAdicionarLembretes();
					amazonHomePage.escreverlembrete("Acabaram os créditos do IPETÊVÊ saldo é de " + ficha);
					amazonHomePage.clicarData();
					// Thread.sleep(3000);
					// amazonHomePage.enterData();
					Thread.sleep(3000);

					amazonHomePage.clicarHora();
					Thread.sleep(1000);
					amazonHomePage.clicarHora();
					Thread.sleep(500);

					Date dataHoraAtual = new Date();

					// String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
					String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

					dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
					String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
					System.out.println("Aqui está a hora" + horaA);

					amazonHomePage.setarHora(horaA);
					Thread.sleep(500);
					amazonHomePage.enterHora();
					Thread.sleep(500);
					amazonHomePage.clicaComboselect();
					Thread.sleep(500);
					amazonHomePage.select();
					Thread.sleep(1000);
					amazonHomePage.butonSalvar();

				}

			} else {

				// avisar a alexa
				amazonHomePage.acessarPaginaAmazon(1, "https://alexa.amazon.com.br/");
				amazonHomePage.autenticarAmazon();
				Thread.sleep(7000);
				amazonHomePage.clicarMenuLembretesAlarme();
				Thread.sleep(1000);
				amazonHomePage.butonAdicionarLembretes();
				amazonHomePage.escreverlembrete("A data de expiração será "+dataExpiracao+" e têm "+ficha+" créditos no momento");
				amazonHomePage.clicarData();
				// Thread.sleep(3000);
				// amazonHomePage.enterData();
				Thread.sleep(3000);

				amazonHomePage.clicarHora();
				Thread.sleep(1000);
				amazonHomePage.clicarHora();
				Thread.sleep(500);

				Date dataHoraAtual = new Date();

				// String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
				String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

				dataHoraAtual.setMinutes(dataHoraAtual.getMinutes() + 3);
				String horaA = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
				// System.out.println("Aqui está a hora" + horaA);

				amazonHomePage.setarHora(horaA);
				Thread.sleep(500);
				amazonHomePage.enterHora();
				Thread.sleep(500);
				amazonHomePage.clicaComboselect();
				Thread.sleep(500);
				amazonHomePage.select();
				Thread.sleep(1000);
				amazonHomePage.butonSalvar();

			}

		}

	}

}
