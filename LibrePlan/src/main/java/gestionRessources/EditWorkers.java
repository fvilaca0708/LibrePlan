package gestionRessources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import libreplan.LibreplanPage;

public class EditWorkers extends LibreplanPage{

	@FindBy(how=How.XPATH, using="//div[contains(@id,'o6-cell')]/input[contains(@id,'o6')]")
	protected WebElement champPrenom;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'u6-cell')]/input[contains(@id,'u6')]")
	protected WebElement champNom;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'x6-cell')]/input[contains(@id,'x6')]")
	protected WebElement champID;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'l6-real')]")
	protected WebElement checkboxGenerate;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'17-cell')]/select[contains(@id,'17')]")
	protected WebElement selectType;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'mf-real') or contains(@id,'kf-real')]") 
	protected WebElement btnRadioNewUser;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'k8-cell') or contains(@id,'i8-cell')]/input[contains(@id,'k8') or contains(@id,'i8')]")//div[contains(@id,'i8-cell')] or input[contains(@id,'i8')] or 
	protected WebElement champUserName;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'l8-cell') or contains(@id,'n8-cell')]/input[contains(@id,'l8') or contains(@id,'n8')]")
	protected WebElement champPwd;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'o8-cell') or contains(@id,'q8-cell')]/input[contains(@id,'o8') or contains(@id,'q8')]")
	protected WebElement champPwd2;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'r8-cell') or contains(@id,'t8-cell')]/input[contains(@id,'r8') or contains(@id,'t8')]")
	protected WebElement champEmail;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'9f-box') or contains(@id,'bf-box')]")
	protected WebElement btnAnnuler;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'7f-box') or contains(@id,'9f-box')]")
	protected WebElement btnSave;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'8f-box') or contains(@id,'af-box')]")
	protected WebElement btnSaveContinue;
	
	public EditWorkers (WebDriver driver){
		super(driver);
		}
	
	public void selecGenerate(){
		if (!checkboxGenerate.isSelected()){
			checkboxGenerate.click();
		}
	}
	
	public void ajoutNom(String prenom, String nom, String iD, String type){
		champPrenom.sendKeys(prenom);
		champNom.sendKeys(nom);
		champID.sendKeys(iD);
		Select selType = new Select(selectType);
		selType.selectByVisibleText(type);
		}
	
	public void selecNewUser (){
		btnRadioNewUser.click();
	}
	
	public void ajoutNewUser(String username, String pwd, String pwd2, String email){
		champUserName.sendKeys(username);
		champPwd.sendKeys(pwd);
		champPwd2.sendKeys(pwd2);
		champEmail.sendKeys(email);
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
