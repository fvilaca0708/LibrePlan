package gestionRessources;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import avancement.ListeAvancement;
import libreplan.LibreplanPage;
import libreplan.LoginPage;

public class GestionRessourcesTest {

	private WebDriver driver;
	private LoginPage logPage;
	private LibreplanPage libPage;
	private AdminWorkersList admWork;
	private EditWorkers edWork;

	@Before
	public void setUp() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		driver.manage().deleteAllCookies();
		// PT1
		logPage = new LoginPage(driver);
		logPage.connexion("admin", "admin");
	}

	public void waitVisibleElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitClickableElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	@Test
	public void gre01() throws Exception {

		//D�claration des variables
		String prenom = "Jean";
		String nom = "DU";
		String iD = "jdu";
		String type = "Normal resource";
		String username = iD;
		String pwd = "$jdumdp1";
		String pwd2 = pwd;
		String email = "jdu@test.fr";
		String rechercheFiltre = "Jean";
		
		
		// PT2 - Acces � la page de gestion des participants
		libPage = new LibreplanPage(driver);
		waitClickableElement("//button[contains(@id,'r-b')]");
		libPage.goToPage(libPage.getMenuResources(), libPage.getBtnWorkers());

		admWork = new AdminWorkersList(driver);
		waitVisibleElement("//div[contains(@id,'h4-cave')]");
		admWork.verificationAffichage();

		// PT3 - acces au formulaire de cr�ation
		admWork.clicCreate();

		// PT4 - conformit� des donn�es
		edWork = new EditWorkers(driver);
		waitClickableElement("//input[contains(@id,'l6-real')]");
		Thread.sleep(5000);
		assertTrue(edWork.champNom.isDisplayed());
		assertTrue(edWork.champID.isDisplayed());
		assertTrue(edWork.champPrenom.isDisplayed());
		assertTrue(edWork.selectType.isDisplayed());

		// PT5 - test bouton enregistrer
		edWork.ajoutNom(prenom, nom, iD, type);
		edWork.selecNewUser();
		edWork.ajoutNewUser(username, pwd, pwd2, email);
		edWork.clicSave();
		admWork = new AdminWorkersList(driver);
		waitVisibleElement("//div[contains(@id,'h4-cave')]");
		//assertTrue(admWork.tableauParticipants.getText().contains("jdu"));

		// PT6 - test du filtre
		admWork.filtre(rechercheFiltre);
		
		//PT7 - conformit� des options
		admWork.clickOption();
		assertTrue(admWork.champActivePeriodDeb.isDisplayed());
		assertTrue(admWork.champActivePeriodFin.isDisplayed());
		
		//PT8 - navigation dans la page des participants 1/4
		admWork.clearFiltre(); //r�initialisation du filtre 
		waitClickableElement("//table[contains(@id,'q5-next')]/tbody/tr/td[2]/em/button");
		
		admWork.clickPSuivant();
		waitClickableElement("//table[contains(@id,'q5-prev')]/tbody/tr/td[2]/em/button");
		assertTrue(admWork.champPageFin.getAttribute("value").contains("2"));
		
		//PT9  - navigation dans la page des participants 2/4
		admWork.clickPPrecedente();
		waitClickableElement("//table[contains(@id,'q5-last')]/tbody/tr/td[2]/em/button");
		assertTrue(admWork.champPageDeb.getAttribute("value").contains("1"));
		
		//PT10  - navigation dans la page des participants 3/4
		admWork.clickPFin();
		waitClickableElement("//table[contains(@id,'q5-first')]/tbody/tr/td[2]/em/button");
		
		//PT11 - navigation dans la page des participants 4/4
		admWork.clickPDebut();
		waitVisibleElement("//div[contains(@id,'h4-cave')]");
		
		//PT12 - connexion � l'application avec le nouvel utilisateur cr��
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		logPage = new LoginPage(driver);
		logPage.connexion(username, pwd);
		libPage = new LibreplanPage(driver);
		assertTrue(libPage.dashboard.isDisplayed());
	
	
		
		
	}

}
