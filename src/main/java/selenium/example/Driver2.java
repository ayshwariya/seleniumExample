package selenium.example;

import java.io.IOException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Driver2 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		String dtTablePath = "F:/seleniumExam/TestSuite.xls";

		String[][] recData = ReusableMethod.readExcel(dtTablePath, "Sheet1");
		String testCase, flag, firefox, chrome, IE;
		for(int i = 1; i <recData.length; i++){

			flag = recData[i][1];
			if(flag.equalsIgnoreCase("Y")){
				firefox = recData[i][3];
				if(firefox.equalsIgnoreCase("Y")){
					testCase = recData[i][2];
					ReusableMethod.startReport(testCase, "F:/seleniumExam/reports/");
					
					System.setProperty("webdriver.gecko.driver", "F:/code/seleniumJar/geckodriver.exe");
					
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("browser.tabs.remote.autostart", false);
					profile.setPreference("browser.tabs.remote.autostart.1", false);
					profile.setPreference("browser.tabs.remote.autostart.2", false);
					profile.setPreference("browser.tabs.remote.force-enable", "false");
					
					FirefoxOptions options = new FirefoxOptions();
					options.setProfile(profile);
					
					driver = new FirefoxDriver(options);
					
					Method tc = AutomationScript.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit();

					ReusableMethod.bw.close();
				}

				chrome = recData[i][4];
				if(chrome.equalsIgnoreCase("Y")){
					testCase = recData[i][2];
					ReusableMethod.startReport(testCase, "F:/seleniumExam/reports/");
					System.setProperty("webdriver.chrome.driver", "F:/code/seleniumJar/chromedriver.exe");
					driver = new ChromeDriver();
					Method tc = AutomationScript.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit();

					ReusableMethod.bw.close();
				}

				IE = recData[i][5];
				if(IE.equalsIgnoreCase("Y")){
					testCase = recData[i][2];
					ReusableMethod.startReport(testCase, "F:/seleniumExam/reports/");
					System.setProperty("webdriver.ie.driver", "F:/code/seleniumJar/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					Method tc = AutomationScript.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit();

					ReusableMethod.bw.close();
				}


			}



		}




	}
}
