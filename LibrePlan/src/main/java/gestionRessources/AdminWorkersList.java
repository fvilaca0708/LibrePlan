package gestionRessources;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class AdminWorkersList extends LibreplanPage {
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'d5-chdex')]/input[contains(@id,'d5')]")
	protected WebElement champFiltre;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'n5-box')]")
	protected WebElement btnFiltre;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'q5-real')]")
	protected WebElement champPageDeb;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'q5-real')]")
	protected WebElement champPageFin;
	

	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q5-next')]/tbody/tr/td[2]/em/button")
	protected WebElement btnSuivant;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q5-last')]/tbody/tr/td[2]/em/button")
	protected WebElement btnFin;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q5-prev')]/tbody/tr/td[2]/em/button")
	protected WebElement btnPrecedent;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q5-first')]/tbody/tr/td[2]/em/button")
	protected WebElement btnDebut;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'f5-cnt')]")
	protected WebElement btnMoreOption;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'i5-real')]")
	protected WebElement champActivePeriodDeb;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'k5-real')]")
	protected WebElement champActivePeriodFin;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'p5-body')]")
	protected WebElement tableauParticipants;
	
	public AdminWorkersList (WebDriver driver){
		super(driver);
		}
	
	public void verificationAffichage (){
		WebElement titre = driver.findElement(By.xpath("//div[contains(@id,'j4-cap')]"));
		assertEquals("Workers List", titre.getText());
		
		WebElement colonne1 = driver.findElement(By.xpath("//div[contains(@id,'s5-cave')]"));
		assertEquals("Surname", colonne1.getText());
		WebElement colonne2 = driver.findElement(By.xpath("//div[contains(@id,'t5-cave')]"));
		assertEquals("First name", colonne2.getText());
		WebElement colonne3 = driver.findElement(By.xpath("//div[contains(@id,'u5-cave')]"));
		assertEquals("ID", colonne3.getText());
		WebElement colonne4 = driver.findElement(By.xpath("//div[contains(@id,'v5-cave')]"));
		assertEquals("Code", colonne4.getText());
		WebElement colonne5 = driver.findElement(By.xpath("//div[contains(@id,'w5-cave')]"));
		assertEquals("Queue-based", colonne5.getText());
		WebElement colonne6 = driver.findElement(By.xpath("//div[contains(@id,'x5-cave')]"));
		assertEquals("Operations", colonne6.getText());
	}
	
	public void clicCreate (){
		WebElement btnCreate = driver.findElement(By.xpath("//table[contains(@id,'y5-box')]/tbody/tr[2]/td[2]"));
		btnCreate.click();
	}
	
	public void filtre (String testFiltre){
		champFiltre.sendKeys(testFiltre);
		btnFiltre.click();
	}
	
	//assert présence de jean DU
	public void verifyTextPresent(String value)
	{
	  driver.getPageSource().contains(value); ;
	}
	
	public void clearFiltre () {
		champFiltre.clear();
		btnFiltre.click();
	}
	
	public void clickOption (){
		btnMoreOption.click();
	}
	
	public void clickPSuivant (){
		btnSuivant.click();
	}
	public void clickPFin (){
		btnFin.click();
	}
	public void clickPPrecedente (){
		btnPrecedent.click();
	}
	public void clickPDebut (){
		btnDebut.click();
	}
}
