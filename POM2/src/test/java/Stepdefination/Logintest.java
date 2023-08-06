package Stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Webpage.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest {
	
		public static void main(String[] args) throws Throwable {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://playbig-in-qa.sportsit-tech.net/");
			Loginpage  obj  = new Loginpage (driver);
		    obj.login();
		    obj.username();
		    obj.Pass();
		    obj.Loginmethod();
		    obj.Isdisplay(driver);
		    obj.placeorder();

	}

}
