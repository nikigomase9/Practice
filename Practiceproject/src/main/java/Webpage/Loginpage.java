package Webpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Testbase.Base;
import xlutils.Utils;

public class Loginpage {

	 WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath = "//button[@class='btn SB-login SB-btnSmall' and text()='Login']")
	private WebElement Loginbtn;

	@FindBy(id = "userMobileNo")
	private WebElement MobileNo;

	@FindBy(id = "userPassword")
	private WebElement Password;

	@FindBy(id = "btnlogin")
	private WebElement Enter;

	@FindBy(xpath = "//button[text()='Deposit']")
	private WebElement balance;

	@FindBy(xpath = "//li[@id='splide02-slide02']//div[3]//div[text()='2']")
	private WebElement odd;

	@FindBy(xpath = "(//i[@class='sb-icon icon-angle-arrow-right'])[2]")
	private WebElement sidearrow;
	
	@FindBy(id= "userPasswordErrorMessage")
	private WebElement errormsg;
	
	@FindBy(className= "SB-mainHeader-userName")
	private WebElement profile;
	
	@FindBy(xpath= "//button[text()='Logout']")
	private WebElement logout;
	
	public void clickonlogin() {
		Loginbtn.click();
	}

//	public void username() {
//		MobileNo.sendKeys("9096593566");
//	}
//
//	public void Pass() {
//		Password.sendKeys("1234");
//	}
    
	 String File = "D:\\eclipse prog\\Practiceproject\\testmaterial\\Datadrivenxl.xlsx";
	 String Sheet = "credenatials";
	 
	
	public void checkloginwithvaliddata() throws IOException {
		
		 double username = Utils.getNumdata(File, Sheet, 1, 0);
		 double password  = Utils.getNumdata(File, Sheet, 1, 1);
		 MobileNo.sendKeys(String.valueOf(username));
		 Password.sendKeys(String.valueOf(password));
		 Enter.click();
		 Utils.setCellData(File, Sheet, 1, 2, "Pass");
		 //Utils.fillGreenColor(Sheet, Sheet, 1, 2);
		 
		 }
	
	public void checkloginwithinvaliddata() throws IOException {
		
		
		double username = Utils.getNumdata(File, Sheet, 2, 0);
		 double password  = Utils.getNumdata(File, Sheet, 2, 1);
		 MobileNo.sendKeys(String.valueOf(username));
		 Password.sendKeys(String.valueOf(password));
		 Enter.click();
		  Assert.assertEquals("User Not Registered", errormsg.getText());
		  Utils.setCellData(File, Sheet, 2, 2 , "Fail");
		   //Utils.fillRedColor(File, Sheet, 2, 2);
		 
	}

	public void clickonlogout() {
		profile.click();
		logout.click();
	}
}


