package selenium.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationScript extends ReusableMethod {


	public static void Navigate_to_XERO() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		String Email, password;
		
			Email = recCreden[0][1];
			password = recCreden[1][1];
		

			/* enter Email*/
		WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(userName, Email , "Email");


		/* enter password*/
		WebElement passWord = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(passWord, password ,"password");

				Thread.sleep(3000);
		/* click login*/
//		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
//		clickObj(login, "Login");

		bw.close();
	}

	
	public static void Incorrect_Password() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		String Email, password;
		
		Email = recCreden[0][1];
			password = recCreden[3][1];
		

			/* enter Email*/
		WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(userName, Email , "Email");


		/* enter password*/
		WebElement passWord = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(passWord, password ,"password");

				Thread.sleep(3000);
		
				/* click login*/
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(login, "Login");
		
		Thread.sleep(3000);
		
		/*Error message*/
		WebElement errormsg = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p"));
		verifyText(errormsg,"Your email or password is incorrect ");
		
		Thread.sleep(3000);
		bw.close();
	}

	public static void Incorrect_Email() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		String Email, password;
		
		Email = recCreden[2][1];
			password = recCreden[1][1];
		

			/* enter Email*/
		WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));
		enterText(userName, Email , "Email");


		/* enter password*/
		WebElement passWord = driver.findElement(By.xpath(".//*[@id='password']"));
		enterText(passWord, password ,"password");

				Thread.sleep(3000);
		
				/* click login*/
		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		clickObj(login, "Login");
		
		Thread.sleep(3000);
		
		/*Error message*/
		WebElement errormsg = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p"));
		verifyText(errormsg,"Your email or password is incorrect ");
		
		Thread.sleep(3000);
		bw.close();
	}

	public static void Sign_Up_to_XDC() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		
		String fname = recCreden[6][1];
		String lname = recCreden[7][1];
		String Email = recCreden[8][1];
		String Phone = recCreden[9][1];
		
		/*click try for free*/
		WebElement tryFree = driver.findElement(By.xpath("html/body/main/div[1]/div/div/div/div/div/div/a[1]"));
		clickObj(tryFree,"try xero for free");
		
		/*enter firstname*/
		WebElement first = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
		enterText(first, fname,"firstName");

		/*enter lastname*/
		WebElement last = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
		enterText(last, lname,"firstName");
		
		/*enter email*/
		WebElement email = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		enterText(email, Email,"email");

		/*enter phone number*/
		WebElement pNum = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input"));
		enterText(pNum, Phone,"phoneNumber");

		/* select country */
		Select dropdown = new Select(driver.findElement(By.name("LocationCode")));
		dropdown.selectByVisibleText("United States");
	
		/*click checkbox*/
		WebElement checkbox = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input"));
		clickObj(checkbox,"click check box");
		Thread.sleep(3000);
		
//		/*click get started*/
//		WebElement start = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
//		clickObj(start,"click get started");
		

		Thread.sleep(3000);
		bw.close();
	}
	public static void Sign_Up_to_XDC_error() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		
		String Email = recCreden[10][1];
				
		/*click try for free*/
		WebElement tryFree = driver.findElement(By.xpath("html/body/main/div[1]/div/div/div/div/div/div/a[1]"));
		clickObj(tryFree,"try xero for free");
		
		
		/*enter email*/
		WebElement email = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		enterText(email, Email,"email");

		
		/*click get started*/
		WebElement start = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button"));
		clickObj(start,"click get started");
		
		/*Error message for firstname*/
		WebElement errormsg1 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-1']"));
		verifyText(errormsg1,"First name can't be empty");
		
		/*Error message for lastname*/
		WebElement errormsg2 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-2']"));
		verifyText(errormsg2," Last  name can't be empty");
	
		/*Error message for phonenumber*/
		WebElement errormsg3 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-4']"));
		verifyText(errormsg3,"Phone number can't be empty");
		
		/*Error message for email*/
		WebElement errormsg4 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']"));
		verifyText(errormsg4," Email address is invalid ");
		
		
		
		Thread.sleep(5000);
		bw.close();
	}

	public static void forgot_Password() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");

		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		String Email = recCreden[0][1];

		/* click forgot password*/
		WebElement fPwd = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a"));
		clickObj(fPwd, "forgot password");
		
		/*enter username*/
		WebElement email = driver.findElement(By.xpath(".//*[@id='UserName']"));
		enterText(email, Email, "email");
		
		/* click sendlink*/
		WebElement sendlink = driver.findElement(By.xpath(".//*[@id='submitButton']/a/span"));
		clickObj(sendlink, "sendlink");
		
		Thread.sleep(3000);

		bw.close();
	}

	public static void Sign_Up_to_XDC_TermsOfUse() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		
				
		/*click try for free*/
		WebElement tryFree = driver.findElement(By.xpath("html/body/main/div[1]/div/div/div/div/div/div/a[1]"));
		clickObj(tryFree,"try xero for free");
		
		Thread.sleep(3000);
		/*click terms of use*/
		//WebElement Terms = driver.findElement(By.xpath("//a[@href='https://www.xero.com/us/about/terms/']"));
		//clickObj(Terms,"terms of use is clicked");
	
		driver.findElement(By.linkText("terms of use")).click();
		
		
		
		/*switch window*/
		
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		
		String URL = driver.getCurrentUrl();
		verifyText(URL, "https://www.xero.com/us/about/terms/");
		
		//then close tab and get back
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

	
		Thread.sleep(5000);
		bw.close();
	}

	
	
	
	
	
	
	
		

}	
