package Loginpagetest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Testbase.Base;
import Webpage.Loginpage;

public class Logincase extends Base{
	Loginpage a;
	
	@BeforeTest
	public void openbrowser () {
		intialization();
	 a = new Loginpage(driver);
	}
	
	@Test (priority= 1)
	public void login() throws IOException, InterruptedException {
	a.clickonlogin();
	a.checkloginwithvaliddata();
	a.clickonlogout();
	}
	
	@Test(priority=2)
	public void loginwithinvalidcred() throws IOException, InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='btn SB-login SB-btnSmall' and text()='Login'")));
	a.clickonlogin();
	a.checkloginwithinvaliddata();
		
	}
	
	@AfterTest
	public void close() {
	driver.quit();	
	}
	
	

}
