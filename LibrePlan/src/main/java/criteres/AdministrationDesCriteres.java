package criteres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import exception.ElementNonTrouveException;
import libreplan.LibreplanPage;

import static org.junit.Assert.*;

import java.util.List;

public class AdministrationDesCriteres extends LibreplanPage {
	
	@FindBy(how=How.LINK_TEXT, using="Critère - Test bouton [annuler]")
	protected WebElement critAnnul;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'k4-body')]")
	protected WebElement tableauAdmin;
	
	public AdministrationDesCriteres (WebDriver driver){
		super(driver);
		}
	
	public void verificationAffichage (){
		WebElement titre = driver.findElement(By.xpath("//div[contains(@id,'j4-cap')]"));
		assertEquals("Criterion Types List", titre.getText());
		
		WebElement colonne1 = driver.findElement(By.xpath("//div[contains(@id,'m4-cave')]"));
		assertEquals("Name", colonne1.getText());
		
		WebElement colonne2 = driver.findElement(By.xpath("//div[contains(@id,'n4-cave')]"));
		assertEquals("Code", colonne2.getText());
		
		WebElement colonne3 = driver.findElement(By.xpath("//div[contains(@id,'o4-cave')]"));
		assertEquals("Type", colonne3.getText());
		
		WebElement colonne4 = driver.findElement(By.xpath("//div[contains(@id,'p4-cave')]"));
		assertEquals("Enabled", colonne4.getText());
		
		WebElement colonne5 = driver.findElement(By.xpath("//div[contains(@id,'q4-cave')]"));
		assertEquals("Operations", colonne5	.getText());
		
		WebElement btnCreate = driver.findElement(By.xpath("//table[contains(@id,'_5-box')]/tbody/tr[2]/td[2]"));
		assertEquals("Create", btnCreate.getText());
		
	}
	
	public void clicCreate (){
		WebElement btnCreate = driver.findElement(By.xpath("//table[contains(@id,'_5-box')]/tbody/tr[2]/td[2]"));
		btnCreate.click();
	}
	
	public void verificationAnnulation (){
		WebElement colonne1 = driver.findElement(By.xpath("//div[contains(@id,'m4-cave')]"));
		assertEquals("Name", colonne1.getText());
		
	}
	
	public int trouverCritere (String nameCrit)throws ElementNonTrouveException{
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		int foundline=0;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span"));
			if(nameCrit.equals(cases.get(0).getText())){
				
				return foundline+1;	
			}
			foundline++;
		}
		throw new ElementNonTrouveException();
	}
	
	/*public void verifyTextPresent(String value)
	{
	  driver.getPageSource().contains(value); ;
	}*/
	
	public void clickToDelete(int numLine){
		WebElement deleteBtn = driver.findElement(By.xpath("//div[contains(@id,'j4-cave')]/div/div[3]/table/tbody[2]/tr["+numLine+"]/td[5]/div/table/tbody/tr/td/table/tbody/tr/td[3]/span"));
		deleteBtn.click();
	}
	
	public void clickToModify(int numLine){
		WebElement modifyBtn = driver.findElement(By.xpath("//div[contains(@id,'j4-cave')]/div/div[3]/table/tbody[2]/tr["+numLine+"]/td[5]/div/table/tbody/tr/td/table/tbody/tr/td/span[1]"));
		modifyBtn.click();
	}
	
	

}
