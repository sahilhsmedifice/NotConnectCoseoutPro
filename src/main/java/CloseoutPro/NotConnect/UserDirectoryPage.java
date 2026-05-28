package CloseoutPro.NotConnect;

  
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserDirectoryPage {

    WebDriver driver;

    // Constructor
    public UserDirectoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators      Create User
    By directary = By.xpath("//a[@routerlink='/userdirectory']");
    By addBtn = By.xpath("//button[.=' Add User ']");
    By Name = By.xpath("//input[@placeholder='Enter full name']");
    By Mail = By.xpath("//input[@formcontrolname='email']");
    By Title = By.xpath("//input[@formcontrolname='designation']");
    By dropdown = By.xpath("//select[@formcontrolname='roleId']");
    By submit = By.xpath("//button[.=' Add ']");
    
    
    // Actions
    public void clickDirectary() {
        driver.findElement(directary).click();
    }

    public void addUser(String name, String mail, String title) {
        driver.findElement(addBtn).click();
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Mail).sendKeys(mail);
        driver.findElement(Title).sendKeys(title);        
        
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("2");
             
        driver.findElement(submit).click(); // Enable if needed
        
    }
    
    
    
    
    
    // parent locater
    By userList = By.xpath("//tr[@class='user-row ng-star-inserted']");
    
 // Get all user rows      Parent
    public List<WebElement> getUsersList() {
        return driver.findElements(userList);
    }
    
    
  // Edit User
      
    By editSubmit = By.xpath("//button[@class='btn-submit']");
            
  // Edit Action
    
    public void enterEditDetails(String name, String title) {
    	driver.findElement(Name).clear();
    	driver.findElement(Name).sendKeys(name);
    	driver.findElement(Title).clear();
    	driver.findElement(Title).sendKeys(title);
    	driver.findElement(editSubmit).click();
    	
    	
    }
    
    
    // Delete User
    
    By deleteYes = By.xpath("//button[.='Yes']");
    
    public void deleteUser() {
    	driver.findElement(deleteYes).click();
    }
    
    
    
    
}