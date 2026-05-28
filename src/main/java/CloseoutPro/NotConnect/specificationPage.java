package CloseoutPro.NotConnect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class specificationPage {

	WebDriver driver;
	
	// constructer
		 public specificationPage(WebDriver driver) {
		        this.driver = driver;
		    }
	
	// locaters
		  
   // add spec
				    
	By specBtn = By.id("menu13");
	By adBtn = By.id("add_btn");
	By divisions = By.xpath("//select[@formcontrolname='divisionNumber']");
	By general = By.xpath("//option[@value='01']");	
	By specNum = By.xpath("//input[@placeholder='Specification number']");
	By specName = By.xpath("//input[@placeholder='Specification description']");
	By subBtn = By.xpath("//button[.='Submit']");
			
	public void addSpecification(String numb,String nam ) {
				
		driver.findElement(specBtn).click();
		driver.findElement(adBtn).click();
		driver.findElement(divisions).click();
		driver.findElement(general).click();
		driver.findElement(specNum).sendKeys(numb);
		driver.findElement(specName).sendKeys(nam);
		driver.findElement(subBtn).click();
				 
	}
	
	 
	
	
	
	// Upload attachment
	
	
	By expandspec = By.xpath("//span[.=' Division-01 General Requirements ']");
	By uploadicon = By.cssSelector(".fa.fa-upload.text-primary");
	By datefield = By.id("setdate");
	By change = By.xpath("//span[.='›']");
	By selectdate = By.xpath("(//td[.='1'])[1]");
	
	public void uploadspec() {
		driver.findElement(expandspec).click();
		driver.findElement(uploadicon).click();
		driver.findElement(datefield).click();
		driver.findElement(change).click();
		driver.findElement(selectdate).click();
	}
	
	 
	By sevepec = By.xpath("//button[.='Save']");
	
	public void clickSave() {	 
		driver.findElement(sevepec).click();
	}
	
	
	
	
	
	
	
	
	
}