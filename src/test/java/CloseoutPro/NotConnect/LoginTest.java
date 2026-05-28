package CloseoutPro.NotConnect;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class LoginTest extends GlobalData {

	
	@Test (priority = 1)
	public void WrongEmail(){	 
		Initialize();	
		LoginPage login = new LoginPage(driver);		
		 login.Login("neeleshwari@hsmedifice.com", "Neel@290501");		 		   
		 
		 System.out.println(login.getValidationMessage());
		 
	     Assert.assertEquals(login.getValidationMessage().trim(),"User Not found.");
		 
		 
	}
	
 
	
	   
	
	
//	 System.out.println(driver.findElement(By.cssSelector(".btn.btn-primary.login-btn.btn-error")).getText());
	
	
	
	@Test (priority = 2)
	public void WrongPassword() throws InterruptedException{
		
		LoginPage login = new LoginPage(driver);
	    Thread.sleep(2000);
		login.Login("neeleshwari.mule@hsmedifice.com", "Neel@2905");
	 
		
        System.out.println(login.getValidationMessage());
		 
	     Assert.assertEquals(login.getValidationMessage().trim(),"Invalid password.You have 4 attempts remaining");
		
		
	}
		 
	 
	@Test  (priority = 3)
	public void ValidCredentials() throws InterruptedException {	
		LoginPage login = new LoginPage(driver);
		Thread.sleep(2000);
		login.Login("neeleshwari.mule@hsmedifice.com", "Neel@290501");
		
		System.out.println(login.getProjectList());		 
	     Assert.assertEquals(login.getProjectList().trim(),"PROJECTS");	     
	     
	  driver.close();
	     
	     
	     
	     
	}
	
	
	
	
	
	
	
	
	
}