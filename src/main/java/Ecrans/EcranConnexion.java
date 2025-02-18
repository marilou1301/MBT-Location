package Ecrans;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Outils.AppliManager;

public class EcranConnexion extends AppliManager { 

	private By btnMdpOublie = By.xpath("//*[contains(@text, 'Oubli')]");
	private By champEmail = By.xpath("//*[contains(@resource-id, 'login_edit_user_name')]");
	private By champMdp = By.xpath("//*[contains(@resource-id, 'login_edit_password')]");
	private By btnConnexion = By.xpath("//*[contains(@text, 'SE CONNECTER')]");
	private By btnContinuer = By.xpath("//*[contains(@text, 'CONTINUER')]");
	private By textEchecCo = By.xpath("//*[contains(@text, 'chec de connexion')]");
	
	private int p_wait = 30;
	
	public void remplirChampMail(String Email){
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(champEmail));
		wait.until(ExpectedConditions.elementToBeClickable(champEmail));
		driver.findElement(champEmail).clear();
		//driver.hideKeyboard();
		driver.findElement(champEmail).sendKeys(Email);
	}

	public void remplirChampMdp(String mdp) {
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(champMdp));
		wait.until(ExpectedConditions.elementToBeClickable(champMdp));
		driver.findElement(champMdp).clear();
		//driver.hideKeyboard();
		driver.findElement(champMdp).sendKeys(mdp);
	}

	public void clickBtnConnexion() {
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnConnexion));
		wait.until(ExpectedConditions.elementToBeClickable(btnConnexion));
		driver.findElement(btnConnexion).click();
	}

	public void clickBtnMdpOublie() {
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnMdpOublie));
		wait.until(ExpectedConditions.elementToBeClickable(btnMdpOublie));
		driver.findElement(btnMdpOublie).click();
	}

	public boolean verifEcranConnexion() {
		Boolean ecranCnxAffichee = driver.findElement(By.xpath("//*[contains(@text(),'Connexion'),@clickable='false']")).isDisplayed();
		return ecranCnxAffichee;
	}
	
	public boolean  verifAffichageMsgErreur() {
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(textEchecCo));
		Boolean eAffiche= driver.findElement(textEchecCo).isDisplayed();
		return eAffiche ;
	}

	public void clickBtnContinuer() {
		driver.hideKeyboard();
		wait = new WebDriverWait(driver, p_wait).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinuer));
		wait.until(ExpectedConditions.elementToBeClickable(btnContinuer));
		driver.findElement(btnContinuer).click();
	}

}
