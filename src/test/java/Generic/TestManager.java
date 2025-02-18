package Generic;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Ecrans.EcranSpinner;
import Outils.AppliManager;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestManager extends AppliManager {

	//Variable
	protected static ThreadLocal<String> testName = new ThreadLocal<>();
	protected static ExtentHtmlReporter htmlreporter;
	protected static ExtentReports extent;
	protected static DesiredCapabilities capabilities;
	protected static ExtentTest test;
	
	@BeforeSuite
	public void setup() {
		
		/**
		 * ExtendReporter Setup
		 */
		htmlreporter = new ExtentHtmlReporter("test-output/ExtendReporter/extent.html");
		
		// Création d'un Object ExtendReports et lien avec un reporter(s) 
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		// Initialisation du fichier de reporting (récupération du nom + description)
		test = extent.createTest("Test "+ testName.get(),"Description?");
		
		/**
		 * ApkDriver Setup
		 */
		
		System.out.println("===============================================");
		System.out.println("------------------Test start!------------------");
		System.out.println("===============================================");
		System.out.println("Ouverture de l'APK.");

		// Mise en place des paramètres nécessaire au lancement de l'app sous Appium.
		capabilities = new DesiredCapabilities();
				
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		// TO DO : Changer le UDID en fonction de votre appareil.
		//capabilities.setCapability("udid", "J1AXB7604877647");
		// TO DO : Changer le numéro de version android en fonction de votre appareil.
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "\\src\\test\\resources\\apk\\RentACar.apk");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
		capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, "true");
		capabilities.setCapability("connectHardwareKeyboard", false);
		capabilities.setCapability("resetKeyboard", true);
		
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		
		EcranSpinner eSpinner = new EcranSpinner();
		boolean bLancementAppliOK;
		
		testName.set(method.getName());
		
		
		
		//pour avoir un comportement unitaire et repetable, on doit charger et decharger l'apk avant et apr�s chque test
		try {

			// Ouverture de l'APK
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			test.log(Status.PASS, "Apk open on the device !");
			eSpinner.attendreChargement();
		}

		catch (Exception exp) {
					
		}
		
		test.log(Status.INFO, testName.get()+" Started !");
	}

	@AfterMethod
	public void afterMethod() {
		
		//driver.quit();
		System.out.println("Le test " + testName.get() + " est termin�.");
		test.log(Status.INFO, "Test "+ testName.get() + " completed !");
	}

	@AfterSuite
	public void teardown() {
		
		/**
		 * ExtentReport Setup
		 */
		extent.flush();
		
		/**
		 * ApkDriver Setup
		 */
		// re-activer clavier 
		capabilities.setCapability("connectHardwareKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		//driver.quit();
		System.out.println("===============================================");
		System.out.println("-----------------Test finish !-----------------");
		System.out.println("===============================================");

	}

}
