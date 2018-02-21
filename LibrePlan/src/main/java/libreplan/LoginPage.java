package libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(how=How.ID, using="textfield")
	private WebElement loginField;
	
	@FindBy(how=How.ID, using="textfield2")
	private WebElement pwField;
	
	@FindBy(how=How.ID, using="button")
	private WebElement button;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void connexion(String login, String pwd){
		loginField.clear();
		loginField.sendKeys(login);
		
		pwField.clear();
		pwField.sendKeys(pwd);
		button.click();
	}
}
