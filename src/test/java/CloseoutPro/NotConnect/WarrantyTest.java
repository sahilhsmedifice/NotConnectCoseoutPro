package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WarrantyTest extends GlobalData {

    @Test(priority = 1)
    public void selectProject() throws InterruptedException {

        Initialize();
        LoginCredentials();

        
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        String desiredProjectName = "123 - NotConnect Automation Project";

        List<WebElement> projects = getProjectList();

        for (WebElement project : projects) {

            if (project.getText().contains(desiredProjectName)) {

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", project);

                wait.until(ExpectedConditions.elementToBeClickable(project)).click();
                break;
            }
        }
    }
    
    
    
    
    

    @Test(priority = 2)
    public void createWarranty() throws InterruptedException {

        WarrantyPage page = new WarrantyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(3000);
        
        // Open warranty module
        wait.until(ExpectedConditions.elementToBeClickable(page.Warrantticket)).click();

        Thread.sleep(3000);
        // Click create
        wait.until(ExpectedConditions.elementToBeClickable(page.craetewarranty)).click();

        Thread.sleep(8000);
        // Fill basic details
        page.addWarrantyDetails1("automation warranty 1");
        
        Thread.sleep(3000);
        page.addWarrantyDetails2();
             
         
        Thread.sleep(3000);
        // Fill dynamic custom fields
        page.fillMandatoryCustomFields();
        
        
        Thread.sleep(3000);
        
        page.clickCreateWarrantyBtn();
        
        
        
        
    }
    
    
    
    
    
    
}




