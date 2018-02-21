package calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import libreplan.LibreplanPage;

public class CreateExceptionDayPage extends LibreplanPage{
	
	// WebElement de la page
	@FindBy(how=How.XPATH, using="//div[contains(@id,'y4-hm')]")
	private WebElement editTab;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'85')]")
	private WebElement codeField;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'c5')]")
	private WebElement nameField;

	@FindBy(how=How.XPATH, using="//select[contains(@id,'g5')]")
	private WebElement colorSelect;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'o5-real')]")
	private WebElement stdEffField1;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'p5-real')]")
	private WebElement stdEffField2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'u5-real')]")
	private WebElement extEffField1;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'v5-real')]")
	private WebElement extEffField2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'w5-real')]")
	private WebElement extEffchkbox;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'h5')]")
	private WebElement colorOwn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'j5')]")
	private WebElement colorInh;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'x5-box')]")
	private WebElement saveExcptBtn;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'y5-box')]")
	private WebElement saveAndContinueExcptBtn;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'z5-box')]")
	private WebElement cancelExcptBtn;
	
	// Getters des WebElements
	public WebElement getEditTab() {
		return editTab;
	}

	public WebElement getCodeField() {
		return codeField;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getColorSelect() {
		return colorSelect;
	}

	public WebElement getStdEffField1() {
		return stdEffField1;
	}

	public WebElement getStdEffField2() {
		return stdEffField2;
	}

	public WebElement getExtEffField1() {
		return extEffField1;
	}

	public WebElement getExtEffField2() {
		return extEffField2;
	}

	public WebElement getExtEffchkbox() {
		return extEffchkbox;
	}

	public WebElement getSaveExcptBtn() {
		return saveExcptBtn;
	}

	public WebElement getSaveAndContinueExcptBtn() {
		return saveAndContinueExcptBtn;
	}

	public WebElement getCancelExcptBtn() {
		return cancelExcptBtn;
	}

	public WebElement getColorOwn() {
		return colorOwn;
	}

	public WebElement getColorInh() {
		return colorInh;
	}

	// Constructeur de la classe CreateExceptionDayPage
	public CreateExceptionDayPage(WebDriver driver) {
		super(driver);
	}

}
