package com.annotations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_LogIn {
	FirefoxDriver  driver;
	@BeforeTest
	public void SetUp(){
		driver=new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void LogIn() throws IOException{
		FileInputStream file=new FileInputStream("F:\\Eclipse\\Corejava\\MavenProject2\\TestInput\\Book1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet Sheet=workbook.getSheet("Sheet1");
		int RowCount=Sheet.getLastRowNum();
		for(int i=1;i<=RowCount;i++){
			Row r=Sheet.getRow(i);
			driver.findElement(By.name("userName")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.name("password")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.name("login")).click();
			String expected_Title="Find";
			String actual_Title=driver.getTitle();
			if(actual_Title.contains(expected_Title)){
				System.out.println("Title Matched...logIn Sucessfull..Pass");
				r.createCell(2).setCellValue("Title Matched...logIn Sucessfull..Pass");
			}
			else{
				System.out.println("Title Not Matched...LogIn..Fail");
				r.createCell(2).setCellValue("Title Not Matched..logIn..Fail");
			}
			FileOutputStream file1=new FileOutputStream("F:\\Eclipse\\Corejava\\MavenProject2\\TestOutput\\Book1.xlsx");
			workbook.write(file1);
			driver.navigate().back();
			}
	}
		@AfterTest
		public void tearDown(){
			driver.close();
			
	}
}
		
	
			
			
		

		
		
		
	


