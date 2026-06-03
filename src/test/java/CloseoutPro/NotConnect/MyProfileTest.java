package CloseoutPro.NotConnect;
 
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileTest extends GlobalData{
	
	@Test  (priority=1) 
	public void EditMyProfile() throws InterruptedException {
		
		Initialize();
		LoginCredentials();
			 
		Thread.sleep(3000);
		
		ProfileDropdown();
		 
		MyProfilePage profile = new MyProfilePage(driver);
		
		profile.ClickMyprofile();
		ProfileDropdown();
		Thread.sleep(2000);
		profile.ClickEditIcon();
		Thread.sleep(1000);
		profile.EnterData("Neeleshwari mule", "1234567890", "Tester");
		profile.SubmitButton();
		
 
		
		
	}
	
	
	@Test   (priority=2) 
	public void ChangePassword() throws InterruptedException {
		
		MyProfilePage password = new MyProfilePage(driver);
		
		Thread.sleep(1000);
		password.changePasswordBtn();
		password.enterCurrentPassword("Test@1234565");
		password.enterNewPassword("Test@1234");
		password.enterConfirmPassword("Test@1234");		
		
		password.changePassword();
		Thread.sleep(500);
		System.out.println( driver.findElement(By.id("swal2-title")).getText()  );
				 
	
		String passwordvalidate = password.getPasswordValidation();
		Assert.assertEquals(passwordvalidate, "Current Password does not match!");
		
		driver.close();
	
	
	}
	
	
	
	// Notification on and off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}