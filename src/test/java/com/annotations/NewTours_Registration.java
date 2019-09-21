package com.annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_Registration {
	FirefoxDriver driver;
	@BeforeTest
	public void SetUp(){
		driver=new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com");
		//driver.findElementByLinkText("REGISTER").click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(priority=0)
	public void Register(){
		driver.findElementByLinkText("REGISTER").click();
	}
	@Test(priority=1)
	public void UserRegistration(){
		driver.findElementByName("firstName").sendKeys("Pankaj");
		driver.findElementByName("lastName").sendKeys("Barik");
		driver.findElementByName("phone").sendKeys("9052904687");
		driver.findElementById("userName").sendKeys("bariknutan55@gmail.com");
		driver.findElementByName("address1").sendKeys("Balasore");
		driver.findElementByName("city").sendKeys("Balasore");
		driver.findElementByName("state").sendKeys("Odisha");
		driver.findElementByName("postalCode").sendKeys("756001");
		driver.findElementByName("country").sendKeys("INDIA");
		driver.findElementById("email").sendKeys("Pankaj123");
		driver.findElementByName("password").sendKeys("ramhari");
		driver.findElementByName("confirmPassword").sendKeys("ramhari");
		driver.findElementByName("register").click();
		String expected_UserName="Pankaj123";
		String actual_RegisteredUserName=driver.findElementByXPath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b").getText();
		if(actual_RegisteredUserName.contains(expected_UserName)){
			System.out.println("User Registered Sucessfully");
			
		}
		else{
			System.out.println("User Registered Failed");
		}
	}
		@AfterTest
		public void tearDown(){
			driver.close();
		}
}
			
		
		
		
		
		
	


