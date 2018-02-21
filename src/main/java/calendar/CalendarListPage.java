package calendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.ElementNonTrouveException;
import libreplan.LibreplanPage;

public class CalendarListPage extends LibreplanPage{
	
	// WebElement de la page CalendarList
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q4-box')]")
	private WebElement createBtnCal;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'j4-cap')]")
	private WebElement titleListCal;
	
	//Entete du tableau
	@FindBy(how=How.XPATH, using="//div[contains(@id,'m4-cave')]")
	private WebElement namehead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'n4-cave')]")
	private WebElement infromhead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'o4-cave')]")
	private WebElement inupdatehead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'p4-cave')]")
	private WebElement operationhead;

	// Constructeur de la classe CalendarListPage
	public CalendarListPage(WebDriver driver){
		super(driver);
	}
	
	// Trouver la ligne du calendrier  dans la liste
	public int findCalendarLine(String nameCal) throws ElementNonTrouveException{
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		int foundline=0;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span[2]"));
			if(nameCal.equals(cases.get(0).getText())){
				
				return foundline+1;
			}
			foundline++;
		}
		throw new ElementNonTrouveException();
	}
	
	// Savoir si le calendrier est présent dans la liste
	public boolean findCalendarInTab(String nameExc){
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		boolean foo = false;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span[2]"));
			if(nameExc.equals(cases.get(0).getText())){
				return true;
			}
		}
		return false;
	}
	
	// Savoir si le calendrier dérivé est présent dans la liste
	public boolean findDerivedCalendarInTab(String nameExc){
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		boolean foo = false;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span[3]"));
			if(nameExc.equals(cases.get(0).getText())){
				return true;
			}
		}
		return false;
	}
	
	// Methode pour accéder la page de création d'un calendrier dérivé d'un calendrier existant
	public void clickToCreateDerived(int numLine){
		WebElement derivedBtn = driver.findElement(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr["+numLine+"]/td[4]/div/span[1]"));
		derivedBtn.click();
	}
	// Methode pour cacher un calendrier dérivé d'un calendrier existant
	public void clickToMinus(int numLine){
		WebElement minusBtn = driver.findElement(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr["+numLine+"]/td[1]/div/span[1]"));
		minusBtn.click();
	}
	// Methode pour accéder à la page de création d'une copie d'un calendrier existant
	public void clickToCreateCopy(int numLine){
		WebElement copyBtn = driver.findElement(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr["+numLine+"]/td[4]/div/span[2]"));
		copyBtn.click();
	}
	// Methode pour accéder à la page d'édition d'un calendrier existant
	public void clickToEdit(int numLine){
		WebElement copyBtn = driver.findElement(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr["+numLine+"]/td[4]/div/span[3]"));
		copyBtn.click();
	}
	// Getter des WebElements de la page
	public WebElement getCreateBtnCal() {
		return createBtnCal;
	}

	public WebElement getNamehead() {
		return namehead;
	}

	public WebElement getInfromhead() {
		return infromhead;
	}

	public WebElement getInupdatehead() {
		return inupdatehead;
	}

	public WebElement getOperationhead() {
		return operationhead;
	}

	public WebElement getTitleListCal() {
		return titleListCal;
	}
	
}
