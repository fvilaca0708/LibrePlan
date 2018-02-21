package criteres;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.ElementNonTrouveException;
import libreplan.LibreplanPage;
import libreplan.LoginPage;

public class CriteresTest {
	private WebDriver driver;
	
	private LoginPage logPage;
	private LibreplanPage libPage;
	private AdministrationDesCriteres adminCrit;
	private EditionDeCriteres editCrit;
	private PopUpCritere popup;
	
	// M�thodes d'explicit wait
	public void waitVisibleElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitClickableElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	
	@Before
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		
		//CT1 - Connexion
		logPage=new LoginPage(driver);
		logPage.connexion("admin", "admin");
		
		
	}
	

	
	@Test
	public void cri01 () throws Exception{
		
		
		//D�claration des variables
		String testBtnAnnuler = "Crit�re - Test bouton [annuler]";
		String testBtnSave = "Crit�re - Test bouton [Enregistrer]";
		String testBtnSaveContinue = "Crit�re - Test bouton [Sauver et Continuer]";
		String testBtnModif1 = "Crit�re - Test bouton [Sauver et Continuer]";
		String testBtnModif2 = "Crit�re - Test bouton [Sauver et Continuer]2";
		
		
		//PT2 - acc�s � la page d'administration des crit�res
		libPage=new LibreplanPage(driver);
		waitClickableElement("//button[contains(@id,'r-b')]");
		libPage.goToPage(libPage.getMenuResources(), libPage.getBtnCriteria());
		
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'k4-head')]");
		//assertPT2		
		adminCrit.verificationAffichage();
		
		//PT3 - Acc�s au formulaire d'�dition des crit�res
		adminCrit.clicCreate();
		editCrit=new EditionDeCriteres(driver);
		waitClickableElement("//table[contains(@id,'h6-box')]");
		
		assertTrue(editCrit.btnSave.isDisplayed());
		assertTrue(editCrit.btnSaveContinue.isDisplayed());
		assertTrue(editCrit.btnAnnuler.isDisplayed());
		
		//PT4 - Test fonction "annuler"		
		editCrit.ajoutNomDesc(testBtnAnnuler, testBtnAnnuler);
		assertTrue(editCrit.btnCheckbox()); //Verifier que les 3 checkboxes sont coch�es		
		editCrit.clicAnnuler();
		
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'j4-cave')]");
		adminCrit.verificationAffichage();
		Assert.assertNotSame("Crit�re - Test bouton [annuler]", adminCrit.tableauAdmin.getText());

		//PT5- Test fonction "enregistrer"			
		adminCrit.clicCreate();
		
		editCrit=new EditionDeCriteres(driver);
		waitClickableElement("//table[contains(@id,'h6-box')]");
		editCrit.ajoutNomDesc(testBtnSave, testBtnSave);
		assertTrue(editCrit.btnCheckbox()); //Verifier que les 3 checkboxes sont coch�es
		editCrit.clicSave();
		
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'j4-cave')]");
		adminCrit.verificationAffichage();
		assertTrue(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Enregistrer]"));
		
		//PT6 - Acc�s au formulaire d'�dition des crit�res		
		adminCrit.clicCreate();
		
		editCrit=new EditionDeCriteres(driver);
		waitClickableElement("//table[contains(@id,'h6-box')]");
		assertTrue(editCrit.btnSave.isDisplayed());
		assertTrue(editCrit.btnSaveContinue.isDisplayed());
		assertTrue(editCrit.btnAnnuler.isDisplayed());
		assertTrue(editCrit.btnCheckbox()); //Verifier que les 3 checkboxes sont coch�es
		
		//PT7 - Test fonction "enregistrer et continuer"		
		
		editCrit.ajoutNomDesc(testBtnSaveContinue, testBtnSaveContinue);
		editCrit.clicSaveContinue();
		
		
		//PT8 - REtour page admin
		editCrit.clicAnnuler();
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'j4-cave')]");
		adminCrit.verificationAffichage();
		assertTrue(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Sauver et Continuer]"));
		
		
		//PT9 - Modifier un critere
		
		adminCrit.clickToModify(adminCrit.trouverCritere(testBtnModif1));
		editCrit=new EditionDeCriteres(driver);
		waitClickableElement("//table[contains(@id,'h6-box')]");
		
		
		
		//PT10 - Modifier un critere bouton "annuler"		
		editCrit.modifierNom(testBtnModif2);
		editCrit.clicAnnuler();
		
		
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'j4-cave')]");
		adminCrit.verificationAffichage();
		assertFalse(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Sauver et Continuer]2"));
		assertTrue(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Sauver et Continuer]"));
		
		//PT11 Modifier un critere - cliquer sur le nom
		adminCrit.clickToModify(adminCrit.trouverCritere(testBtnModif1));
		
		editCrit=new EditionDeCriteres(driver);
		waitClickableElement("//table[contains(@id,'h6-box')]");
		
		
		//PT12 - Modifier un critere modifier un nom

		editCrit.modifierNom(testBtnModif2);
		
		//PT13 Modifier un critere enregistrement
		editCrit.clicSaveContinue();
		
		//PT14 Modifier un critere retour page admin
		editCrit.clicAnnuler();
		adminCrit = new AdministrationDesCriteres(driver);
		waitVisibleElement("//div[contains(@id,'j4-cave')]");
		adminCrit.verificationAffichage();
		assertTrue(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Sauver et Continuer]2"));
		
		//PT15 Supprimer un critere, pop up de confirmation
		
		adminCrit.clickToDelete(adminCrit.trouverCritere(testBtnModif2));
		
		//PT16 Supprimer un critere annulation
		popup = new PopUpCritere(driver);
		waitVisibleElement("//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table");
		popup.clickAnnulerDelete();
		
		//PT17 Supprimer un critere pop up de confirmation
		
		adminCrit = new AdministrationDesCriteres(driver);
		adminCrit.verificationAffichage();
		adminCrit.clickToDelete(adminCrit.trouverCritere(testBtnModif2));
		
		
		//PT18 supprimer un critere, confirmation
		popup = new PopUpCritere(driver);
		waitVisibleElement("//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table");
		popup.clickOkDelete();
		
		adminCrit = new AdministrationDesCriteres(driver);
		Thread.sleep(5000);
		assertFalse(adminCrit.tableauAdmin.getText().contains("Crit�re - Test bouton [Sauver et Continuer]2"));
		
		}
		
		@After
		public void tearDown () throws Exception {
			
			//Supprime le crit�re cr��, afin de retrouver la BDD dans le meme �tat qu'avant le test
			String testBtnSave = "Crit�re - Test bouton [Enregistrer]";
			
			adminCrit = new AdministrationDesCriteres(driver);						
			adminCrit.clickToDelete(adminCrit.trouverCritere(testBtnSave));
			popup = new PopUpCritere(driver);
			waitVisibleElement("//body/div[3]/div[3]/div/div/div/table[2]/tbody/tr/td/table");
			popup.clickOkDelete();
			driver.quit();
		}
	
}
