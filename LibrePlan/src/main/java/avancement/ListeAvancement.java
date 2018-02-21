package avancement;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class ListeAvancement extends LibreplanPage {
	
	public ListeAvancement (WebDriver driver){
		super(driver);
		}
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'k4-body')]")
	protected WebElement tableauAdminAvcmt;
	
	public void verificationAffichage (){
		WebElement titre = driver.findElement(By.xpath("//div[contains(@id,'j4-cap')]"));
		assertEquals("Progress Types List", titre.getText());
		
		WebElement colonne1 = driver.findElement(By.xpath("//div[contains(@id,'n4-cave')]"));
		assertEquals("Name", colonne1.getText());
		
		WebElement colonne2 = driver.findElement(By.xpath("//div[contains(@id,'o4-cave')]"));
		assertEquals("Enabled", colonne2.getText());
		
		WebElement colonne3 = driver.findElement(By.xpath("//div[contains(@id,'p4-cave')]"));
		assertEquals("Predefined", colonne3.getText());
		
		WebElement colonne4 = driver.findElement(By.xpath("//div[contains(@id,'q4-cave')]"));
		assertEquals("Operations", colonne4.getText());
	}
	
	public void clicCreate (){
		WebElement btnCreate = driver.findElement(By.xpath("//table[contains(@id,'r4-box')]/tbody/tr[2]/td[2]"));
		btnCreate.click();
	}
	
	
}
