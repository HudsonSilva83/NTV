package br.com.iptv.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class iptvHomePage extends BasePage {

	public iptvHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public void botaoLogar() throws InterruptedException {

		clicar(By.xpath("//*[@id=\"aa4751x2\"]/div/main/div/div/div/div/div/form/div/div[2]/div[4]/button/span"));

	}

	public void preeencherUsuario() throws InterruptedException {

		Thread.sleep(1000);
		clicar(By.id("input-13"));
		escrever(By.id("input-13"), "hudsonsilva");

	}

	public void preeencherSenha() throws InterruptedException {

		clicar(By.id("input-17"));
		escrever(By.id("input-17"), "hpereira7");
=======
	
	
	
	public void preencherusuario(){
		
		
		clicar(By.id("input-13"));
		escrever(By.id("input-13"), "hudsonsilva");
		
		
		
	}
	
	
	public void preencherSenha(){
		
		
		clicar(By.id("input-17"));
		escrever(By.id("input-17"), "hpereira7");
		
		
		
	}
	
public void botaoLogar() {
		
		
		clicar(By.xpath("//*[@id=\"aa4751x2\"]/div/main/div/div/div/div/div/form/div/div[2]/div[4]/button/span"));
>>>>>>> f69c6fa8dbf28c12bc52f970c1623ecf422b6c9d

	}
	
	

	public String obterFichas() {

		return obterTexto(By.xpath(
				"/html/body/div[1]/div/div/div/div/div[2]/nav/div[1]/div[1]/div/div[2]/div/div[2]/button/span/b"));

	}

	public void recuarModal() {

		clicar(By.xpath("//*[@id='aa4751x2']/div[2]/nav/div[1]/div[1]/div/div[1]/button"));

	}

	public void acessarMenuListas() throws InterruptedException {

		clicar(By.cssSelector("a[href=\"/list\"]"));
		Thread.sleep(5000);
		scrollar2();

	}

	public void scrollarTela() {
		scrollar();

	}

	public void clicarBotaoNilson() {
		clicar(By.xpath(
				"/html/body/div[1]/div/div/div/div/div[1]/main/div/div/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[8]"));
		// clicarBotaoTabela(null, null, null, null);
		// sclicar(By.xpath("//*[@id=\"aa4751x2\"]/div[1]/main/div/div/div/div/div[4]/div[1]/div/table/tbody/tr[3]/td[8]"));

	}

	public void menuRenovar() {

		clicar(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div"));
	}

	public void selecionarPlano1() {

		// selectCombo(By.cssSelector("div [class=\"v-list v-select-list v-sheet
		// theme--light theme--light\"]"), "Plano Basico, R$ 25,00");
		// clicar(By.xpath("//*[@id=\"list-item-261-0\"]")); esse
		clicar(By.id("list-item-266-0"));

	}

	public void comboSelecionar() {

		clicar(By.cssSelector("div[class=\"v-select__selections\"]"));
	}

	public void quantidade() {

		slider(By.cssSelector("div[class=\"v-slider v-slider--horizontal theme--light\"]"));

	}

	public void botaoRenovar() {
		clicar(By.cssSelector("button[class=\"v-btn v-btn--has-bg theme--light v-size--default primary\"]"));

	}

	public void selecionarPlano25() {
		clicar(By.xpath("//div[contains(text(),'Plano Basico, R$ 25,00')]"));

	}

	public String obterDataExpiracao() {
		return obterTexto(By.xpath(
				"/html/body/div[1]/div/div/div/div/div[1]/main/div/div/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[7]"));

	}

}
