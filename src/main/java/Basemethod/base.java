package Basemethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Utility.utils;

public class base extends utils {
	
	@BeforeMethod
	public void befre() {
		launchbrowser("chrome");
		urllaunch("https://practicetestautomation.com/practice-test-login/");
	}
	
	@AfterMethod
	public void aftre() {
		quitbrowser();
	}
	
	@DataProvider(name="Readingdatafromexcel")
	public String[][] excelread() throws IOException{
		String[][] data1=readexcel(excelfile,sheetname);
		return data1;
	}

}
