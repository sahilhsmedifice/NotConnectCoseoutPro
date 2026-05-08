package CloseoutPro.NotConnect;
 

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

 

public class UserDirectoryTest extends GlobalData {
	 
	
    @Test(priority = 1)
    public void UserDirectary() {
        Initialize();
        LoginCredentials();
        ProfileDropdown();
    }

    @Test   (enabled = false)                  //  (priority = 2)
    public void CreateUser() throws InterruptedException {
    	
    	UserDirectoryPage add = new UserDirectoryPage(driver);
    	   	 
    	add.clickDirectary(); // Optional
         ProfileDropdown();
         Thread.sleep(5000);
         add.addUser("sahil", "sahil@hsmedifice.com", "developer");
    }

    
    @Test       (enabled = false)                        //       (priority = 2)
    public void editUser() throws InterruptedException {
    	
    	UserDirectoryPage edit = new UserDirectoryPage(driver);
    //	edit.clickDirectary();  // check once
        Thread.sleep(1000);
        ProfileDropdown();    // use for close
        
        String desiredUserName = "ayushi zodape";
        List<WebElement> users = edit.getUsersList();

        for (WebElement u : users) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", u);
            Thread.sleep(100);   
         
            if (u.getText().contains(desiredUserName)) {
            	 System.out.println("User found: " + desiredUserName);
                WebElement editButton = u.findElement(By.xpath("./td[6]/div/button[2]"));
                                
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
                break;  
            }            
        }
        
        driver.findElement(By.xpath("//input[@placeholder='Full Name *']")).clear();     
        edit.enterEditDetails("Sahil Chauhan", "Test User");
              
    }
 
    
    
    
    
    
    
    @Test    (priority = 2)
    public void deleteUser() throws InterruptedException {
    	UserDirectoryPage delete = new UserDirectoryPage(driver);
    	delete.clickDirectary();
        Thread.sleep(1000);
        ProfileDropdown();    // use for close
        
        
        String desiredUserName = "Meherdip Thosar";
        List<WebElement> users = delete.getUsersList();

        for (WebElement u : users) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", u);
            Thread.sleep(100);   
         
            if (u.getText().contains(desiredUserName)) {
                WebElement editButton = u.findElement(By.xpath("./td[6]/div/button[3]"));
                                
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
                break;  
            }            
        }
  //      delete.deleteUser();
              
    }
    
    
    
    
    

}
