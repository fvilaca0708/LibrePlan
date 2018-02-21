package criteres;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class PopUpCritere extends LibreplanPage {

	@FindBy(how=How.XPATH, using="//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]")
	private WebElement btnAnnulerDelete;
	
	@FindBy(how=How.XPATH, using="//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td/span/table/tbody/tr[2]/td[2]")
	private WebElement btnOkDelete;
	
	public PopUpCritere (WebDriver driver){
		super(driver);
		}
	
	public void clickAnnulerDelete(){
		btnAnnulerDelete.click();
		
	}
	public void clickOkDelete(){
		btnOkDelete.click();
		
	}
}
