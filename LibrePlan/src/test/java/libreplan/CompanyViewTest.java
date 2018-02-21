package libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import libreplan.LoginPage;

public class CompanyViewTest {
	private WebDriver driver;
	
	private LoginPage logPage;
	private CompanyViewPage CVPage;
	
	@Before
	public void setUp(){
		//System.setProperty("webdriver.firefox.bin", "C://FORMATION//FirefoxPortable//FirefoxPortable.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		logPage=new LoginPage(driver);
		logPage.connexion("admin", "admin");
	}
	
	//Test Pro-TA_01 : Créer un projet
	@Test
	public void testCreationProjet() throws InterruptedException{
		CVPage = new CompanyViewPage(driver);
		//Pas de test 02 : Cliquer sur le bouton pour créer un projet
		CVPage.btnProjet.click();
		Assert.assertTrue(CVPage.popupProjet.isDisplayed());
		Assert.assertTrue(CVPage.champName.isDisplayed());
		Assert.assertTrue(CVPage.champName.getText().isEmpty());
		Assert.assertTrue(CVPage.champTemplate.isDisplayed());
		Assert.assertTrue(CVPage.champTemplate.getText().isEmpty());
		Assert.assertTrue(CVPage.champCode.isDisplayed());
		Assert.assertTrue(CVPage.chboxCode.isDisplayed());
		Assert.assertTrue(CVPage.chboxCode.isSelected());
		Assert.assertTrue(CVPage.champDate.isDisplayed());
		Assert.assertTrue(CVPage.champDeadline.isDisplayed());
		Assert.assertTrue(CVPage.champDeadline.getText().isEmpty());
		Assert.assertTrue(CVPage.champCustomer.isDisplayed());
		Assert.assertTrue(CVPage.champCalendar.isDisplayed());
		Assert.assertTrue(CVPage.champCalendar.getAttribute("value").equals("Default"));
		Assert.assertTrue(CVPage.btnAccept.isDisplayed());
		Assert.assertTrue(CVPage.btnCancel.isDisplayed());
		//Pas de test 03 : Renseigner les champs et créer le projet PROJET_TEST1
		CVPage.nomProjet("PROJET_TEST1");
		CVPage.changerCode("PRJTEST001");
		CVPage.champDate.clear();
		CVPage.champDate.sendKeys(CVPage.datePlusJours(5));
		CVPage.champDeadline.sendKeys(CVPage.datePlusJours(15));
		CVPage.btnAccept.click();
		//Pas de test 04 : Vérifier les onglets du menu vertical
		Assert.assertTrue(CVPage.prjctPlanning.isDisplayed());
		Assert.assertTrue(CVPage.prjctDetails.isDisplayed());
		Assert.assertTrue(CVPage.resourcesLoad.isDisplayed());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(CVPage.advAlloc));
		Assert.assertTrue(CVPage.advAlloc.isDisplayed());
		Assert.assertTrue(CVPage.dashboard.isDisplayed());
		//Pas de test 05 : Vérifier les onglets du menu horizontal
		Assert.assertTrue(CVPage.WBSTab.isDisplayed());
		Assert.assertTrue(CVPage.gDataTab.isDisplayed());
		Assert.assertTrue(CVPage.costTab.isDisplayed());
		Assert.assertTrue(CVPage.progressTab.isDisplayed());
		Assert.assertTrue(CVPage.labelsTab.isDisplayed());
		Assert.assertTrue(CVPage.criterionTab.isDisplayed());
		Assert.assertTrue(CVPage.materialsTab.isDisplayed());
		Assert.assertTrue(CVPage.taskTab.isDisplayed());
		Assert.assertTrue(CVPage.authorizationsTab.isDisplayed());
		//Pas de test 06 : Vérifier le bouton d'enregistrement et d'annulation d'édition
		Assert.assertTrue(CVPage.prjctSave.isDisplayed());
		Assert.assertTrue(CVPage.prjctSave.getAttribute("title").equals("Save Project"));
		Assert.assertTrue(CVPage.prjctCancel.isDisplayed());
		Assert.assertTrue(CVPage.prjctCancel.getAttribute("title").equals("Cancel editing"));
		// Pas de test 07 : Cliquer sur le bouton d'annulation
		CVPage.prjctCancel.click();
		Assert.assertTrue(CVPage.popUpCancel.isDisplayed());
		Assert.assertTrue(CVPage.popUpCancel.getText().equals("Confirm exit dialog"));
		Thread.sleep(500);
		Assert.assertTrue(CVPage.txtPopUp.isDisplayed());
		Assert.assertTrue(CVPage.txtPopUp.getText().equals("Unsaved changes will be lost. Are you sure?"));
		Assert.assertTrue(CVPage.popUpBtnOk.isDisplayed());
		Assert.assertTrue(CVPage.popUpBtnCancel.isDisplayed());
		// Pas de test 08 : Cliquer sur le bouton annuler de la popup
		CVPage.popUpBtnCancel.click();
		Assert.assertTrue(CVPage.WBSTab.isEnabled());
		Assert.assertTrue(CVPage.prjctDetails.isDisplayed());
		// Pas de test 09 : Cliquer de nouveau sur le bouton d'annulation du projet
		CVPage.prjctCancel.click();
		Assert.assertTrue(CVPage.popUpCancel2.isDisplayed());
		Assert.assertTrue(CVPage.popUpCancel2.getText().equals("Confirm exit dialog"));
		Assert.assertTrue(CVPage.txtPopUp2.isDisplayed());
		Assert.assertTrue(CVPage.txtPopUp2.getText().equals("Unsaved changes will be lost. Are you sure?"));
		Assert.assertTrue(CVPage.popUpBtnOk2.isDisplayed());
		Assert.assertTrue(CVPage.popUpBtnCancel2.isDisplayed());
		// Pas de test 10 : Cliquer sur le bouton OK de la popup
		CVPage.popUpBtnOk2.click();	
		Thread.sleep(500);
		CVPage = new CompanyViewPage(driver);
		Assert.assertTrue(CVPage.prjctPlanning.isDisplayed());
		// Pas de test 11 : Aller dans Planning=>Projects
		Actions actions = new Actions(driver);
		actions.moveToElement(CVPage.menuPlanning).build().perform();
		Thread.sleep(500);
		CVPage.goToPage(CVPage.menuPlanning, CVPage.btnProjects);
		// Pas de test 12 : Vérifier la conformité des informations renseignées
		Assert.assertTrue(CVPage.prjctDetails.isDisplayed());
		Assert.assertTrue(CVPage.prjctName.getText().equals("PROJET_TEST1"));
		Assert.assertTrue(CVPage.prjctCode.getText().equals("PRJTEST001"));
		Assert.assertTrue(CVPage.prjctStartDate.getText().equals(CVPage.verifdates(5)));
		Assert.assertTrue(CVPage.prjctEndDate.getText().equals(CVPage.verifdates(15)));
		Assert.assertTrue(CVPage.prjctCustomer.getText().isEmpty());
		Assert.assertTrue(CVPage.prjctBudget.getText().equals("0 €"));
		Assert.assertTrue(CVPage.prjctHours.getText().equals("0"));
		Assert.assertTrue(CVPage.prjctState.getText().equals("PRE-SALES"));
		Assert.assertTrue(CVPage.prjctOptions.isDisplayed());
		Assert.assertTrue(CVPage.prjctOptionsEdit.getAttribute("title").equals("Edit"));
		Assert.assertTrue(CVPage.prjctOptionsDelete.getAttribute("title").equals("Delete"));
		Assert.assertTrue(CVPage.prjctOptionsSchedule.getAttribute("title").equals("See scheduling"));
		Assert.assertTrue(CVPage.prjctOptionsTemplate.getAttribute("title").equals("Create Template"));
	}
	
	//Test PRO-TA_02 : Ajouter des tâches à un projet
	@Test
	public void testAjoutTachesProjet() throws InterruptedException{
		CVPage = new CompanyViewPage(driver);
		// Pas de test 02 : Cliquer sur l'onglet "Liste des projets"
		CVPage.prjctDetails.click();
		Assert.assertTrue(CVPage.tableProjet.isDisplayed());
		Assert.assertTrue(CVPage.caseProjet1.getText().equals("PROJET_TEST1"));
		// Pas de test 03 : Cliquer sur le Projet créé précédemment
		CVPage.caseProjet1.click();
		Assert.assertTrue(CVPage.tabWBS.getText().equals("WBS (tasks)"));
		// Pas de test 04 : Vérifier le fil d'Ariane
		Assert.assertTrue(CVPage.filAriane.isDisplayed());
		Assert.assertTrue(CVPage.filArianeStart.getText().equals("START"));
		Assert.assertTrue(CVPage.filArianePlanning.getText().equals("Planning"));
		Assert.assertTrue(CVPage.filArianeProjectDetails.getText().equals("Project Details"));
		Assert.assertTrue(CVPage.filArianeProjetTest1.getText().equals("PROJET_TEST1"));
		// Pas de test 05 : Créer une nouvelle tâche
		CVPage.addTask("Tache1-P1", "5");
		Assert.assertTrue(CVPage.ligneProjet1.getAttribute("title").equals("Tache1-P1.  Progress:0."));
		Assert.assertTrue(CVPage.scheduleStateTab.isDisplayed());
		Assert.assertTrue(CVPage.btnFullyScheduled.getAttribute("title").equals("Fully scheduled"));
		Assert.assertTrue(CVPage.btnUnschedule.getAttribute("title").equals("Unschedule"));
		Assert.assertTrue(CVPage.codeTab.getText().isEmpty());
		Assert.assertTrue(CVPage.nameTab.getAttribute("value").equals("Tache1-P1"));
		Assert.assertTrue(CVPage.hoursTab.getAttribute("value").equals("5"));
		Assert.assertTrue(CVPage.budgetTab.getAttribute("value").equals("0 €"));
		Assert.assertTrue(CVPage.mustStartAfterTab.getText().isEmpty());
		Assert.assertTrue(CVPage.deadlineTab.getText().isEmpty());
		Assert.assertTrue(CVPage.optionsTab.isDisplayed());
		Assert.assertTrue(CVPage.deadlineTab.getText().isEmpty());
		Assert.assertTrue(CVPage.btnEdit.getAttribute("title").equals("Edit"));
		Assert.assertTrue(CVPage.btnDelete.getAttribute("title").equals("Delete"));
		// Pas de test 06 : Créer plusieurs tâches
		CVPage.addTask("Tache2-P1", "10");
		CVPage.addTask("Tache3-P1", "20");
		CVPage.addTask("Tache4-P1", "8");
		Assert.assertTrue(CVPage.taskLigne1.getAttribute("title").equals("Tache1-P1.  Progress:0."));
		Assert.assertTrue(CVPage.taskLigne2.getAttribute("title").equals("Tache2-P1.  Progress:0."));
		Assert.assertTrue(CVPage.taskLigne3.getAttribute("title").equals("Tache3-P1.  Progress:0."));
		Assert.assertTrue(CVPage.taskLigne4.getAttribute("title").equals("Tache4-P1.  Progress:0."));
		// Pas de test 07 : Modifier l'ordre des tâches
		CVPage.taskLigne1.click();
		CVPage.btnTaskDown.click();
		Assert.assertTrue(CVPage.taskLigneDown.getAttribute("title").equals("Tache2-P1.  Progress:0."));
		Assert.assertTrue(CVPage.taskLigneDown1.getAttribute("title").equals("Tache1-P1.  Progress:0."));
		// Pas de test 08 : Modifier l'ordre des tâches une nouvelle fois
		CVPage.taskLigneDown2.click();
		CVPage.btnTaskUp.click();
		// Pas de test 09 : Renseigner les informations des tâches
		CVPage.ligne1Code.sendKeys("T2");
		CVPage.ligne2Code.sendKeys("T3");
		CVPage.ligne3Code.sendKeys("T1");
		CVPage.ligne4Code.sendKeys("T4");
		CVPage.ligne1MustStart.click();
		CVPage.ligne1MustStart.sendKeys(CVPage.dateTask(8));
		CVPage.ligne3MustStart.click();
		CVPage.ligne3MustStart.sendKeys(CVPage.dateTask(5));
		CVPage.ligne2Deadline.sendKeys(CVPage.dateTask(3));
		CVPage.ligne4Deadline.sendKeys(CVPage.dateTask(5));
		CVPage.taskSave.click();
		Assert.assertTrue(CVPage.popUpSave.isDisplayed());
		Assert.assertTrue(CVPage.popUpSave.getText().equals("Information"));
		Assert.assertTrue(CVPage.popUpSavemsg.isDisplayed());
		Assert.assertTrue(CVPage.popUpSavebtnOk.isDisplayed());
		Assert.assertTrue(CVPage.popUpSavebtnQuit.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(CVPage.popUpSavebtnQuit).build().perform();
		Assert.assertTrue(CVPage.popUpSavebtnQuit.getAttribute("class").equals("z-window-modal-icon z-window-modal-close z-window-modal-close-over"));
		CVPage.popUpSavebtnOk.click();
		// Pas de test 10 : Visualisation de la planification du projet
		Thread.sleep(500);
		CVPage.prjctPlanning.click();
		Assert.assertTrue(CVPage.task1.isDisplayed());
		Assert.assertTrue(CVPage.task2.isDisplayed());
		Assert.assertTrue(CVPage.task2Deadline.isDisplayed());
		Assert.assertTrue(CVPage.task3.isDisplayed());
		Assert.assertTrue(CVPage.task4.isDisplayed());
		Assert.assertTrue(CVPage.task4Deadline.isDisplayed());
	}
	
	//Test PRO-TA_04 : Affichage Planning d'un projet
	@Test
	public void testAffichagePlanningProjet() throws InterruptedException{
		CVPage = new CompanyViewPage(driver);
		// Pas de test 02 : Cliquer sur l'onglet "Liste des projets"
		CVPage.prjctDetails.click();
		// Pas de test 03 : Cliquer sur le projet précédemment créé
		CVPage.projet1Ligne.click();
		Assert.assertTrue(CVPage.WBSTab2.isDisplayed());
		assertEquals("700", CVPage.WBSTab2.getCssValue("font-weight"));
		// Pas de test 04 : Cliquer sur l'onglet "Planification de projet"
		CVPage.prjctPlanning.click();
		Assert.assertFalse(CVPage.projetNom.getText().isEmpty());
		// Pas de test 05 : Dans Zoom sélectionner "Année"
		Select select = new Select(CVPage.zoomDeroulant);
		select.selectByVisibleText("Year");
		Assert.assertTrue(CVPage.ligneSemestre.isDisplayed());
		Assert.assertTrue(CVPage.ligneSemestre1.getText().equals("H1"));
		Assert.assertTrue(CVPage.ligneSemestre2.getText().equals("H2"));
		// Pas de test 06 : Dans Zoom sélectionner "Trimestre"
		select.selectByVisibleText("Quarter");
		Assert.assertTrue(CVPage.ligneTrimestre.isDisplayed());
		Assert.assertTrue(CVPage.ligneTrimestre1.getText().equals("Q1"));
		Assert.assertTrue(CVPage.ligneTrimestre2.getText().equals("Q2"));
		Assert.assertTrue(CVPage.ligneTrimestre3.getText().equals("Q3"));
		Assert.assertTrue(CVPage.ligneTrimestre4.getText().equals("Q4"));
		// Pas de test 07 : Dans Zoom sélectionner "Mois"
		select.selectByVisibleText("Month");
		Assert.assertTrue(CVPage.ligneMois.isDisplayed());
		Assert.assertTrue(CVPage.ligneMoisH1.getText().equals("2017,H1"));
		Assert.assertTrue(CVPage.ligneMoisH2.getText().equals("2017,H2"));
		Assert.assertTrue(CVPage.ligneParMois.isDisplayed());
		Assert.assertTrue(CVPage.ligneMoisJanv.getText().contains("Jan"));
		Assert.assertTrue(CVPage.ligneMoisFev.getText().contains("Feb"));
		Assert.assertTrue(CVPage.ligneMoisMar.getText().contains("Mar"));
		Assert.assertTrue(CVPage.ligneMoisAvr.getText().contains("Apr"));
		Assert.assertTrue(CVPage.ligneMoisMai.getText().contains("May"));
		Assert.assertTrue(CVPage.ligneMoisJuin.getText().contains("Jun"));
		Assert.assertTrue(CVPage.ligneMoisJuill.getText().contains("Jul"));
		Assert.assertTrue(CVPage.ligneMoisAout.getText().contains("Aug"));
		Assert.assertTrue(CVPage.ligneMoisSept.getText().contains("Sep"));
		Assert.assertTrue(CVPage.ligneMoisOct.getText().contains("Oct"));
		Assert.assertTrue(CVPage.ligneMoisNov.getText().contains("Nov"));
		Assert.assertTrue(CVPage.ligneMoisDec.getText().contains("Dec"));
	}
	
	//Test PRO-TA_05 : Imprimer le planning. TEST EN ECHEC. Fenêtre d'impression en erreur
	@Test
	public void testImprimerPlanning() throws InterruptedException{
		CVPage = new CompanyViewPage(driver);
		// Pas de test 02 : Cliquer sur le bouton d'impression
		CVPage.btnPrint.click();
		Assert.assertTrue(CVPage.popUpPrint.isDisplayed());
		Assert.assertTrue(CVPage.popUpPrint.getText().contains("Print configuration"));
		Assert.assertTrue(CVPage.popUpPrintExportOpt.getText().contains("Export options"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxLabels.isSelected());
		Assert.assertTrue(CVPage.popUpPrintExportOptLabels.getText().contains("Show labels"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxResources.isSelected());
		Assert.assertTrue(CVPage.popUpPrintExportOptResources.getText().contains("Show resource assignments"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxExpand.isSelected());
		Assert.assertTrue(CVPage.popUpPrintExportOptExpand.getText().contains("Expand taskgroups"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxProgress.isSelected());
		Assert.assertTrue(CVPage.popUpPrintExportOptProgress.getText().contains("Show progress"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxAllHours.isSelected());
		Thread.sleep(500);
		Assert.assertTrue(CVPage.popUpPrintExportOptAllHours.getText().contains("Show all reported hours"));
		Assert.assertTrue(CVPage.popUpPrintExportOptChboxMoney.isSelected());
		Assert.assertTrue(CVPage.popUpPrintExportOptMoney.getText().contains("Show money cost bar"));
		Assert.assertTrue(CVPage.popUpPrintMessage.isDisplayed());
		Thread.sleep(500);
		Assert.assertTrue(CVPage.popUpPrintBtnOK.isDisplayed());
		Assert.assertTrue(CVPage.popUpPrintBtnCancel.isDisplayed());
		// Pas de test 03 : Cliquer sur Annulation
		CVPage.popUpPrintBtnCancel.click();
		// Pas de test 04 : Cliquer de nouveau sur le bouton d'Impression
		Thread.sleep(500);
		CVPage.btnPrint.click();
		// Pas de test 05 : Décocher toutes les options d'impression
		CVPage.popUpPrintExportOptChboxLabels2.click();
		CVPage.popUpPrintExportOptChboxResources2.click();
		CVPage.popUpPrintExportOptChboxExpand2.click();
		CVPage.popUpPrintExportOptChboxProgress2.click();
		CVPage.popUpPrintExportOptChboxAllHours2.click();
		CVPage.popUpPrintExportOptChboxMoney2.click();
		// Pas de test 06 : Cliquer sur le bouton validant l'impression
		CVPage.popUpPrintBtnOK2.click();
	}
	
	@After
	public void teardown (){
		driver.quit();
	}
	
}
