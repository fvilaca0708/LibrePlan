package fr.eql.autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectSchedulingPage extends ProjectPage {
	public ProjectSchedulingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//frame[@id='zk_hfr_']")
	public WebElement mainFrame;
	

	@FindBy(how=How.XPATH, using="//frame[@id='simile-ajax-history']")
	public WebElement rightClickFrame;
	
	
	public ProjectSchedulingMenu rightClickProjectslist(){
		WebElement blueBox = driver.findElement(By.xpath("//div[@id='listtasks']/div[@id='"+prefixe()+"t6']/div[@id='"+prefixe()+"s9']"));
		//div[1]/div/div[5]/div[2]/div/div/div/div[2]/div/div/span/div/div[1]/div/span/div[1]/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/div/div[1]/div[1]
		Actions action = new Actions(driver).contextClick(blueBox);
		action.build().perform();
		return PageFactory.initElements(driver, ProjectSchedulingMenu.class);
	}
	
	public void menuDeroulantVue(String periode) {
		WebElement menu = driver.findElement(By.xpath("//select[@id='"+prefixe()+"s8']"));
				Select select = new Select(menu);
				select.selectByVisibleText(periode);

		
	}
	public void clickProjectslist(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"h4-box']/tbody/tr[2]/td[2]"))).click();
		//return PageFactory.initElements(driver, ProjectsListPage.class);
}

	public void supprimerProjet() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"q7-box']/tbody/tr[2]/td[2]"))).click();
		
	}
	
	public void supprOk() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"06-box']/tbody/tr[2]/td[2]"))).click();
	}
	
	public void listeProjet() {
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='"+prefixe()+"7-b']"))).click();
		*/
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//button[@id='"+prefixe()+"7-b']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id='"+prefixe()+"a-a']"))).click().build().perform();
	}
	
	public void clickCancel () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='"+prefixe()+"a0-box']/tbody/tr[2]/td[2]/img"))).click();
	}
	
	public void cancelOk () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='"+prefixe()+"3h-box']/tbody/tr[2]/td[2]"))).click();
	}
	
	public String prefixe(){
		WebElement bouton = driver.findElement(By.xpath("//body/div"));
		String idBouton = bouton.getAttribute("id");
		String prefix = idBouton.substring(0, 4);
		return prefix;
	}
	

	
	
	

			
		

	
}
