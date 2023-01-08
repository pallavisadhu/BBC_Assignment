package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePgeTest extends TestBase{
	
	HomePage hp;
	
	@BeforeClass
	public void init() {
		hp = PageFactory.initElements(driver, HomePage.class);
	}
	
	@Test
	public void verifyAllLinksTest() {
		hp.findAllLinks();
	}
	
	@Test
	public void verifyNewsLinksTest() throws EncryptedDocumentException, IOException, InvalidFormatException {
		hp.findNewsLinks();
	}
	
	
}
