package selenium.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
			Thread.sleep(3000);
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
		
		
		
		Thread.sleep(2000);
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
		
		Thread.sleep(2000);

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
		
		By css = By.cssSelector("a[href='https://www.xero.com/us/about/terms/']");
		WebElement terms = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , terms);
		
		/*switch window*/
		
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		verifyText(URL, "https://www.xero.com/us/about/terms/");
		
		//then close tab and get back
		driver.close();
		driver.switchTo().window(browserTabs.get(0));

		
		Thread.sleep(3000);
		/*click privacy policy*/
		
		By css2 = By.cssSelector("a[href='https://www.xero.com/us/about/privacy/']");
		WebElement privacy = driver.findElement(css2);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , privacy);
		
		/*switch window*/
		
		//get window handlers as list
		List<String> browserTabs2 = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs2 .get(1));
		Thread.sleep(3000);
		String URL2 = driver.getCurrentUrl();
		verifyText(URL2, "https://www.xero.com/us/about/privacy/");
		
		Thread.sleep(2000);
		bw.close();
	}
	
	public static void Sign_Up_to_XDC_fullDetails() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		
				
		/*click try for free*/
		WebElement tryFree = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObj(tryFree,"try xero for free");
		
		Thread.sleep(3000);
		/*click full offer details*/
		
		By css = By.cssSelector("a[href='https://www.xero.com/us/signup/offer-details/']");
		WebElement details = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , details);
		
		/*switch window*/
		
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		verifyText(URL, "https://www.xero.com/us/signup/offer-details/");
		
		Thread.sleep(2000);
		bw.close();
	}

	public static void Sign_Up_to_XDC_accountant_Or_Bookkeeper() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		
				
		/*click try for free*/
		WebElement tryFree = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		clickObj(tryFree,"try xero for free");
		
		Thread.sleep(3000);
		
		/*click accountant or bookkeeper*/
		
		By css = By.cssSelector("a[href='https://www.xero.com/us/partner-programs/partners/signup/']");
		WebElement accOrBkeeper = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , accOrBkeeper);
		
		/*switch window*/
		
		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		
		//switch to new tab
		driver.switchTo().window(browserTabs .get(0));
		Thread.sleep(3000);
		String URL = driver.getCurrentUrl();
		verifyText(URL, "https://www.xero.com/us/partner-programs/partners/signup/");
		Thread.sleep(2000);
		
		//then close tab 
		bw.close();
	}

	public static void Test_All_Tabs_Page() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		
			String Email = recCreden[0][1];
			String password = recCreden[1][1];
			
			Thread.sleep(3000);
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
		
//		/*verify page */
//		WebElement trialPage = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[1]/p"));
//		verifyText(trialPage,"You are currently using a trial account.");
		
		Thread.sleep(3000);
		/* click dashBoard*/
		WebElement dashBoard = driver.findElement(By.xpath(".//*[@id='Dashboard']"));
		clickObj(dashBoard, "dashBoardpage");

		Thread.sleep(3000);
		/* click accounts*/
		WebElement accounts = driver.findElement(By.xpath(".//*[@id='Accounts']"));
		clickObj(accounts, "accounts");

		/* click payroll*/
		WebElement payroll = driver.findElement(By.xpath(".//*[@id='Payroll']"));
		clickObj(payroll, "payroll");

		/* click reports*/
		WebElement reports = driver.findElement(By.xpath(".//*[@id='Reports']"));
		clickObj(reports, "reports");
		
		/* click contacts*/
		WebElement contacts = driver.findElement(By.xpath(".//*[@id='Contacts']"));
		clickObj(contacts, "contacts");
		
		/* click setting*/
		WebElement setting = driver.findElement(By.xpath(".//*[@id='Settings']"));
		clickObj(setting, "settings");
		
		/* click newTab*/
		WebElement newTab = driver.findElement(By.xpath(".//*[@id='quicklaunchTab']"));
		clickObj(newTab, "newTab");

		/* click files*/
		WebElement files = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a"));
		clickObj(files, "files");

		/* click notification*/
		WebElement notification = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a"));
		clickObj(notification, "notification");

		/* click search*/
		WebElement search = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a"));
		clickObj(search, "newTab");

		/* click help*/
		WebElement help = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a"));
		clickObj(help, "help");


		
		Thread.sleep(3000);
		bw.close();
	}

	public static void LogOut() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		
			String Email = recCreden[0][1];
			String password = recCreden[1][1];
			
			Thread.sleep(3000);
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

		/* click profile*/
		WebElement profile = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
		clickObj(profile, "profile");
		Thread.sleep(3000);

		/* click logout*/
		WebElement logout = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a"));
		clickObj(logout, "logout");
		Thread.sleep(3000);

		
		
		Thread.sleep(3000);
		bw.close();
	
	}
	
	
	public static void Test_Upload_profile_image() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		
		
			String Email = recCreden[0][1];
			String password = recCreden[1][1];
			
			Thread.sleep(3000);
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

		/* click profile*/
		WebElement profile = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
		clickObj(profile, "profile");
		Thread.sleep(3000);

		/* click profilepage*/
		WebElement profilepage = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[1]/a"));
		clickObj(profilepage, "profilepage");
		Thread.sleep(3000);
		
		/* click uploadimage*/
		WebElement uploadimage = driver.findElement(By.xpath(".//*[@id='button-1041']"));
		clickObj(uploadimage, "uploadimage");
		Thread.sleep(3000);
		
		/* click browse*/
		WebElement browse = driver.switchTo().activeElement();
		enterText(browse, "images (1).jpg", "photo uploaded");
		Thread.sleep(3000);

		WebElement upload = driver.findElement(By.xpath(".//*[@id='button-1178']"));
		clickObj(upload, "upload");

		
		Thread.sleep(5000);
		bw.close();
	
	}
	
	public static void Add_another_organization_Trail_version_1() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		String Email, password,orgName,orgDo,taxPaid,timeZone;
		
			Email = recCreden[13][1];
			password = recCreden[14][1];
			orgName = recCreden[11][1];
			orgDo = recCreden[12][1];
			taxPaid = recCreden[15][1];
			timeZone = recCreden[16][1];

			
			Thread.sleep(3000);
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
		/* click self*/
		WebElement self = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
		clickObj(self, "self");
		
		Thread.sleep(3000);
		/* click my xero*/
		WebElement xero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
		clickObj(xero, "my xero");
		
		/* click add organization*/
		WebElement add = driver.findElement(By.xpath(".//*[@id='ext-gen1043']"));
		clickObj(add, "add organization");

		/*give organization name*/
		Thread.sleep(3000);
		WebElement oName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
		enterText(oName, orgName ,"organization Name");
		
		/*give where organizer pay tax*/
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(country, taxPaid ,"country name");
		
		/*give time zone*/
		Thread.sleep(3000);
		WebElement time = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-inputEl']"));
		enterText(time, timeZone ,"timeZone");


		/*give organization do */
		Thread.sleep(3000);
		WebElement oDo = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(oDo, orgDo ,"organization Do");
		
		Thread.sleep(3000);
		/* click start trial*/
		WebElement trial = driver.findElement(By.xpath(".//*[@id='simplebutton-1035']"));
		clickObj(trial, "start trial");
		Thread.sleep(3000);
		/*verify trial text*/
		WebElement trialtext = driver.findElement(By.xpath(".//*[@id='root']/div/div/header/div/h1"));
		verifyText(trialtext, orgName);
		Thread.sleep(3000);
		
		bw.close();
	}
	
	public static void Add_another_organization_Paid_version_1() throws IOException, InterruptedException{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.xero.com/us/");
		WebElement login1 = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObj(login1,"login");
		
		String excelPath = "F:/seleniumExam/credentials.xls";
		
		String[][] recCreden = ReusableMethod.readExcel(excelPath, "Sheet1");
		String Email, password,orgName,orgDo,taxPaid,timeZone;
		
			Email = recCreden[13][1];
			password = recCreden[14][1];
			orgName = recCreden[11][1];
			orgDo = recCreden[12][1];
			taxPaid = recCreden[15][1];
			timeZone = recCreden[16][1];

			
			Thread.sleep(3000);
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
		/* click self*/
		WebElement self = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
		clickObj(self, "self");
		
		Thread.sleep(3000);
		/* click my xero*/
		WebElement xero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
		clickObj(xero, "my xero");
		
		/* click add organization*/
		WebElement add = driver.findElement(By.xpath(".//*[@id='ext-gen1043']"));
		clickObj(add, "add organization");

		/*give organization name*/
		Thread.sleep(3000);
		WebElement oName = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
		enterText(oName, orgName ,"organization Name");
		
		/*give where organizer pay tax*/
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
		enterText(country, taxPaid ,"country name");
		
		/*give time zonee*/
		Thread.sleep(3000);
		WebElement time = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-inputEl']"));
		enterText(time, timeZone ,"timeZone");

		/*give organization do */
		Thread.sleep(3000);
		WebElement oDo = driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']"));
		enterText(oDo, orgDo ,"organization Do");
		
		Thread.sleep(3000);
		/* click start paid*/
		WebElement paid = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
		clickObj(paid, "buy now");
		Thread.sleep(3000);
				
		bw.close();
	}

	
		

}	
