package calendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import exception.ElementNonTrouveException;
import libreplan.LibreplanPage;

public class ExceptionDaysListCalendarPage extends LibreplanPage{

	// WebElements de la page
	@FindBy(how=How.XPATH, using="//div[contains(@id,'k4-body')]")
	private WebElement exceptDaysRow;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'t4-box')]")
	private WebElement createExcptDayBtn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'n4-cave')]")
	private WebElement namehead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'o4-cave')]")
	private WebElement colorhead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'p4-cave')]")
	private WebElement overallhead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'q4-cave')]")
	private WebElement standeffhead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'r4-cave')]")
	private WebElement ovrtimehead;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'s4-cave')]")
	private WebElement ophead;
	
	// Getter des WebElements de la page
	public WebElement getExceptDaysRow() {
		return exceptDaysRow;
	}

	public WebElement getCreateExcptDayBtn() {
		return createExcptDayBtn;
	}

	public WebElement getNamehead() {
		return namehead;
	}

	public WebElement getColorhead() {
		return colorhead;
	}

	public WebElement getOverallhead() {
		return overallhead;
	}

	public WebElement getStandeffhead() {
		return standeffhead;
	}

	public WebElement getOvrtimehead() {
		return ovrtimehead;
	}

	public WebElement getOphead() {
		return ophead;
	}
	
	// Constructeur de la classe ExceptionDaysListCalendarPage
	public ExceptionDaysListCalendarPage(WebDriver driver){
		super(driver);
	}
	
	// Trouver le numéro de la ligne du jour d'exception recherché
	public int findExceptDayLine(String nameExc) throws ElementNonTrouveException{
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		int foundline=0;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span"));
			if(nameExc.equals(cases.get(0).getText())){
				return foundline+1;
			}
			foundline++;
		}
		throw new ElementNonTrouveException();
	}
	
	// Savoir si le jour d'exception est présent dans la table
	public boolean findExceptDayInTab(String nameExc){
		List<WebElement> lines = driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr"));
		boolean foo = false;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span"));
			if(nameExc.equals(cases.get(0).getText())){
				return true;
			}
		}
		return false;
	}
	
	// Savoir si les informations d'un jour d'exception est correct
	public boolean exceptDayIsCorrect(int numline, String tab[]){
		boolean foo = false;
		int i = 0;
		List<WebElement> lines =  driver.findElements(By.xpath("//div[contains(@id,'k4-body')]/table/tbody[2]/tr["+numline+"]/td"));
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("//div/span"));
			if(i < tab.length){
				if (tab[i].equals(cases.get(0).getText())){
					foo=true;
				}
				else
					return false;
			}	
			i++;
		}
		return foo;	
	}
	

}
