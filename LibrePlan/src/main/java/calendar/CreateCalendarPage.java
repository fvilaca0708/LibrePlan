package calendar;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import exception.ElementNonTrouveException;
import libreplan.LibreplanPage;

public class CreateCalendarPage extends LibreplanPage{

	@FindBy(how=How.XPATH, using="//table[contains(@id,'q4-box')]")
	private WebElement createBtnCal;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'45')]")
	private WebElement nameCalField;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'85-chdex')]/span")
	private WebElement typeCalField;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'d5-real')]")
	private WebElement cbGenCode;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'s4-cnt')]")
	private WebElement titlePage;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'z7-box')]")
	private WebElement saveBtn;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'_8-box')]")
	private WebElement saveContinueBtn;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'08-box')]")
	private WebElement cancelBtn;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'08-box')]")
	private WebElement formCal;
	
	// Sous fenetre expcetion
	@FindBy(how=How.XPATH, using="//input[contains(@id,'s6-real')]")
	private WebElement exceptionInput;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'66-real')]/tbody/tr[3]/td/table/tbody/tr/td/table")
	private WebElement exceptionBtn;
	
	// Not used
	@FindBy(how=How.XPATH, using="//table[contains(@id,'u6-box')]")
	private WebElement exceptionUpdateBtn;

	@FindBy(how=How.XPATH, using="//div[contains(@id,'_z_14_c')]/div")
	private WebElement errorExceptionPopUp;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'g6-real')]")
	private WebElement exceptionDateStart;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'i6-real')]")
	private WebElement exceptionDateEnd;
	

	@FindBy(how=How.XPATH, using="//table[contains(@id,'8a-real')]/tbody/tr/td[1]/i/input")
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'9a-real')]")
	private WebElement exceptionNormEff1;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'8a-real')]/tbody/tr/td[3]/i/input")
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'aa-real')]")
	private WebElement exceptionNormEff2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'ba-real')]/tbody/tr/td[1]/i/input")
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'ca-real')]")
	private WebElement exceptionOvrEff1;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'ba-real')]/tbody/tr/td[3]/i/input")
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'da-real')]")
	private WebElement exceptionOvrEff2;
	
	// Entete
	@FindBy(how=How.XPATH, using="//div[contains(@id,'v4-hm')]")
	private WebElement calDataTab;

	// Enlever les messages et mettre verification directe dans le test //span[.='message']
	@FindBy(how=How.XPATH, using="//td[contains(@id,'i4-frame')]/table/tbody/tr/td/div/span")
	private WebElement message;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'i4-frame')]/table/tbody/tr[3]/td/div/span")
	private WebElement message2;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'i4-frame')]/table/tbody/tr[5]/td/div/span")
	private WebElement message3;

	// Constructeur
	public CreateCalendarPage(WebDriver driver) {
		super(driver);
	}
	
	// Compléter infos du calendrier à créer
	public void createNewCalendar(String nameCal){
		nameCalField.clear();
		nameCalField.sendKeys(nameCal);
		if (!cbGenCode.isSelected())
			cbGenCode.click();
	}
	
	// Retourne la date du jour au format d MM yyyy
	public String dateToday(){
		DateTime dateTime = DateTime.now();
		SimpleDateFormat format = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	// Retourne le numéro de ligne de la journée d'exception recherchée
	public int findExceptionLine(String nomExcpt) throws ElementNonTrouveException{
		List<WebElement> lines = driver.findElements(By.xpath("//tbody[contains(@id,'z6-rows')]/tr"));
		int foundline=0;
		for(WebElement line : lines){
			List<WebElement>cases= line.findElements(By.xpath("td/div/span"));
			if(nomExcpt.equals(cases.get(1).getText())){
				return foundline+1;
			}
			foundline++;
		}
		throw new ElementNonTrouveException();
	}

	public WebElement getCreateBtnCal() {
		return createBtnCal;
	}

	public WebElement getNameCalField() {
		return nameCalField;
	}

	public WebElement getCbGenCode() {
		return cbGenCode;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSaveContinueBtn() {
		return saveContinueBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getFormCal() {
		return formCal;
	}

	public WebElement getTypeCalField() {
		return typeCalField;
	}

	public WebElement getTitlePage() {
		return titlePage;
	}

	public WebElement getCalDataTab() {
		return calDataTab;
	}

	public WebElement getExceptionInput() {
		return exceptionInput;
	}

	public WebElement getExceptionBtn() {
		return exceptionBtn;
	}

	public WebElement getErrorExceptionPopUp() {
		return errorExceptionPopUp;
	}
	
	public WebElement getMessage() {
		return message;
	}

	public WebElement getMessage2() {
		return message2;
	}

	public WebElement getMessage3() {
		return message3;
	}

	public WebElement getExceptionDateStart() {
		return exceptionDateStart;
	}

	public WebElement getExceptionDateEnd() {
		return exceptionDateEnd;
	}

	public WebElement getExceptionNormEff1() {
		return exceptionNormEff1;
	}

	public WebElement getExceptionNormEff2() {
		return exceptionNormEff2;
	}

	public WebElement getExceptionOvrEff1() {
		return exceptionOvrEff1;
	}

	public WebElement getExceptionOvrEff2() {
		return exceptionOvrEff2;
	}
	
	public WebElement getExceptionUpdateBtn() {
		return exceptionUpdateBtn;
	}
}
