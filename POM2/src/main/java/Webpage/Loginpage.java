package Webpage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//*[@id=\"splide02-slide01\"]/div/div[3]/div/ul/li[1]/button/div[2]")
	private WebElement odd;

	@FindBy(xpath = "(//i[@class='sb-icon icon-angle-arrow-right'])[2]")
	private WebElement sidearrow;
	
	
//	@FindBy(xpath = "//div[@class='SB-stakeInput']")
//	private WebElement stake;


	@FindBy(xpath = "//div[text()='Place Bet']")
	private WebElement placebet;

	public void login() {
		Loginbtn.click();
	}

	public void username() {
		MobileNo.sendKeys("9096593566");
	}

	public void Pass() {
		Password.sendKeys("1234");
	}

	public void Loginmethod() {
		Enter.click();

	}

	public void Isdisplay(WebDriver driver) throws IOException, Throwable {
       Thread.sleep(4000);
		if (balance.isDisplayed()) {

			TakesScreenshot ss = (TakesScreenshot)driver;
			File f = ss.getScreenshotAs(OutputType.FILE);
	
			try {
				FileUtils.copyFile(f, new File("D:\\eclipse prog\\POM2\\Screenshot\\xyz.jpg"));
			} catch (Exception e) {
				System.out.println("Login successful");
			}			
		}
		
		else {
			System.out.println("Login is not done yet");

		}
	}

	public void placeorder() throws InterruptedException {
		odd.click();
	sidearrow.click();
//	stake.clear();
//	stake.sendKeys("100");
	Thread.sleep(5000);
	placebet.click();

	}

}


