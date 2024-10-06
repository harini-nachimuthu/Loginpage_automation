package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basemethod.base;


public class loginpage extends base {
	
	public loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submit")
	WebElement submit;
	
	public loginpage loginusername(String name) {
		findelementidandsendkeys("username",name);
		return this;
	}
	
	public loginpage loginpassword(String password) {
		findelementidandsendkeys("password",password);
		return this;
	}
	
	public void loginclick() {
		clickbtn(submit);
	}
	
	@FindBy(xpath="//body//div//div//section//div//div//article")
	WebElement logsuccess;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement invalpass;

	@FindBy(id="error")
	WebElement invaluser;
	
	public void outputele() {
		String value=logsuccess.getText();
	}

	public void outputele1() {
		String value=invalpass.getText();
	}
	
	public void outputele2() {
		String value=invaluser.getText();
	}
	
	@FindBy(xpath="//a[.='Log out']")
	WebElement loginout;
	
	public void outlog() {
		clickbtn(loginout);
	}
}
