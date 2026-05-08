package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloseoutPage {

	
	
	WebDriver driver;

	// constructer
	public CloseoutPage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	// closeout locaters add

	By closeout = By.id("menu5");
		
	public void clickCloseout() {	
	driver.findElement(closeout).click();
		
	}
	
	

	By addBtn = By.cssSelector(".px-3.py-2.d-flex.align-items-center.export-area");
	By itemname = By.xpath("//input[@formcontrolname='closeoutItemName']");
	By specdropdown = By.id("onCustomDropdown");
	By specselect = By.xpath("//div[.=' 011234 - Test Spec ']");
	By Contractors = By.id("closeoutItemDropdown");
    By Company = By.xpath("//div[.=' HSM Contech ']");
	
	
	
	public void enterNameWithSpec(String ItemName) {

		driver.findElement(addBtn).click();
		driver.findElement(itemname).sendKeys(ItemName);
		driver.findElement(specdropdown).click();
		driver.findElement(specselect).click();
		driver.findElement(Contractors).click();
		driver.findElement(Company).click();
		

	}

	// locaters

  	By closeoutType = By.id("typesCloseoutItemDropdown");
  	By warranties = By.xpath("//div[.=' Warranties ']");
	By calender = By.cssSelector(".fa.fa-calendar");
	By selectDate = By.xpath("//span[normalize-space()='20']");
	By Subt = By.xpath("//button[.=' Submit ']");

	// method

	public void submitTypeAndDate() {
		
		driver.findElement(closeoutType).click();
		driver.findElement(warranties).click();	
		
		driver.findElement(calender).click();
		driver.findElement(selectDate).click();
		driver.findElement(Subt).click();

	}
	
	  
	 
	
	// update closeout status locaters
	
	//  approve  assert
	
	By approveStatus = By.cssSelector(".chip.Approved");
	
	 public WebElement getApproveStatus() {
	        return driver.findElement(approveStatus);
	    }
	
		
	
	// reject 
	 
	 By reject = By.xpath("//span[@mattooltip='Reject']");
	 
	 public void clickReject() {
		 driver.findElement(reject).click();
	 }
	
	
	// assert reject
	 
	 By rejectStatus = By.cssSelector(".chip.Rejected");
		
	 public WebElement getRejectStatus() {
	        return driver.findElement(rejectStatus);
	    }
	
	
	
	
	// validate comments 
	 
	 By text = By.id("btn-input");
	 By send = By.xpath("//button[.=' Send ']");
	 
	 public void enterText(String enter) {
		 driver.findElement(text).sendKeys(enter);
		 driver.findElement(send).click();
	 }
	 
	 // assert comment 
	 
	 

	 By tooltip = By.cssSelector(".swal2-title");

	 public String getTooltipValidation() {
	     return driver.findElement(tooltip).getText();
	 }
	 
	 
	 
	
	
	
	
	
	
	
	
	
	// Update Closeout
	
	 
	By closeoutRows = By.xpath("//tr[@class='text-center ng-star-inserted']");                 // Return all rows (not individual buttons)

	public List<WebElement> getCloseoutList() {
	    return driver.findElements(closeoutRows);
	}

	By edit = By.xpath("//button[.='Edit']");
	By description = By.xpath("//textarea[@placeholder='Description']");
	By subt = By.xpath("//button[.=' Submit ']");
	
	public void enterItemAndDescription(String name, String Description) {
		
		driver.findElement(edit).click();
		driver.findElement(itemname).clear();
		driver.findElement(itemname).sendKeys(name);
		driver.findElement(description).clear();
		driver.findElement(description).sendKeys(Description);
		driver.findElement(subt).click();		
		
	}
	
	
	
	 

	
	
	
	
	
	
	
	
}
