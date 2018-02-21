package libreplan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LibreplanPage {

	protected WebDriver driver;

	// WebElement menu resources
	@FindBy(how=How.XPATH, using="//button[contains(@id,'r-b')]")
	//@FindBy(how=How.XPATH, using="//button[substring(@id, string-length(@id) - string-length('r-b') +1) = 'r-b']")
	protected WebElement menuResources;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'t-a')]")
	protected WebElement btnWorkers;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'w-a')]")
	protected WebElement btnCalendars;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'y-a')]")
	protected WebElement btnCriteria;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'x-a')]")
	protected WebElement btnCalendarExceptDays;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'z-a')]")
	protected WebElement btnProgressType;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'00-a')]")
	protected WebElement btnMaterials;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'20-a')]")
	protected WebElement btnQualityForm;
	
	// WebELement menu cost
	@FindBy(how=How.XPATH, using="//button[contains(@id,'p0-b')]")
	//@FindBy(how=How.XPATH, using="//button[substring(@id, string-length(@id) - string-length('r-b') +1) = 'r-b']")
	protected WebElement menuCost;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'r0-a')]")
	protected WebElement btnTimesheets;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'w0-a')]")
	protected WebElement btnHoursType;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'v0-a')]")
	protected WebElement btnCostCategory;
	
	
	// WebELement menu Configuration
	@FindBy(how=How.XPATH, using="//button[contains(@id,'p0-b')]")
	//@FindBy(how=How.XPATH, using="//button[substring(@id, string-length(@id) - string-length('r-b') +1) = 'r-b']")
	protected WebElement menuConfiguration;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'c1-a')]")
	protected WebElement btnProfiles;
	
	// WebELement menu Reports
	@FindBy(how=How.XPATH, using="//button[contains(@id,'Q22-b')]")
	//@FindBy(how=How.XPATH, using="//button[substring(@id, string-length(@id) - string-length('r-b') +1) = 'r-b']")
	protected WebElement menuReports;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'Q82-a')]")
	protected WebElement btnHoursPlannedTask;
	
	
	// WebElement menu Planning
	@FindBy(how=How.XPATH, using="//button[contains(@id,'7-b')]")
	protected WebElement menuPlanning;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'a-a')]")
	protected WebElement btnProjects;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'d0-real')]")
	public WebElement dashboard;
	
	// Constructeur 
	public LibreplanPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methode de récupération du préfixe
	public String prefixeID(){
		WebElement div = driver.findElement(By.xpath("//div"));
		String prefixe=div.getAttribute("id");
		prefixe=prefixe.substring(0, 4);
		return prefixe;
	}
	
	// Methode de navigation géneral
	// @menu représente le bouton de menu pour ouvrir le sous-menu
	// @btn représente le lien d'accès au sous-menu
	public void goToPage(WebElement menu, WebElement btn){
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(btn).build().perform();
		btn.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMenuResources() {
		return menuResources;
	}

	public WebElement getBtnWorkers() {
		return btnWorkers;
	}

	public WebElement getBtnCalendars() {
		return btnCalendars;
	}

	public WebElement getBtnCriteria() {
		return btnCriteria;
	}

	public WebElement getBtnCalendarExceptDays() {
		return btnCalendarExceptDays;
	}

	public WebElement getBtnProgressType() {
		return btnProgressType;
	}

	public WebElement getBtnMaterials() {
		return btnMaterials;
	}

	public WebElement getBtnQualityForm() {
		return btnQualityForm;
	}

	public WebElement getMenuCost() {
		return menuCost;
	}

	public WebElement getBtnTimesheets() {
		return btnTimesheets;
	}

	public WebElement getBtnHoursType() {
		return btnHoursType;
	}

	public WebElement getBtnCostCategory() {
		return btnCostCategory;
	}

	public WebElement getMenuConfiguration() {
		return menuConfiguration;
	}

	public WebElement getBtnProfiles() {
		return btnProfiles;
	}

	public WebElement getMenuReports() {
		return menuReports;
	}

	public WebElement getBtnHoursPlannedTask() {
		return btnHoursPlannedTask;
	}
	
}
