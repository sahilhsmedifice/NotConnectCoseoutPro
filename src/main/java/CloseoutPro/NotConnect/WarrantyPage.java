package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
    
    		
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    