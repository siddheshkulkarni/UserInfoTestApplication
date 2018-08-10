package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginAndRegistrationTests {
  private String url;
  private String registerUrl;
  
	
  @BeforeClass
  public void init() {
	  System.setProperty("webdriver.chrome.driver","/Users/siddhesh/Downloads/chromedriver");  
    url = "http://localhost:8080/UserInfo/login.jsp";
    registerUrl = "http://localhost:8080/UserInfo/register.jsp";
  }
  
  @Test(priority=1)
  public void testLoginPageLoads() throws InterruptedException { 
	  WebDriver driver = new ChromeDriver();
	  driver = new ChromeDriver();
	  driver.get(url); 
    Thread.sleep(1000);  
    Assert.assertTrue(driver.getPageSource().contains("Welcome to User Information System"));
    driver.close();	
  }
  
  @Test(priority=2)
  public void testloginUserFunctionality() {
	WebDriver driver = new ChromeDriver();  
    driver.get(url);
    driver.findElement(By.id("username")).sendKeys("siddhesh");
    driver.findElement(By.id("password")).sendKeys("aaaaaaa");
    driver.findElement(By.name("login")).click();
    driver.close();	
  }
  
  @Test(priority=2)
  public void testRegisterUserFunctionality() {
	WebDriver driver = new ChromeDriver();  
    driver.get(registerUrl);  
    driver.findElement(By.id("firstname")).sendKeys("john1234");
    driver.findElement(By.id("lastname")).sendKeys("jackson");
    driver.findElement(By.id("address")).sendKeys("123, Main st");
    driver.findElement(By.id("username")).sendKeys("john1234");
    driver.findElement(By.id("password")).sendKeys("john1234");
    driver.findElement(By.id("reenterpassword")).sendKeys("john1234");
    driver.findElement(By.name("submit")).click();
    driver.close();	
  }
  
  @Test(priority=3)
  public void testResetUserFunctionality() {
	  WebDriver driver = new ChromeDriver();
	    driver.get(registerUrl);  
	    driver.findElement(By.id("firstname")).sendKeys("jim1234");
	    driver.findElement(By.id("lastname")).sendKeys("Monty");
	    driver.findElement(By.id("address")).sendKeys("156, Main st");
	    driver.findElement(By.id("username")).sendKeys("jim1234");
	    driver.findElement(By.id("password")).sendKeys("jim1234");
	    driver.findElement(By.id("reenterpassword")).sendKeys("jim1234");
	    driver.findElement(By.name("reset")).click();
	    driver.close();	
	  }
  
  @Test (priority=2, dependsOnMethods="testRegisterUserFunctionality")
  public void testDeleteUserFunctionality() throws InterruptedException {
	WebDriver driver = new ChromeDriver();  
    driver.get(url);
	driver.findElement(By.id("username")).sendKeys("john1234");
	driver.findElement(By.id("password")).sendKeys("john1234");
	driver.findElement(By.name("login")).click(); 
	Thread.sleep(2000);
	System.out.println("page url ====== "+driver.getCurrentUrl());
	driver.findElement(By.id("delete")).click();
	driver.close();	
  }
}
