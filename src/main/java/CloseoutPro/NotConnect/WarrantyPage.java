package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WarrantyPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public WarrantyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ====== LOCATORS ======
    By Warrantticket = By.id("link8");
        
    By warrantyduration = By.xpath("//span[.='Select Warranty Duration']");
    By selectduration = By.xpath("//div[.=' 2 Year ']");
    By submit = By.xpath("(//button[.=' Update '])[3]");
     
    public void slelectWarrantyDuration() {
    	 driver.findElement(warrantyduration).click();
    	 driver.findElement(selectduration).click();
    	 driver.findElement(submit).click();
    }
    
    By craetewarranty = By.xpath("//span[.='Create']");

    By title = By.xpath("//input[@name='title']");
    By subcontractor = By.xpath("//div[contains(@class,'p-treeselect')]");
    By company = By.xpath("//div[.='Company']");
    By hsm = By.xpath("//span[@title='HSM Contech']");

    

    // ====== ACTIONS ======

    public void clickWarranty() {
        driver.findElement(Warrantticket).click();
    }

    public void clickCreateWarranty() {
        driver.findElement(craetewarranty).click();
    }

    public void addWarrantyDetails1(String Title) {
        driver.findElement(title).sendKeys(Title);     
        driver.findElement(subcontractor).click();
 }

    public void addWarrantyDetails2() {
  
    driver.findElement(company).click();
    driver.findElement(hsm).click();
    }
    
    
 
    
    
    
    
    
    public void fillMandatoryCustomFields() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // ✅ Step 1: get all field containers
        List<WebElement> fields = driver.findElements(
            By.xpath("//div[@formarrayname='customItems']/div")
        );

        for (WebElement field : fields) {

            try {
                // ================= STEP 2: CHECK MANDATORY =================
                boolean isMandatory = !field.findElements(
                    By.xpath(".//span[contains(text(),'*')]")
                ).isEmpty();

                if (!isMandatory) continue;

                // ================= STEP 3: IDENTIFY FIELD TYPE =================

                // 🔹 DROPDOWN FIRST
                List<WebElement> dropdowns = field.findElements(
                    By.cssSelector(".p-dropdown")
                );

                if (!dropdowns.isEmpty()) {

                    WebElement dropdown = dropdowns.get(0);

                    if (!dropdown.isDisplayed()) continue;

                    ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();", dropdown
                    );

                    WebElement panel = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(@class,'p-dropdown-panel') and not(contains(@style,'display: none'))]")
                        )
                    );

                    List<WebElement> options = panel.findElements(
                        By.xpath(".//li[@role='option']")
                    );

                    if (!options.isEmpty()) {
                        ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].click();", options.get(0)
                        );
                    }

                    continue;
                }

                // 🔹 INPUT / TEXTAREA / NUMBER (including calendar input now)
                List<WebElement> inputs = field.findElements(
                    By.xpath(".//input | .//textarea")
                );

                if (!inputs.isEmpty()) {

                    WebElement input = inputs.get(0);

                    if (!input.isDisplayed() || !input.isEnabled()) continue;
                    if (input.getAttribute("readonly") != null) continue;

                    String type = input.getAttribute("type");

                    input.click();

                    if ("number".equalsIgnoreCase(type)) {
                        input.sendKeys("123");
                    } else {
                        input.sendKeys("Test123");
                    }

                    continue;
                }

                // 🔹 CHECKBOX (optional)
                List<WebElement> checkboxes = field.findElements(By.cssSelector("p-checkbox"));

                if (!checkboxes.isEmpty()) {
                    checkboxes.get(0).click();
                    continue;
                }

            } catch (Exception e) {
                System.out.println("Skipped one mandatory field");
            }
        }
    }
    
 
    
    // click craete button
    
    By createwarranty = By.xpath("//button[normalize-space()='Create New Warranty']");
    
    public void clickCreateWarrantyBtn() {
    	driver.findElement(createwarranty).click();
    }
    
    		
    
    
    
  // update warranty 
    
   By warranty1 = By.xpath("//div[.='automation warranty 1']");
    
   public void getWarranty1() {
	   driver.findElement(warranty1).click();
   }
    
   By editBtn = By.xpath("//button[.=' Edit ']");
   
   public void clickEdit() {
	   driver.findElement(editBtn).click();
   }
    
   
   By updatetitle = By.xpath("//input[@formcontrolname='title']");
   
   public void editTitle(String edittitle) {
	   driver.findElement(updatetitle).clear();
	   driver.findElement(updatetitle).sendKeys(edittitle);
   }
   
    
   By updatebtn = By.xpath("//button[.=' Update Warranty ']");
   
   public void clickUpdateWarranty() {
	   driver.findElement(updatebtn).click();
   }
   
    
   
   
   // Suspend Resume Warranty 
   
   By suspendbtn = By.xpath("//span[.='Suspend Ticket']");
   By next = By.xpath("//button[@style='display: inline-flex;']");
   By select15 = By.xpath("//span[.='15']");
   By ok = By.xpath("//button[.='OK']");
   By yes = By.xpath("//button[.='Yes']");
   
   
   public void suspendWarranty() {
	  driver.findElement(suspendbtn).click();
	  driver.findElement(next).click();
	  driver.findElement(select15).click();
	  driver.findElement(ok).click();
	  driver.findElement(yes).click();
   }
   
        
   
   By resumebtn = By.xpath("//button[.='Resume Ticket']");
   By resumeyes = By.xpath("//button[.='Yes']");
   
   public void ResumeWarranty() {
	   
	   driver.findElement(resumebtn).click();
	   driver.findElement(resumeyes).click();
	   
   }
   
   
   
   
   
   
   // close warranty Ticket 
   
   
   By closebtn = By.xpath("//button[.=' Close ']");
   By closecomment = By.xpath("//textarea[@formcontrolname='closedComment']");
   
   
   public void closeWarranty1(String comment) {
	   driver.findElement(closebtn).click();
	   driver.findElement(closecomment).sendKeys(comment);
	   
   }
   
   
   By closewarranty = By.xpath("//button[.=' CLOSE WARRANTY ']");
  
   public void clickCloseWarranty() {
	  driver.findElement(closewarranty).click(); 
   }
   
   
   
   
   // delete warranty 
   
   By deletebtn = By.xpath("//span[.=' Delete']");   
   By yesdelete = By.xpath("//button[.='Yes, Delete it!']");
   
   public void deleteWarranty() {
	   driver.findElement(deletebtn).click();
	   driver.findElement(yesdelete).click();
   }
   
   
   By archive = By.xpath("//label[.='Archive']");
   
   public void clickArchive() {
	   driver.findElement(archive).click();
   }
   
   
   By pdelete = By.xpath("//span[.='Delete']");  
   By yesdelete2 = By.xpath("//button[.='Yes, Delete it!']");
   
   
   public void permanentDeleteWarranty() {
	   driver.findElement(pdelete).click();
	   driver.findElement(yesdelete2).click();
   }
   
   
   
   
   
   
   
   
    
    
    
    
}
    
    
    