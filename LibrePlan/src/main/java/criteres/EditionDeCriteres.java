package criteres;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class EditionDeCriteres extends LibreplanPage {
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'e5-cell')]/input[contains(@id,'e5')]")
	protected WebElement champNom;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'t5-cell')]/textarea[contains(@id,'t5')]")
	protected WebElement champDesc;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'h5-real')]")
	protected WebElement sousMenu;

	@FindBy(how=How.XPATH, using="//table[contains(@id,'j6-box')]")
	protected WebElement btnAnnuler;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'h6-box')]")
	protected WebElement btnSave;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'i6-box')]")
	protected WebElement btnSaveContinue;
	
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'45-hm')]/span")
	protected WebElement edit;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'t4-chdex')]/td/div/span")
	protected WebElement messSAveContinue;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'15-cnt')]")
	protected WebElement titreSaveContinue;
	
	public EditionDeCriteres (WebDriver driver){
		super(driver);
		}
	
	public void ajoutNomDesc(String nom, String desc){
		champNom.sendKeys(nom);
		champDesc.sendKeys(desc);
		sousMenu.clear();
		sousMenu.sendKeys("WORKER");
		
		}
	
	public boolean btnCheckbox (){
		return driver.findElement(By.xpath("//input[contains(@id,'k5-real')]")).isSelected() 
				&& driver.findElement(By.xpath("//input[contains(@id,'n5-real')]")).isSelected() 
				&& driver.findElement(By.xpath("//input[contains(@id,'q5-real')]")).isSelected();
	}
	
	public void modifierNom(String nom1){
		champNom.clear();
		champNom.sendKeys(nom1);
		
		}

	
	
	public void clicAnnuler (){
		btnAnnuler.click();
	}
	
	public void clicSave (){
		btnSave.click();
	}
	
	public void clicSaveContinue (){
		btnSaveContinue.click();
	}
	
	
}
