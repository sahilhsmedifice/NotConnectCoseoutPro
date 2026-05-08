package CloseoutPro.NotConnect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage {
	
	WebDriver driver;
	
	
	// constructer 
			public MyProfilePage(WebDriver driver) {	
			this.driver = driver;	
		}
	
	// locaters	
	By profile = By.xpath("//a[.=' My Profile']");	
	By EditIcon = By.xpath("//button[.=' Edit Profile ']");	
	By name = By.xpath("//input[@formcontrolname='name']");	
	By number = By.xpath("//input[@formcontrolname='mobileNo']");	
	By  designation = By.xpath("//input[@formcontrolname='designation']");	
	By address = By.xpath("//input[@formcontrolname='address']");
	By submit = By.xpath("//span[.='Submit']");
	 
	 
	//     methods
		
	public void ClickMyprofile() {
		driver.findElement(profile).click();
	}
	
	public void ClickEditIcon() {
		driver.findElement(EditIcon).click();
	}
	
	public void EnterData(String Name, String Number, String Desig) {
		
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(Name);
		driver.findElement(number).clear();
		driver.findElement(number).sendKeys(Number);
		driver.findElement(designation).clear();
		driver.findElement(designation).sendKeys(Desig);	
	}
	
	public void SubmitButton() {
		driver.findElement(submit).click();
	}
	
	

	
	// change password
	
	
	
	
	By changepass = By.xpath("//button[.=' Change Password ']");
	
	public void changePasswordBtn() {
		driver.findElement(changepass).click();
	}
	
	By current = By.xpath("//input[@formcontrolname='currentPassword']");
	By newpass = By.xpath("//input[@formcontrolname='newPassword']");
	By confirm = By.xpath("//input[@formcontrolname='confirmPassword']");
	By updateBtn = By.xpath("//span[.='Update Password']");
	By yes = By.xpath("//button[.='Yes']"); 
	
	public void enterCurrentPassword(String currentpassword) {
		
		driver.findElement(current).sendKeys(currentpassword);
	}
	
	public void enterNewPassword(String newPassword) {
		driver.findElement(newpass).sendKeys(newPassword);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(confirm).sendKeys(confirmPassword);
	}
	
	public void changePassword() {
		driver.findElement(updateBtn).click();
		driver.findElement(yes).click();
	}
	
	
	
	
	

}