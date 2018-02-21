package avancement;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import criteres.PopUpCritere;
import libreplan.LibreplanPage;
import libreplan.LoginPage;

public class AvancementTest {

	private WebDriver driver;
	private LoginPage logPage;
	private LibreplanPage libPage;
	private ListeAvancement ltAvct;
	private EditAvancement editAvct;
	
	@Before
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/libreplan/common/layout/login.zul");
		//CT1
		logPage=new LoginPage(driver);
		logPage.connexion("admin", "admin");
	}
	
	public void waitVisibleElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitClickableElement(String xpath){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	@Test
	public void ava01 () throws Exception{
		
		String nomUniteTest1 = "Type avancement - Test 1";
		String nomUniteTest2 = "Type avancement - Test 2";
		String valMaxTest1 = "10";
		
		//PT2 - Accès à la liste des avancements
		libPage=new LibreplanPage(driver);
		waitClickableElement("//button[contains(@id,'r-b')]");
		libPage.goToPage(libPage.getMenuResources(), libPage.getBtnProgressType());
		
		ltAvct = new ListeAvancement (driver);
		waitVisibleElement("//div[contains(@id,'h4-cave')]");
		ltAvct.verificationAffichage();
		
		//PT3 - Accès au formulaire de création d'un avancement
		ltAvct.clicCreate();
		
		editAvct= new EditAvancement (driver);
		waitVisibleElement("//div[contains(@id,'s4-cave')]");
		assertTrue(editAvct.checkboxActive.isSelected());
		assertFalse(editAvct.checkboxPercentage.isSelected());
		assertTrue(editAvct.btnSave.isDisplayed());
		assertTrue(editAvct.btnSaveContinue.isDisplayed());
		assertTrue(editAvct.btnAnnuler.isDisplayed());
				
		
		//PT4 - Création d'un avancement sans pourcentage
		
		editAvct.ajoutNomUniteMaxValue(nomUniteTest1, valMaxTest1);
		editAvct.deselecActive();
		editAvct.deselecPercentage();		
		editAvct.clicSave();
		
		ltAvct = new ListeAvancement (driver);
		waitVisibleElement("//div[contains(@id,'h4-cave')]");
		Thread.sleep(5000);
		assertTrue(ltAvct.tableauAdminAvcmt.getText().contains("Type avancement - Test 1"));
		
		
		//PT5 - accès au formualire de création
			
		ltAvct.clicCreate();
		
		editAvct= new EditAvancement (driver);
		waitVisibleElement("//div[contains(@id,'s4-cave')]");
		assertTrue(editAvct.checkboxActive.isSelected());
		assertFalse(editAvct.checkboxPercentage.isSelected());
		assertTrue(editAvct.btnSave.isDisplayed());
		assertTrue(editAvct.btnSaveContinue.isDisplayed());
		assertTrue(editAvct.btnAnnuler.isDisplayed());
		
		//PT6 Création d'un avancement avec pourcentage 1/2
		
		editAvct.ajoutNomUnite(nomUniteTest2);
		editAvct.selecPercentage();
		waitVisibleElement("//div[contains(@id,'s4-cave')]");
		Thread.sleep(5000);
		assertFalse(editAvct.maxValue.isEnabled());
		
		//PT7 Création d'un avancement avec pourcentage 2/2
		editAvct.clicSaveContinue();
		
		//PT8 - retour à la pasge de liste des avancements
		editAvct.clicAnnuler();
		
		//PT9 - conformité des type d'avancemnts
		ltAvct = new ListeAvancement (driver);	
		Thread.sleep(5000);
		assertTrue(ltAvct.tableauAdminAvcmt.getText().contains("Type avancement - Test 2"));
		
		
	}
	

}
