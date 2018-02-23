package fr.eql.autom.LibrePlan;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;


//Cas de test Créer un projet
public class ProTaAll {

	WebDriver driver;
	String navigateur = "firefox";
	String driverSQL = "org.postgresql.Driver";
	String jdbcURL = "jdbc:postgresql://localhost/libreplan";
	String user = "libreplan";
	String password = "libreplan";

	
//Initialisation du navigateur sur l'addresse appropriée
	@Before
	public void setup(){

		System.setProperty("navigateur", navigateur);
		String nav = System.getProperty("navigateur");
	
		//cas où les test est fait sur chrome
	if (nav.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Formation\\Desktop\\PROJET 3\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	//cas où les test est fait sur firefox
	if (nav.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\FORMATION\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		options.addPreference("browser.tabs.remote.autostart", false);
		driver = new FirefoxDriver(options);
		
	}
	//cas où les test est fait sur ie
	if (nav.equals("ie")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Formation\\Desktop\\PROJET 3\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
	}
	
		
	driver.get("http://192.168.2.41:8080/libreplan/common/layout/login.zul");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	LogPage pageConnexion = PageFactory.initElements(driver, LogPage.class);
//	pageConnexion.connexion("admin", "admin");
	}

		
	
//Corps du test de création de projet
	@Test
	public void testProTa01() throws InterruptedException {
		//1- Création de la page de connexion
		LogPage log = PageFactory.initElements(driver, LogPage.class);
		//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
		ProjectsPlanningPage plan = log.connexion("admin", "admin");
		Thread.sleep(500);
		//2- Click sur le bouton d'ajout de projet et redirection sur le popup de l'ajout de projet.
		PopupProjectAdd projectAdd = plan.clickProjectAdd();
		//3- Complétion du formulaire d'ajout de projet, validation et redirection sur la page des détails du projet.
		ProjectDetailsPage project = projectAdd.setProject("PROJET_TEST1", "PRJTST001", "May 8, 2017", "May 18, 2018");
		
		//7- Click sur l'icône d'annulation d'édition ( flèche verte en haut à gauche).
		project.clickCancel();
		//8- Annulation de l'annulation d'édition
		project.clickCancelNo();
		//9- Click sur l'icône d'annulation d'édition ( flèche verte en haut à gauche).
		project.clickCancel();
		//10- Validation de l'annulation d'édition
		ProjectsPlanningPage projects2 = project.clickCancelYes();
		
		
	}
	
	//Corps du test de création de projet
		@Test
		public void testProTa02() throws InterruptedException {
			
			//1- Création de la page de connexion
			LogPage log = PageFactory.initElements(driver, LogPage.class);
			//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
			ProjectsPlanningPage plan = log.connexion("admin", "admin");
			
			//2- Redirection vers la liste des planning via un click sur l'onglet correspondant.
			ProjectsListPage list = plan.clickProjectslist();
			Thread.sleep(1000);
			
			//3- Accès à la page édition du projet
			ProjectDetailsPage project = list.selectionProject("PROJET_TEST1");
			
			//5- Création d'une nouvelle tâche
			project.addTask("task1", "5");
			Thread.sleep(1000);
			
			//6- Création de plusieurs nouvelles tâches
			project.addTask("task2", "5");
			Thread.sleep(1000);
			project.addTask("task3", "5");
			Thread.sleep(1000);
			project.addTask("task4", "5");
			Thread.sleep(1000);
			
			//7- Modification de l'ordre de la première tâche vers le bas
			project.orderTaskDown("task1");
			Thread.sleep(1000);
			
			//8- Modification de l'ordre de la troisième tâche vers le haut
			project.orderTaskUp("task3");
			
			//9- Remplissage des champs des tâches
			project.setCodeTask1("T1");
			project.setCodeTask2("T2");
			project.setCodeTask3("T3");
			project.setCodeTask4("T4");
			project.setDateTask1("5/2/18");
			Thread.sleep(1000);
			project.setDateTask2("5/6/18");
			Thread.sleep(1000);
			project.setDeadline1("5/1/18");
			Thread.sleep(1000);
			project.setDeadline2("5/3/18");
			project.clickSave();
			project.clickOkPopup();
			Thread.sleep(1000);
			
			//10- Redirection vers la page de visualisation du planning
			project.clickProjectScheduling();
			
		}

		@Test
		public void testProTa03() throws InterruptedException {
			
			//1- Création de la page de connexion
			LogPage log = PageFactory.initElements(driver, LogPage.class);
			//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
			ProjectsPlanningPage plan = log.connexion("admin", "admin");
			
			//2- Redirection vers la liste des planning via un click sur l'onglet correspondant.
			ProjectsListPage list = plan.clickProjectslist();
			Thread.sleep(1000);
			
			//3- Accès à la page édition du projet
			ProjectDetailsPage project = list.selectionProject("PROJET_TEST1");
			
			//4- Redirection vers la page de visualisation du planning
			ProjectSchedulingPage schedule = project.clickProjectScheduling();
			
			//5- Click droit sur le rectangle bleue symbolisant la durée d'une tâche
			ProjectSchedulingMenu scheduleMenu = schedule.rightClickProjectslist();
			
			//6 Choix du sous-menu d'allocation de ressources
			PopupTaskPage task = scheduleMenu.clickResourcesAllocation();
			Thread.sleep(500);
			
			//7- Affichage de la liste des ressources
			task.selectAllAllocations();
			
//			//8- Sélection des ressources
//			task.selectAllocation();
			Thread.sleep(500);
//			
//			//9- Ajout de la ressource
//			task.addAllocation();
			
			//10- Validation de l'ajout de la ressource
			ProjectSchedulingPage schedule2 = task.validateAllocation();
			Thread.sleep(500);
			
			//11- Click sur l'onglet de chargement des ressources
			ResourcesLoadPage resources = schedule2.clickResourcesLoad();
			
			//12- Click sur l'icône à gauche de la ressource afin de dérouler sa tâche d'affectation
			resources.selectResource();
			
			//13- Click à nouveau sur l'icône à gauche de la ressource afin de cacher sa tâche d'affectation
			resources.selectResource();
			
			//14- Click sur la disquette
			resources.clickSave();
		}
		
		@Test
		public void testProTa04() throws InterruptedException {
			
			//1- Création de la page de connexion
			LogPage log = PageFactory.initElements(driver, LogPage.class);
			//1- Redirection vers la page d'accueuil grâce à la méthode de connexion issue de la page-objet correspondante avec les identifiants admin.
			ProjectsPlanningPage plan = log.connexion("admin", "admin");
			
			//2- Redirection vers la liste des planning via un click sur l'onglet correspondant.
			ProjectsListPage list = plan.clickProjectslist();
			Thread.sleep(1000);
			
			//3- Accès à la page édition du projet
			ProjectDetailsPage project = list.selectionProject("PROJET_TEST1");
			
			//4- Redirection vers la page de visualisation du planning
			ProjectSchedulingPage schedule = project.clickProjectScheduling();
			
			//5- Changement de vue vers la vue Année
			schedule.menuDeroulantVue("Year");
			
			//6- Changement de vue vers la vue Trimestre
			schedule.menuDeroulantVue("Quarter");
			
			//7- Changement de vue vers la vue Mois
			schedule.menuDeroulantVue("Month");
			Thread.sleep(1000);
			
			//suppression du projet
			schedule.listeProjet();
			Thread.sleep(1000);

			
			schedule.supprimerProjet();
			Thread.sleep(1000);
			schedule.supprOk();
		
		}
	

	
	/*
	//Réinitialisation de la base de données
	@After
	public void teardown() throws SQLException, Exception{
		IDatabaseTester tester = new JdbcDatabaseTester(driverSQL,jdbcURL, user, password);
		IDataSet dataSet = tester.getConnection().createDataSet();
		
		//Vérification de l'insertion

		ITable table = dataSet.getTable("order_element");
		
		IDataSet expected2 = new FlatXmlDataSetBuilder().build(new File("src/test/dataProjet.xml"));
		ITable expectedTable2 = expected2.getTable("order_element");
		Assertion.assertEquals(expectedTable2, table);
		
		//Suppresion des données insérées
	
		IDataSet dataSet2 =new FlatXmlDataSetBuilder().build(new File("src/test/dataDelete.xml"));
		tester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
		tester.setDataSet(dataSet2);
		tester.onTearDown();
		
		//Vérification de la suppresion
		ITable table = dataSet.getTable("order_element");
		IDataSet expected = new FlatXmlDataSetBuilder().build(new File("src/test/dataEmpty.xml"));
		ITable expectedTable = expected.getTable("order_element");
		
		Assertion.assertEquals(expectedTable, table);
	}
	*/
	@After 
	public void teadown() {
		driver.quit();
	}
}
