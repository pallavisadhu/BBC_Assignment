package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.TestUtil;

public class HomePage {
	
	TestUtil testUtil;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	@FindBy(xpath="//a[text()='News']/parent::h2//following-sibling::div//a[@class='media__link']")
	List<WebElement> newsLinks;
	
	@FindBy(xpath="//a[text()='News']/parent::h2//following-sibling::div//a[@class='media__link']/parent::h3//following-sibling::p[@class='media__summary']")
	List<WebElement> summary;
	
	public HomePage() {
		testUtil = new TestUtil();
	}
	public void findAllLinks() {
		System.out.println(links.size());
		for( WebElement link : links) {
			System.out.println(link.getText());
		}
	}
	
	public void findNewsLinks() throws EncryptedDocumentException, IOException, InvalidFormatException {
		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();

		System.out.println(newsLinks.size());
		System.out.println("------Heading-----");
		for(WebElement link : newsLinks) {
			System.out.println(link.getText());
			al1.add(link.getText());
		}
		System.out.println("------Summary------");
		for(WebElement link: summary) {
			System.out.println(link.getText());
			al2.add(link.getText());
		}
		testUtil.writeExcel(al1, al2);
		
	}
}
