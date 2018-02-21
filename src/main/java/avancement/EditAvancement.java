package avancement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class EditAvancement extends LibreplanPage {
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'55-cell')]/input[contains(@id,'55')]")
	protected WebElement champNomUnite;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'b5-cell')]/input[contains(@id,'b5')]")
	protected WebElement maxValue;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'85-real')]")
	protected WebElement checkboxActive;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'k5-real')]")
	protected WebElement checkboxPercentage;

	@FindBy(how=How.XPATH, using="//table[contains(@id,'n5-box')]")
	protected WebElement btnAnnuler;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'l5-box')]")
	protected WebElement btnSave;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'m5-box')]")
	protected WebElement btnSaveContinue;
	
	public EditAvancement (WebDriver driver){
		super(driver);
		}
	
	public void ajoutNomUniteMaxValue(String nom, String valMaxDefault){
		champNomUnite.sendKeys(nom);
		maxValue.clear();
		maxValue.sendKeys(valMaxDefault);
		}
	
	public void ajoutNomUnite (String nom){
		champNomUnite.sendKeys(nom);
	}
	
	public void deselecActive(){
		if (checkboxActive.isSelected()){
			checkboxActive.click();
		}
	}
	
	public void selecActive(){
		if (!checkboxActive.isSelected()){
			checkboxActive.click();
		}
	}
	
	public void deselecPercentage(){
		if (checkboxPercentage.isSelected()){
			checkboxPercentage.click();
		}
	}
	public void selecPercentage(){
		if (!checkboxPercentage.isSelected()){
			checkboxPercentage.click();
		}
	}
	
	public boolean checkCheckBoxPercentage(){
		return checkboxPercentage.isSelected();
	}
	
	public boolean checkCheckBoxActive(){
		return checkboxActive.isSelected();
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
