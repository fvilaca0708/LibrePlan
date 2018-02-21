package libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import calendar.CalendarListPage;
import calendar.CreateCalendarPage;
import calendar.CreateExceptionDayPage;
import calendar.ExceptionDaysListCalendarPage;
import exception.ElementNonTrouveException;
import libreplan.LoginPage;

@FixMethodOrder(MethodSorters.JVM)
public class CalendarTest {
	private WebDriver driver;
	
	private LoginPage logPage;
	private LibreplanPage lpPage;
	private CalendarListPage calListPage;
	private CreateCalendarPage createCalPage;
	private CreateExceptionDayPage createExcptDayPage;
	private ExceptionDaysListCalendarPage excptDListPage;
	
	private static final String login="admin";
	private static final String pass="admin";
	
	public void waitVisibleElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitClickableElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public WebElement waitIsClickableElement(WebElement element){
		WebDriverWait wait= new WebDriverWait(driver,200);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitIsVisibleElement(WebElement element){
		WebDriverWait wait= new WebDriverWait(driver,200);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void doAssertTrueIsDisplayed(WebElement[] tabEle){
		for(int i=0; i<tabEle.length; i++)
			assertTrue(tabEle[i].isDisplayed());
	}
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		logPage=new LoginPage(driver);
		logPage.connexion(login, pass);	
	}
	
	
	public void tearDown(){
		driver.quit();
	}
	
	// Test 1 Calendrier
	@Test
	public void t1createCalendarTest() throws ElementNonTrouveException, InterruptedException{
		String nomDuCal = "Test 1";
		String nomDuCalNew = "Test 2";
		String nomDuCalDeriv = "Test Calendrier Dérivé";
		
		lpPage=new LibreplanPage(driver);
		
		// 2
		lpPage.goToPage(lpPage.getMenuResources(), lpPage.getBtnCalendars());
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'y3-real')]");
		WebElement tabCalList[] = {calListPage.getNamehead(),calListPage.getInfromhead(),calListPage.getInupdatehead(),calListPage.getOperationhead(),calListPage.getCreateBtnCal()};
		doAssertTrueIsDisplayed(tabCalList);
		
		// 3
		calListPage.getCreateBtnCal().click();
		
		// 4
		createCalPage=new CreateCalendarPage(driver);
		waitVisibleElement("//div[contains(@id,'x4')]");
		waitClickableElement("//table[contains(@id,'z7-box')]");
		// Verification de présence formulaire
		WebElement tabCreateCal[]={createCalPage.getCalDataTab(),createCalPage.getCancelBtn(), createCalPage.getSaveBtn(), createCalPage.getSaveContinueBtn()};
		doAssertTrueIsDisplayed(tabCreateCal);
		// Verification bouton
		createCalPage.createNewCalendar(nomDuCal);
		createCalPage.getSaveBtn().click();
		
		// 5
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		Thread.sleep(100);
		assertTrue(driver.findElement(By.xpath("//span[.='Base calendar \"Test 1\" saved']")).isDisplayed());
		assertEquals("Calendars List",calListPage.getTitleListCal().getText());
		calListPage.clickToCreateDerived(calListPage.findCalendarLine(nomDuCal));
		
		// 6
		createCalPage=new CreateCalendarPage(driver);
		waitVisibleElement("//div[contains(@id,'x4')]");
		createCalPage.createNewCalendar(nomDuCal);
		createCalPage.getSaveContinueBtn().click();
		// Assert 
		Thread.sleep(100);
		//assertTrue(driver.findElement(By.xpath("//span[.='Test 1 already exists']")).isDisplayed());
		
		// 7
		waitVisibleElement("//input[contains(@id,'45')][@type='text']");
		waitClickableElement("//table[contains(@id,'_8-box')]");
		createCalPage.createNewCalendar(nomDuCalDeriv);
		createCalPage.getSaveContinueBtn().click();
		
		// 8
		waitClickableElement("//table[contains(@id,'08-box')]");
		createCalPage.getCancelBtn().click();
		
		// 9
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		assertTrue(calListPage.findCalendarInTab(nomDuCal));
		assertTrue(calListPage.findDerivedCalendarInTab(nomDuCalDeriv));
		calListPage.clickToMinus(calListPage.findCalendarLine(nomDuCal));
		// Verification calendrier dérivé non présent dans la liste après avoir cliqué sur -
		assertFalse(calListPage.findCalendarInTab(nomDuCalDeriv));
		
		// 10
		calListPage.clickToCreateCopy(calListPage.findCalendarLine(nomDuCal));
		
		//11
		createCalPage=new CreateCalendarPage(driver);
		waitVisibleElement("//input[contains(@id,'45')][@type='text']");
		assertEquals(nomDuCal,createCalPage.getNameCalField().getAttribute("value"));
		assertEquals("Root calendar", createCalPage.getTypeCalField().getText());
		createCalPage.getSaveBtn().click();
		Thread.sleep(100);
		assertTrue(driver.findElement(By.xpath("//span[.='Test 1 already exists']")).isDisplayed());
		
		// 12
		createCalPage.createNewCalendar(nomDuCalNew);
		createCalPage.getSaveBtn().click();
		
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		Thread.sleep(100);
		assertTrue(driver.findElement(By.xpath("//span[.='Base calendar \"Test 2\" saved']")).isDisplayed());
	}
	
	// Test 2 Calendrier
	@Test
	public void t2addExceptionCalendarTest() throws ElementNonTrouveException, InterruptedException{
		String nomDuCal = "Test 2";
		
		lpPage=new LibreplanPage(driver);
		
		// 2
		lpPage.goToPage(lpPage.getMenuResources(), lpPage.getBtnCalendars());
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'y3-real')]");
		// Assert verifcation page list calendrier
		WebElement tabCalList[] = {calListPage.getNamehead(), calListPage.getInfromhead(), calListPage.getInupdatehead(),calListPage.getOperationhead(),calListPage.getCreateBtnCal()};
		doAssertTrueIsDisplayed(tabCalList);
		
		// 3
		calListPage.clickToEdit(calListPage.findCalendarLine(nomDuCal));
		
		// 4
		createCalPage=new CreateCalendarPage(driver);
		waitVisibleElement("//div[contains(@id,'x4')]");
		waitClickableElement("//table[contains(@id,'z7-box')]");
		// Verification de présence formulaire
		WebElement tabCreateCal[] = {createCalPage.getCalDataTab(), createCalPage.getCancelBtn(), createCalPage.getSaveBtn(), createCalPage.getSaveContinueBtn()};
		doAssertTrueIsDisplayed(tabCreateCal);
		assertEquals("Edit Calendar: Test 2", createCalPage.getTitlePage().getText());
		createCalPage.getExceptionBtn().click();
		waitVisibleElement("//div[contains(@id,'x4')]");
		//assertTrue(driver.findElement(By.xpath("//div[.='Please, select type of exception']")).isDisplayed());
		
		// 5
		createCalPage.getExceptionInput().clear();
		createCalPage.getExceptionInput().sendKeys("BANK_HOLIDAY");
		createCalPage.getExceptionBtn().click();
		Thread.sleep(250);
		assertTrue(driver.findElement(By.xpath("//div[.='Please, select an End Date for the Exception']")).isDisplayed());
		
		// 6
		createCalPage.getExceptionDateEnd().sendKeys(createCalPage.dateToday());
		createCalPage.getExceptionBtn().click();
		
		// 7
		Thread.sleep(100);
		createCalPage.getExceptionNormEff1().clear();
		createCalPage.getExceptionNormEff1().sendKeys("1");
		Thread.sleep(100);
		createCalPage.getExceptionNormEff2().clear();
		createCalPage.getExceptionNormEff2().sendKeys("1");
		Thread.sleep(100);
		createCalPage.getExceptionOvrEff1().clear();
		createCalPage.getExceptionOvrEff1().sendKeys("2");
		Thread.sleep(100);
		createCalPage.getExceptionOvrEff2().clear();
		createCalPage.getExceptionOvrEff2().sendKeys("2");
	
		Thread.sleep(100);
		driver.findElement(By.xpath("//td[.='Update exception']")).click();
		
		// 8 
		Thread.sleep(100);
		createCalPage.getSaveBtn().click();
		
		// 9
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//tbody[contains(@id,'k4-rows')]");
		
		// 10
		calListPage.clickToEdit(calListPage.findCalendarLine(nomDuCal));
		createCalPage = new CreateCalendarPage(driver);
		// Assertligne exception présente (impossible car ne peut récupérer le code du calendrier)
		waitVisibleElement("//table[contains(@id,'08-box')]");
		assertTrue(driver.findElement(By.xpath("//span[.='BANK_HOLIDAY']")).isDisplayed());
		
		// 11
		createCalPage.getCancelBtn().click();
		
		// 12
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//tbody[contains(@id,'k4-rows')]");
		calListPage.clickToCreateDerived(calListPage.findCalendarLine(nomDuCal));
		createCalPage = new CreateCalendarPage(driver);
		waitVisibleElement("//table[contains(@id,'08-box')]");
		// Assertligne exception présente (impossible car ne peut récupérer le code du calendrier)
		assertTrue(driver.findElement(By.xpath("//span[.='BANK_HOLIDAY']")).isDisplayed());
		
		// 13
		createCalPage.getCancelBtn().click();
		
		// 14 
		calListPage=new CalendarListPage(driver);
		waitVisibleElement("//tbody[contains(@id,'k4-rows')]");
		calListPage.clickToCreateCopy(calListPage.findCalendarLine(nomDuCal));
		createCalPage = new CreateCalendarPage(driver);
		waitVisibleElement("//table[contains(@id,'08-box')]");
		// Assertligne exception présente (impossible car ne peut récupérer le code du calendrier)
		assertTrue(driver.findElement(By.xpath("//span[.='BANK_HOLIDAY']")).isDisplayed());
		
	}
	
	// Test 3 Calendrier
	@Test
	public void t3addExceptionDayTest() throws InterruptedException, ElementNonTrouveException{
		String nomExceptDay = "TEST_DAY";
		String nomDuCal = "Test 2";
		
		lpPage=new LibreplanPage(driver);
		
		// 2
		lpPage.goToPage(lpPage.getMenuResources(), lpPage.getBtnCalendarExceptDays());
		excptDListPage = new ExceptionDaysListCalendarPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		// Assert des elements page ExceptionDayList
		WebElement tabEleExceptDayList[] = {excptDListPage.getNamehead(),excptDListPage.getColorhead(), excptDListPage.getOverallhead(),excptDListPage.getStandeffhead(),excptDListPage.getOvrtimehead(),excptDListPage.getOphead(),excptDListPage.getCreateExcptDayBtn()};
		doAssertTrueIsDisplayed(tabEleExceptDayList);
		
		// 3
		excptDListPage.getCreateExcptDayBtn().click();
		createExcptDayPage = new CreateExceptionDayPage(driver);
		waitVisibleElement("//div[contains(@id,'05-body')]");
		// Assert des elements page CreateExpcetionDay
		WebElement tabEleCreateExceptDay[] = {createExcptDayPage.getNameField(),createExcptDayPage.getCodeField(), createExcptDayPage.getColorSelect(),createExcptDayPage.getStdEffField1(),createExcptDayPage.getStdEffField2(),createExcptDayPage.getExtEffField1(),createExcptDayPage.getExtEffField2(),createExcptDayPage.getExtEffchkbox(),createExcptDayPage.getEditTab(),createExcptDayPage.getSaveExcptBtn(),createExcptDayPage.getSaveAndContinueExcptBtn(),createExcptDayPage.getCancelExcptBtn()};
		doAssertTrueIsDisplayed(tabEleCreateExceptDay);

		// 4 
		createExcptDayPage.getNameField().sendKeys(nomExceptDay);
		createExcptDayPage.getCancelExcptBtn().click();
		
		// 5
		excptDListPage = new ExceptionDaysListCalendarPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		// Assert des elements page ExceptionDayList
		doAssertTrueIsDisplayed(tabEleExceptDayList);
		//Assert ligne TEST_DAY non présent
		assertFalse(excptDListPage.findExceptDayInTab(nomExceptDay));
		excptDListPage.getCreateExcptDayBtn().click();
		
		// 6 
		createExcptDayPage = new CreateExceptionDayPage(driver);
		waitVisibleElement("//div[contains(@id,'05-body')]");
		// assert sur le numéro généré obtainedCode + 1
		
		// 7 
		createExcptDayPage.getNameField().sendKeys(nomExceptDay);
		Select selectColor = new Select(createExcptDayPage.getColorSelect());
		String tabColor[] = {"red (default)", "green", "blue", "cyan", "magenta", "yellow", "black", "orange", "purple"};
		String tabNuances[][] = 
			{{"background-color: rgb(255, 51, 51);","background-color: rgb(255, 153, 153);"},
				{"background-color: rgb(46, 230, 46);","background-color: rgb(138, 230, 138);"},
				{"background-color: rgb(51, 51, 255);","background-color: rgb(153, 153, 255);"},
				{"background-color: rgb(51, 255, 255);","background-color: rgb(153, 255, 255);"},
				{"background-color: rgb(255, 51, 255);","background-color: rgb(255, 153, 255);"},
				{"background-color: rgb(230, 230, 46);","background-color: rgb(230, 230, 161);"},
				{"background-color: rgb(51, 51, 51);", "background-color: rgb(153, 153, 153);"},
				{"background-color: rgb(255, 183, 51);","background-color: rgb(255, 219, 153);"},
				{"background-color: rgb(128, 26, 128);", "background-color: rgb(179, 142, 179);"}};
		for(int i=0; i<tabColor.length; i++){
			selectColor.selectByVisibleText(tabColor[i]);
			Thread.sleep(100);
			assertEquals(tabNuances[i][0],createExcptDayPage.getColorOwn().getAttribute("style"));
			assertEquals(tabNuances[i][1],createExcptDayPage.getColorInh().getAttribute("style"));
		}
			
		
		// 8
		createExcptDayPage.getStdEffField1().clear();
		createExcptDayPage.getStdEffField1().sendKeys("-1");
		waitIsVisibleElement(createExcptDayPage.getStdEffField1());
		createExcptDayPage.getEditTab().click();
		// Assert Message affichant erreur
		Thread.sleep(200);
		assertTrue(driver.findElement(By.xpath("//div[.='Out of range (>= 0).']")).isDisplayed());
		
		// 9 
		createExcptDayPage.getStdEffField1().clear();
		createExcptDayPage.getStdEffField1().sendKeys("1");
		createExcptDayPage.getStdEffField2().clear();
		createExcptDayPage.getStdEffField2().sendKeys("-1");
		createExcptDayPage.getEditTab().click();
		// Assert Message affichant erreur
		Thread.sleep(200);
		assertTrue(driver.findElement(By.xpath("//div[.='Out of range (0 ~ 59).']")).isDisplayed());		
		
		// 10
		Thread.sleep(200);
		createExcptDayPage.getStdEffField2().clear();
		createExcptDayPage.getStdEffField2().sendKeys("1");
		Thread.sleep(200);
		createExcptDayPage.getExtEffField1().clear();
		createExcptDayPage.getExtEffField1().sendKeys("-1");
		Thread.sleep(200);
		createExcptDayPage.getSaveExcptBtn().click();
		Thread.sleep(200);
		assertTrue(driver.findElement(By.xpath("//div[.='Out of range (>= 0).']")).isDisplayed());
		
		// 11
		waitVisibleElement("//div[contains(@id,'05-body')]");
		createExcptDayPage.getExtEffField1().clear();
		createExcptDayPage.getExtEffField1().sendKeys("5");
		//waitIsVisibleElement(createExcptDayPage.getExtEffField1());
		Thread.sleep(200);
		createExcptDayPage.getExtEffField2().clear();
		createExcptDayPage.getExtEffField2().sendKeys("-1");
		//waitIsVisibleElement(createExcptDayPage.getExtEffField2());
		createExcptDayPage.getSaveAndContinueExcptBtn().click();
		//assertTrue(driver.findElement(By.xpath("//div[.='Out of range (0 ~ 59).']")).isDisplayed());
		
		// 12
		waitVisibleElement("//div[contains(@id,'05-body')]");
		Thread.sleep(200);
		createExcptDayPage.getExtEffField2().clear();
		createExcptDayPage.getExtEffField2().sendKeys("3");
		//waitIsVisibleElement(createExcptDayPage.getExtEffField2());
		Thread.sleep(200);
		createExcptDayPage.getSaveExcptBtn().click();
		
		excptDListPage= new ExceptionDaysListCalendarPage(driver);
		// Assert verification ligne présente
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		Thread.sleep(200);
		assertTrue(excptDListPage.findExceptDayInTab(nomExceptDay));
		//String tabExcptDayCreated[] = {"TEST_DAY", "purple", "No", "1:1", "5:3"};
		//System.out.println(excptDListPage.findExceptDayLine(nomExceptDay));
		//assertTrue(excptDListPage.exceptDayIsCorrect(excptDListPage.findExceptDayLine(nomDuCal), tabExcptDayCreated));
		
		
		// 13
		excptDListPage.goToPage(excptDListPage.getMenuResources(), excptDListPage.getBtnCalendars());
		calListPage= new CalendarListPage(driver);
		waitVisibleElement("//div[contains(@id,'k4-body')]");
		WebElement tabCalList[] = {calListPage.getNamehead(), calListPage.getInfromhead(), calListPage.getInupdatehead(),calListPage.getOperationhead(),calListPage.getCreateBtnCal()};
		doAssertTrueIsDisplayed(tabCalList);
		
		// 14
		calListPage.clickToEdit(calListPage.findCalendarLine(nomDuCal));
		createCalPage= new CreateCalendarPage(driver);
		waitVisibleElement("//table[contains(@id,'08-box')]");
		
		// 15
		createCalPage.getExceptionInput().clear();
		createCalPage.getExceptionInput().sendKeys("TEST_DAY");
		Thread.sleep(200);
		
		// 16
		createCalPage.getExceptionDateEnd().sendKeys(createCalPage.dateToday());
		
		// 17
		createCalPage.getExceptionBtn().click();
	}
}
