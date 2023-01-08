package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import readconfigs.ConfigFileReader;

public class TestBase {
	
	public static WebDriver driver;
	ConfigFileReader cfr;
	@BeforeSuite
	public void initialize() throws IOException {
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		cfr = new ConfigFileReader();
		driver.get(cfr.getUrl());
		
	}
	
	@BeforeTest
	public void printBeforeTest() {
		System.out.println("Test Started");
	}
	
	@AfterTest
	public void printAfterTest() {
		System.out.println("Test Exited");
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}


}
