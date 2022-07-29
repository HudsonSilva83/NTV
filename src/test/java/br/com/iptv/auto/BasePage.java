package br.com.iptv.auto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escrever(By by, String texto) {

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		// driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);

	}

	public void escrever(String id_campo, String texto) {

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_campo)));
     
		escrever(By.id(id_campo), texto);

	}

	public void escreverCss(String css_campo, String texto) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_campo)));

		driver.findElement(By.cssSelector(css_campo)).sendKeys(texto);

	}

	public void clicarBotao(String css) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
		driver.findElement(By.cssSelector(css)).click();

	}

	public String obterValor(String id_campo) {

		return driver.findElement(By.id(id_campo)).getAttribute("value");

	}

	public String obterTexto(String css) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));

		return driver.findElement(By.cssSelector(css)).getText();

	}

	public String obterTexto(By by) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));

		return driver.findElement(by).getText();

	}

	public String obterValue(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));

		return driver.findElement(by).getAttribute("value");

	}

	public String obterTitle(String css) {

		return driver.findElement(By.cssSelector(css)).getAttribute("title");

	}

	public String obterTitulo() {

		return driver.getTitle();

	}

	public void clicar(String x) {

		driver.findElement(By.cssSelector(x)).click();

	}

	public void clicar(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		
//		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(40))
//		        .until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).click();

	}

	public void clicar2(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		driver.findElement(by).click();

	}

	public void clicarId(By by) {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();

		//driver.findElement(by).click();

	}

	public void clicarCss(String x) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(x)));

		driver.findElement(By.cssSelector(x)).click();

	}

	public void acessarPagina(String url) {

		driver.get(url);

	}

	public void aumentarTela() {

		driver.manage().window().setSize(new Dimension(1200, 765));

	}

	public void clicarLink(String texto) {

		driver.findElement(By.linkText(texto)).click();

	}

	public void aba(int aba, String url) {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(aba));
		driver.get(url);

	}

	public void scrollar() {

		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("scrollBy(0,1300)", "");

	}

	public void scrollar2() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,550)", "");

	}
	
	
	public void scrollar3() {

		//https://stackoverflow.com/questions/52986601/how-to-scroll-down-in-a-dialog-box-using-selenium
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("scrollBy(0,0.5)", "");
		
		
		// Wait for modal
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"v-select__selections\"]")));
		// Select last child of content div
		WebElement element = driver.findElement(By.cssSelector("div[class=\"v-select__selections\"]")); 
		// Scroll to last child node
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}


	public boolean ConteudoPagina(String pesquisa) {

		return driver.getPageSource().contains(pesquisa);

	}

	public void javaClicarData01() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("document.querySelector('input[type=\"checkbox\"]').click();");
		jse.executeScript("document.querySelector('button[class=\"edit-button\"]').click();");

	}

	public void javaClicarData02() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("document.querySelector('button[class=\"edit-button\"]').click();");

	}

	public void javaClicar2() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector('button[class=\"edit-button\"]').click();");

	}

	public void limpar(By by) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		driver.findElement(by).clear();

	}

	public void enter(By by) {

		WebElement enter = driver.findElement(by);
//		enter.sendKeys(Keys.TAB);
//		enter.sendKeys(Keys.TAB);
		enter.sendKeys(Keys.ENTER);

	}

	public void selectCombo(By by) {
		
		WebElement elemnt = driver.findElement(by);
		
     	Select combo = new Select(elemnt);
		//combo.selectByValue("G8M11M11032107V0");
		combo.selectByVisibleText("Casa Hudson");
		
		
	}
	

	

	/************** Tabela *********************/

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		celula.findElement(By.xpath(".//input")).click();

	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
	
	

	
	public void slider(By by) {
		 WebElement slider = driver.findElement(by);

		Actions action  = new Actions(driver);
		action.dragAndDropBy(slider, -150,-20).perform();
	

		}
		

}
	

