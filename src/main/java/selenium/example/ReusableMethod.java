package selenium.example;

import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;





import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReusableMethod extends Driver2{
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;


	/* Name of the method: Enter text 
	 * Brief Description: Enter text to text field
	 * Arguments: obj --> object, textval --> text value to be entered, objName --> object name
	 * created by: Automation team
	 * Creation Date: Dec 18 2017
	 * Last Mdified: Dec 18 2017 
	 * */
	public static void enterText(WebElement obj, String textVal , String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			Update_Report("pass","enterText", textVal+ " is entered in " + objName + " field");
			System.out.println("pass : " + textVal+ " is entered in " + objName + " field" );
		}else{
			Update_Report("Fail","enterText", objName + " field is not displayed, please check your application ");
			System.out.println(" Fail : " + objName + " field is not displayed, please check your application ");
		}

	}

	/* Name of the method: clickObj   (CMM V level coding) 
	 * Brief Description: click on object
	 * Arguments: obj --> object, objName --> object name
	 * created by: Automation team
	 * Creation Date: Dec 18 2017
	 * Last Mdified: Dec 18 2017 
	 * */
	public static void clickObj(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass","clickObj", objName +" is clicked");
			System.out.println("pass : " + objName +" is clicked" );
		}else{
			Update_Report("Fail", "clickObj", objName + " field is not displayed");
			System.out.println(" Fail : " + objName + " field is not displayed");
		}
	}


	/* Name of the method: clear 
	 * Brief Description: click the field
	 * Arguments: obj --> object, objName --> object name
	 * created by: Automation team
	 * Creation Date: Dec 18 2017
	 * Last Mdified: Dec 18 2017 
	 * */
	public static void clear(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.clear();
			Update_Report("pass", "clear", objName +" is cleared" );
			System.out.println("pass : " + objName +" is cleared" );
		}else{
			Update_Report("Fail", "clear", objName +" field is not displayed" );
			System.out.println("Fail : " + objName +" field is not displayed");
		}
	}

	/* Name of the method: verify
	 * Brief Description: verify the text
	 * Arguments: obj --> object, text -->  text
	 * created by: Automation team
	 * Creation Date: Dec 18 2017
	 * Last Mdified: Dec 18 2017  
	 * */


	public static void verifyText(WebElement obj, String text) throws IOException {
		if (obj != null && !obj.getText().isEmpty() && obj.getText().equals(text)) {
			Update_Report("Pass", "verifyText",text);
			System.out.println("Pass: " + text);
		} else {
			Update_Report("Fail", "verifyText",text);
			System.out.println("Fail: "+text);
		}
	}
	
	public static void verifyText(String str, String compareWith) throws IOException {
		if (str != null && !str.isEmpty() && str.equals(compareWith)) {
			Update_Report("Pass", "verifyText",str);
			System.out.println("Pass: " + str);
		} else {
			Update_Report("Fail", "verifyText",str);
			System.out.println("Fail: "+str);
		}
	}

	/* Name of the method: verifyAttribute
	 * Brief Description: verify the value of attribute
	 * Arguments: obj --> object, text -->  text
	 * created by: Automation team
	 * Creation Date: Dec 18 2017
	 * Last Mdified: Dec 18 2017  
	 * */


	public static void verifyAttribute(WebElement obj, String text, String attributeName) throws IOException {
		if (obj != null && text.equals(obj.getAttribute(attributeName))) {
			Update_Report("Pass", "verifyAttribute","attribute value found - " + text);
			System.out.println("Pass: attribute value found - " + text);
		} else {
			Update_Report("Fail", "verifyAttribute", "attribute value NOT found. attr - ");
			System.out.println("Fail: attribute value NOT found. attr - " + attributeName);
		}
	}






	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");

	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	
	public static String[][] readExcel(String dtTablePath, String sheetName ) throws IOException{

		/*Step 1: Get the XL Path*/
		File xlFile = new File(dtTablePath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getPhysicalNumberOfRows();
		int iColCount = sheet.getRow(0).getLastCellNum();

		//System.out.println("rowcount :"+iRowCount);
		//System.out.println("colcount"+iColCount);

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i =0; i<iRowCount; i++){
			for(int j = 0; j <iColCount; j++){
				//System.out.println("i : "+ i +" j : "+ j);
				//System.out.println("sheet row cell : "+sheet.getRow(i).getCell(j));
				
				DataFormatter formatter = new DataFormatter();
				String val = formatter.formatCellValue(sheet.getRow(i).getCell(j));

				xlData[i][j] = val;
				//System.out.println(" get string value : "+val);
			}

		}
		return xlData;
	}

}


