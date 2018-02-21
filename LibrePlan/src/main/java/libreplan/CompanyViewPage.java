package libreplan;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CompanyViewPage extends LibreplanPage{

	public CompanyViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//td[@class='z-button-cm']/img")
	protected WebElement btnProjet;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'h7')]")
	protected WebElement popupProjet;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'p7')]")
	protected WebElement champName;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'v7-real')]")
	protected WebElement champTemplate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'38')]")
	protected WebElement champCode;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'48-real')]")
	protected WebElement chboxCode;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'k9-real')]")
	protected WebElement champDate;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'n9-real')]")
	protected WebElement champDeadline;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'s9-real')]")
	protected WebElement champCustomer;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'a-real')]")
	protected WebElement champCalendar;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'2a-box')]")
	protected WebElement btnAccept;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'3a-box')]")
	protected WebElement btnCancel;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'f4-box')]")
	protected WebElement prjctPlanning;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'h4-box')]")
	protected WebElement prjctDetails;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'j4-box')]")
	protected WebElement resourcesLoad;

	@FindBy(how=How.XPATH, using="//table[contains(@id,'n4-box')]")
	protected WebElement advAlloc;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'p4-box')]")
	protected WebElement dashboard;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'6c')]")
	protected WebElement WBSTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'7c')]")
	protected WebElement gDataTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'8c')]")
	protected WebElement costTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'9c')]")
	protected WebElement progressTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'ac')]")
	protected WebElement labelsTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'bc')]")
	protected WebElement criterionTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'cc')]")
	protected WebElement materialsTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'dc')]")
	protected WebElement taskTab;
	
	@FindBy(how=How.XPATH, using="//li[contains(@id,'ec')]")
	protected WebElement authorizationsTab;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'u40')]")
	protected WebElement prjctSave;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'v40')]")
	protected WebElement prjctCancel;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'r4-cap')]")
	protected WebElement popUpCancel;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'s4')]/tbody/tr/td/table/tbody/tr/td[3]/div/span")
	protected WebElement txtPopUp;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'y4-box')]")
	protected WebElement popUpBtnOk;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'z4-box')]")
	protected WebElement popUpBtnCancel;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'_5-cap')]")
	protected WebElement popUpCancel2;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'g8')]")
	protected WebElement txtPopUp2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'65-box')]")
	protected WebElement popUpBtnOk2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'i8-box')]")
	protected WebElement popUpBtnCancel2;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'67-cell')]")
	protected WebElement prjctName;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'77-cell')]")
	protected WebElement prjctCode;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'87-cell')]")
	protected WebElement prjctStartDate;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'97-cell')]")
	protected WebElement prjctEndDate;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'a7-cell')]")
	protected WebElement prjctCustomer;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'b7-cell')]")
	protected WebElement prjctBudget;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'c7-cell')]")
	protected WebElement prjctHours;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'d7-cell')]")
	protected WebElement prjctState;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'e7-cell')]")
	protected WebElement prjctOptions;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'f7')]")
	protected WebElement prjctOptionsEdit;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'g7')]")
	protected WebElement prjctOptionsDelete;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'h7')]")
	protected WebElement prjctOptionsSchedule;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'i7')]")
	protected WebElement prjctOptionsTemplate;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'r7-cave')]")
	protected WebElement tableProjet;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'ab-cell')]")
	protected WebElement caseProjet1;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'47-hm')]")
	protected WebElement tabWBS;
	
	@FindBy(how=How.XPATH, using="//td[@class='migas_linea']")
	protected WebElement filAriane;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@class, 'ruta')]/td/strong")
	protected WebElement filArianeStart;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id, '17-chdex')]")
	protected WebElement filArianePlanning;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id, 'p5-chdex')]")
	protected WebElement filArianeProjectDetails;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id, '20-chdex')]")
	protected WebElement filArianeProjetTest1;
		
	@FindBy(how=How.XPATH, using="//input[contains(@id,'i9')]")
	protected WebElement taskName;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'z5')]")
	protected WebElement taskHours;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'_6-box')]")
	protected WebElement taskAdd;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id, 'h7')]")
	protected WebElement ligneProjet1;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'i7-cave')]")
	protected WebElement scheduleStateTab;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'48')]")
	protected WebElement btnFullyScheduled;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'68')]")
	protected WebElement btnUnschedule;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'k9-cave')]")
	protected WebElement codeTab;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'n9')]")
	protected WebElement nameTab;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'p9')]")
	protected WebElement hoursTab;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'pa')]")
	protected WebElement budgetTab;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'u9-chdex')]")
	protected WebElement mustStartAfterTab;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'wa-chdex')]")
	protected WebElement deadlineTab;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'y9-cave')]")
	protected WebElement optionsTab;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'xa')]")
	protected WebElement btnEdit;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'ya')]")
	protected WebElement btnDelete;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'jk')]")
	protected WebElement taskLigne1;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'fo')]")
	protected WebElement taskLigne2;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'8w')]")
	protected WebElement taskLigne3;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'0y')]")
	protected WebElement taskLigne4;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'95-box')]")
	protected WebElement btnTaskDown;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ty')]")
	protected WebElement taskLigneDown;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'i_0')]")
	protected WebElement taskLigneDown1;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'j7')]")
	protected WebElement taskLigneDown2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'b5-box')]")
	protected WebElement btnTaskUp;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'28')]")
	protected WebElement ligne1Code;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'k7')]")
	protected WebElement ligne2Code;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'4i')]")
	protected WebElement ligne3Code;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'0k')]")
	protected WebElement ligne4Code;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'kb-frame')]/table/tbody/tr/td/input")
	protected WebElement ligne1MustStart;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'gc')]")
	protected WebElement ligne2MustStart;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'hj')]")
	protected WebElement ligne3MustStart;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'fk')]")
	protected WebElement ligne4MustStart;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'og')]")
	protected WebElement ligne1Deadline;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'qg')]")
	protected WebElement ligne2Deadline;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'oj')]")
	protected WebElement ligne3Deadline;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'_m')]")
	protected WebElement ligne4Deadline;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'r5-box')]")
	protected WebElement taskSave;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'xq-cap')]")
	protected WebElement popUpSave;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'sx')]")
	protected WebElement popUpSavemsg;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'gy-box')]")
	protected WebElement popUpSavebtnOk;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'xq-close')]")
	protected WebElement popUpSavebtnQuit;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'wb')]")
	protected WebElement task1;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'9c')]")
	protected WebElement task2;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'8c')]")
	protected WebElement task2Deadline;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'uc')]")
	protected WebElement task3;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'7d')]")
	protected WebElement task4;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'6d')]")
	protected WebElement task4Deadline;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'rb-cell')]")
	protected WebElement projet1Ligne;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'47-hm')]/span")
	protected WebElement WBSTab2;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'mf')]")
	protected WebElement projetNom;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'5a')]")
	protected WebElement zoomDeroulant;
	
	@FindBy(how=How.XPATH, using="//option[contains(@id,'6a')]")
	protected WebElement zoomDeroulantYear;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'s50-chdex')]")
	protected WebElement ligneSemestre;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'s50-chdex')]/td/div/table/tbody/tr/td")
	protected WebElement ligneSemestre1;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'s50-chdex')]/td/div/table/tbody/tr/td[2]")
	protected WebElement ligneSemestre2;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ti-chdex')]")
	protected WebElement ligneTrimestre;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ti-chdex')]/td/div/table/tbody/tr/td")
	protected WebElement ligneTrimestre1;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ti-chdex')]/td/div/table/tbody/tr/td[2]")
	protected WebElement ligneTrimestre2;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ti-chdex')]/td/div/table/tbody/tr/td[3]")
	protected WebElement ligneTrimestre3;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'ti-chdex')]/td/div/table/tbody/tr/td[4]")
	protected WebElement ligneTrimestre4;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'yk-chdex')]")
	protected WebElement ligneMois;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'yk-chdex')]/td/div/div/table/tbody[2]/tr/th/div")
	protected WebElement ligneMoisH1;
	
	@FindBy(how=How.XPATH, using="//tr[contains(@id,'yk-chdex')]/td/div/div/table/tbody[2]/tr/th[2]/div")
	protected WebElement ligneMoisH2;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]")
	protected WebElement ligneParMois;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td")
	protected WebElement ligneMoisJanv;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[2]")
	protected WebElement ligneMoisFev;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]")
	protected WebElement ligneMoisMar;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[4]")
	protected WebElement ligneMoisAvr;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[5]")
	protected WebElement ligneMoisMai;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[6]")
	protected WebElement ligneMoisJuin;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[7]")
	protected WebElement ligneMoisJuill;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[8]")
	protected WebElement ligneMoisAout;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[9]")
	protected WebElement ligneMoisSept;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[10]")
	protected WebElement ligneMoisOct;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[11]")
	protected WebElement ligneMoisNov;

	@FindBy(how=How.XPATH, using="//td[contains(@id,'xk-frame')]/table/tbody/tr[3]/td/div/table/tbody/tr/td[12]")
	protected WebElement ligneMoisDec;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'y4-box')]")
	protected WebElement btnPrint;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'x7-cap')]")
	protected WebElement popUpPrint;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'x7-cave')]/fieldset/legend/span")
	protected WebElement popUpPrintExportOpt;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'08-real')]")
	protected WebElement popUpPrintExportOptChboxLabels;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'08')]/label")
	protected WebElement popUpPrintExportOptLabels;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'18-real')]")
	protected WebElement popUpPrintExportOptChboxResources;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'18')]/label")
	protected WebElement popUpPrintExportOptResources;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'28-real')]")
	protected WebElement popUpPrintExportOptChboxExpand;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'28')]/label")
	protected WebElement popUpPrintExportOptExpand;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'48-real')]")
	protected WebElement popUpPrintExportOptChboxProgress;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'48')]/label")
	protected WebElement popUpPrintExportOptProgress;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'58-real')]")
	protected WebElement popUpPrintExportOptChboxAllHours;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'58')]/label")
	protected WebElement popUpPrintExportOptAllHours;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'68-real')]")
	protected WebElement popUpPrintExportOptChboxMoney;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'68')]/label")
	protected WebElement popUpPrintExportOptMoney;
	
	@FindBy(how=How.XPATH, using="//td[contains(@id,'88-chdex')]/span")
	protected WebElement popUpPrintMessage;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'98-box')]")
	protected WebElement popUpPrintBtnOK;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'a8-box')]")
	protected WebElement popUpPrintBtnCancel;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'g8-real')]")
	protected WebElement popUpPrintExportOptChboxLabels2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'h8-real')]")
	protected WebElement popUpPrintExportOptChboxResources2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'i8-real')]")
	protected WebElement popUpPrintExportOptChboxExpand2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'k8-real')]")
	protected WebElement popUpPrintExportOptChboxProgress2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'f8-real')]/tbody/tr[11]/td/span/input")
	protected WebElement popUpPrintExportOptChboxAllHours2;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'m8-real')]")
	protected WebElement popUpPrintExportOptChboxMoney2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'p8-box')]")
	protected WebElement popUpPrintBtnOK2;
	
	@FindBy(how=How.XPATH, using="//table[contains(@id,'q8-box')]")
	protected WebElement popUpPrintBtnCancel2;
				
	public void nomProjet (String nom){
		champName.clear();
		champName.sendKeys(nom);
	}
	
	public void changerCode (String code){
		chboxCode.click();
		champCode.clear();
		champCode.sendKeys(code);
	}
	
	public String datePlusJours(int jours){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(jours);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public String verifdates(int jours){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(jours);
		SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
	
	public void addTask(String nom, String heures){
		taskName.clear();
		taskName.sendKeys(nom);
		taskHours.clear();
		taskHours.sendKeys(heures);
		taskAdd.click();
	}
	
	public String dateTask(int jours){
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM/dd/yyyy").withLocale(Locale.ENGLISH);
		//DateTime dateTime = formatter.parseDateTime(date);
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.plusDays(6+jours);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		return format.format(dateTime.toDate());
	}
}
