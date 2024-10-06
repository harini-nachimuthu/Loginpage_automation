package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basemethod.base;
import Pages.loginpage;

public class logintest extends base{

	@BeforeTest
	public void befreclass() {
		excelfile="Test_loginpractise";
		sheetname="Logintestcase";
	}
	
	@Test(dataProvider="Readingdatafromexcel")
	public void logintestcases(String username,String password,String datas) {
		loginpage obj=new loginpage(driver);
		obj.loginusername(username);
		obj.loginpassword(password);
		obj.loginclick();
		
		if(datas.equals("Bothcorrect")) {
			obj.outputele();
			obj.outlog();
			System.out.println("Login successfull");
		}else if(datas.equals("Usernameincorrect")) {
			obj.outputele2();
			System.out.println("Invalid Username");
			
		}else if(datas.equals("Passwordincorrect")) {
			obj.outputele1();
			System.out.println("Invalid Password");

		}
	}
}
