package CloseoutPro.NotConnect;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WarrantyTest extends GlobalData {

    @Test(priority = 1)
    public void WarrantyTicket() throws InterruptedException {

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
    
    
    

    @Test     (priority = 2)
    public void createWarranty() throws InterruptedException {

        WarrantyPage add = new WarrantyPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(3000);
        
        // Open warranty module
        wait.until(ExpectedConditions.elementToBeClickable(add.Warrantticket)).click();
        
        Thread.sleep(2000);
        add.slelectWarrantyDuration();
         
        

        Thread.sleep(3000);
        // Click create
        wait.until(ExpectedConditions.elementToBeClickable(add.craetewarranty)).click();

        Thread.sleep(8000);
        // Fill basic details
        add.addWarrantyDetails1("automation warranty 1");
        
        Thread.sleep(3000);
        add.addWarrantyDetails2();             
         
        Thread.sleep(3000);
        // Fill dynamic custom fields
        add.fillMandatoryCustomFields();
                
        Thread.sleep(3000);
        
        add.clickCreateWarrantyBtn();
        
              
        
    }
    
    
    
    @Test   (priority = 3)
    public void UpdateWarranty() throws InterruptedException {
    	
    	 WarrantyPage update = new WarrantyPage(driver);
       
         Thread.sleep(3000);         
        
    	update.getWarranty1();
    	Thread.sleep(3000);      
         
        update.clickEdit();
        Thread.sleep(5000);
         
    	update.editTitle("automation warranty 1 - Updated");
    	
    	 Thread.sleep(3000);
    	update.clickUpdateWarranty();
    	Thread.sleep(3000);
         
    	
    }
    
    
    
    
    @Test    (priority = 4)
     
    public void SuspendResumeTicket() throws InterruptedException {
    	
    	 WarrantyPage suspend = new WarrantyPage(driver);
    
    	Thread.sleep(4000);           	
    	suspend.suspendWarranty();    	
    	
    	 Thread.sleep(4000);     
    	suspend.ResumeWarranty();
    
    	
    }
    
    
    
    @Test (priority = 5)
     public void closeWarrantyTicket() throws InterruptedException, AWTException {
    	 
    	 WarrantyPage close = new WarrantyPage(driver);
    	        	 
         Thread.sleep(3000);           	 
    	 close.closeWarranty1("automated close warranty comment");
    	    	 
   // robot class use for upload attachment 	 
    	 
    	   Thread.sleep(1000);			
		    driver.findElement(By.xpath("//i[@class='fa fa-cloud-upload']")).click();
		  
		 Thread.sleep(3000);		 
		 Robot robot = new Robot();
		 robot.delay(1000);		 
		 StringSelection file = new StringSelection("C:\\File Types\\spec 03 mcel pob.pdf");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);	 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);	 
		 robot.delay(1000);		 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
			 
		 Thread.sleep(3000);				
		 close.clickCloseWarranty();
		 
		 
    	 
     }
    
    
    
    
    @Test    (priority = 6)
    
    public void deleteWarranty() throws InterruptedException {
    	
    	 WarrantyPage delete = new WarrantyPage(driver);
            	
         Thread.sleep(3000);
    
    delete.deleteWarranty();
    Thread.sleep(2000);
    
    delete.clickArchive();
    Thread.sleep(2000);
    
    
    delete.permanentDeleteWarranty();
    
  
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    
    
    
    
    
    
    
    
}




