package Utility;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	
	//protected String url="https://practicetestautomation.com/practice-test-login/";
	public WebDriver driver;
	
	public String excelfile;
	public String sheetname;
	
	public void closebrowser() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	public void quitbrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public void clickbtn(WebElement ele) {
		ele.click();
	}
	
	public void launchbrowser(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	public void urllaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	public String[][] readexcel(String excelfile,String sheetname) throws IOException{
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\Login_page_practise\\excelfile\\"+excelfile+".xlsx");
		XSSFSheet sheet=book.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		int columncount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowcount][columncount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				XSSFCell cell=row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}
	
	public void findelementidandsendkeys(String idvalue,String usernamekey) {
		 driver.findElement(By.id(idvalue)).sendKeys(usernamekey);
	}
}
