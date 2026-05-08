package CloseoutPro.NotConnect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssetsPage {

	
	WebDriver driver;

	// constructer
	public AssetsPage(WebDriver driver) {		
		this.driver = driver;		
	}
	
	
	By Asset = By.id("menu6");
	
	public void clickAsset() {
		driver.findElement(Asset).click();
	}
     
	
	By createbtn = By.xpath("//span[.='Create Asset ']");	
		
	public void clickCreate() {
		driver.findElement(createbtn).click();
	}
	
	 
	
	By assetname = By.xpath("//input[@placeholder='Assets Name*']");	 
	By duration = By.xpath("//select[@formcontrolname='warrantyDuration']");	
	By linkcloseout = By.id("dropdownAccordion1");	
	By warranties = By.xpath("//div[@title='Warranties']");	
	By selectitem = By.xpath("//div[@class='closeout-items']");
	
	
	
	public void createAsset1(String name) {
				 
		driver.findElement(assetname).sendKeys(name);
		
		 Select select = new Select(driver.findElement(duration));
		 select.selectByIndex(1); 
		
		 driver.findElement(linkcloseout).click();
		 driver.findElement(warranties).click();
		 driver.findElement(selectitem).click();
		 driver.findElement(linkcloseout).click();
		 
		 			 
	}
	
	 
	 //   custom field handle
	
	
	By customFields = By.xpath("//div[@formarrayname='customItems']");

	public void fillCustomFields() {

	    List<WebElement> fields = driver.findElements(customFields);

	    for (WebElement field : fields) {

	        // Handle Text Field
	        List<WebElement> textBox = field.findElements(By.tagName("input"));
	        if (!textBox.isEmpty()) {
	            textBox.get(0).sendKeys("1234");
	            continue;
	        }

	        // Handle Dropdown
	        List<WebElement> dropdown = field.findElements(By.tagName("select"));
	        if (!dropdown.isEmpty()) {
	            Select select = new Select(dropdown.get(0));
	            select.selectByIndex(1);
	            continue;
	        }

//	        // Handle Date Field
//	        List<WebElement> dateField = field.findElements(By.xpath(".//input"));
//	        if (!dateField.isEmpty()) {
//	            dateField.get(0).sendKeys("24-04-2026");
//	        }
	        
	        
	    }
	}
	
	
	  
	 
	By clickcreate = By.xpath("//button[.=' Create New Asset ']");
	
	public void clickCreateAsset() {
		driver.findElement(clickcreate).click();
	}
	
	
	
	// Edit Asset 
	
	By clickedit = By.xpath("(//button[@class='btn btn-secondary btn-sm ng-star-inserted'])[2]");	
	
	public void clickEdit() {
		driver.findElement(clickedit).click();
	}
	
	
	
	By assetname2 = By.xpath("//input[@placeholder='Assets Name *']");
	By updateasset = By.xpath("//button[.=' Update Asset ']");
	
	public void editasset(String updatedName) {
			 
		driver.findElement(assetname2).clear();
		driver.findElement(assetname2).sendKeys(updatedName);
		
		driver.findElement(updateasset).click();
		
	}
	
	// assert 
	
	 By Nameasset = By.xpath("//div[@class='accordian-title']");
		
	  
	 public String getAssetName() {
	     return driver.findElement(Nameasset).getText();
	 }
	
	
	
	
	
	
	
	// delete asset 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

















