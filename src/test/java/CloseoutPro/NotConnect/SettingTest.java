package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SettingTest extends GlobalData{

	
	/* scope of setting automation
	   
	    closeout setting - add, edit, delete type
	    phase setting -- add , edit, delete phase		
	
	 */
	
	
	
	 @Test(priority = 1)
	    public void Settings() throws InterruptedException {

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
	
	
	
	
	 @Test   (priority = 2)
	    public void createCloseoutType() throws InterruptedException {
	
		 SettingPage add = new SettingPage(driver);
	
		 Thread.sleep(3000);
		 add.clickSettings();
		 Thread.sleep(3000);
		 add.gotoCloseoutSetting();
		 Thread.sleep(3000);
		 add.addCloseoutType("CloseoutTypeAutomation");
		 
		 
		 
		 
		 
	 }
	
	
	 @Test        (priority = 3)
	    public void upadteCloseoutType() throws InterruptedException {
		 
		 SettingPage update = new SettingPage(driver);
		 Thread.sleep(3000);
		 update.updateCloseoutType("CloseoutTypeAutomationUpdated");
		  
	
	 }
	
	 @Test        (priority = 4)
	    public void deleteCloseoutType() throws InterruptedException {
	 
		 SettingPage delete = new SettingPage(driver);
		 Thread.sleep(3000);
		 delete.deleteCloseoutType();
		 
		 
		 
	 }
	
	
	
	// phase setting 
	 

	 @Test     (priority = 5)
	    public void createPhase() throws InterruptedException {
	 
		 SettingPage createphase = new SettingPage(driver);
		 
		 Thread.sleep(5000);
		 createphase.clickPhaseSetting();
		 Thread.sleep(3000);
		 createphase.onffToggle();
		 Thread.sleep(3000);
		 
		 createphase.createPhase();
		  
	  
		 
	 }
	
	  
	 
	 @Test     (priority = 6)
	    public void updatePhase() throws InterruptedException {
	 
		 SettingPage editphase = new SettingPage(driver);
		 Thread.sleep(4000);
		 		 
		 editphase.updatePhase();
		  
		 
	 }
	
	 
	 @Test     (priority = 7)
	    public void deletePhase() throws InterruptedException {
	 
		 SettingPage deletephase = new SettingPage(driver);
		 Thread.sleep(4000);		 		 
 
		 deletephase.deletePhase();
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
}
