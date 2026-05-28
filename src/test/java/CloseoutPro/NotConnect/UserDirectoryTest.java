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
    public void UserDirectary() throws InterruptedException {
        Initialize();
        LoginCredentials();
        Thread.sleep(3000);
        ProfileDropdown();
    }
    

    @Test          (priority = 2)
    public void CreateUser() throws InterruptedException {
    	
    	UserDirectoryPage add = new UserDirectoryPage(driver);
    	   	 
    	add.clickDirectary();  
         ProfileDropdown();         // use for close dropdown
         Thread.sleep(5000);     
         add.addUser("User-Test", "sahil.hsmedifice@gmail.com", "QA-1");
    }

    
    @Test     (priority = 3)
    public void editUser() throws InterruptedException {
    	
    	UserDirectoryPage edit = new UserDirectoryPage(driver);
  
        Thread.sleep(5000);    
        
        String desiredUserName = "User-Test";
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
        
     
        edit.enterEditDetails("User-Test Updates", "QA-2");
              
    }
 
    
    
    
    
    
    
    @Test    (priority = 4)
    public void deleteUser() throws InterruptedException {
    	UserDirectoryPage delete = new UserDirectoryPage(driver);
     
        Thread.sleep(4000);
        
        
        
        String desiredUserName = "User-Test Updates";
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
        delete.deleteUser();
              
    }
    
    
    
    
    

}
