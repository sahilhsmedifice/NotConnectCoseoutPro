package CloseoutPro.NotConnect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	 WebDriver driver;
		
		// constructer
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
		
		
		//Locater
	    
	     By email = By.xpath("//input[@placeholder='alex@email.com']");
	     By password = By.xpath("//input[@placeholder='Enter your password']");
	   	 By LoginBtn = By.cssSelector(".btn-text.ng-star-inserted");
	   	 
	   	 
	   	 
	   	 
	   	 // Methods 
	   	 
	   	 public void  Login(String mail, String Password ) {
	   		 
	   	  	 driver.findElement(email).clear();
	   		 driver.findElement(email).sendKeys(mail);	 
	   		 driver.findElement(password).clear();
	   		 driver.findElement(password).sendKeys(Password);	 
	   		 driver.findElement(LoginBtn).click();
	   		 
	   		 
	   	 }
	   	 
	
	   By errorMessage = By.cssSelector(".btn.btn-primary.login-btn.btn-error");
	   	public String getValidationMessage() {
	        return driver.findElement(errorMessage).getText();
	    }
	   	
	   	

	 By validateProject = By.id("project_title");
	 
		public String getProjectList() {
		      return driver.findElement(validateProject).getText();
		  }
	   	 
	   	 
	   	 
	   	 
	   	 
	 
	
	
	
	
	
	
}
