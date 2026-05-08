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
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloseoutTest extends GlobalData{

	 
/*
	
	  goto closeout - add closeout 
	                  goto detail page 
	                  upload attachment - approve and reject validate
	                  edit                   
	                  add comment and validate
	                  delete item and validate in Archive and 
	                  permanent delete
	 
	goto warranty  - add - edit - upload - delete
	
	
	 
*/
	
	
	
    @Test    (priority = 1)
    public void Projects() throws InterruptedException {
        Initialize();
        LoginCredentials();
        
        
        Thread.sleep(5000);
		String desiredProjectName = "123 - NotConnect Automation Project";
		List<WebElement> Projects = getProjectList();

		for (int i = 0; i < Projects.size(); i++) {
			WebElement Project = Projects.get(i);
			String UserName = Project.getText();

			if (UserName.contains(desiredProjectName)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Project);
				Thread.sleep(500);
				Project.click();
				break;
			}
		}
       
    }  
    
    
        
//		@Test  (priority = 2)
//		public void createCloseout() throws InterruptedException {
//
//			CloseoutPage add = new CloseoutPage(driver);
//  
//			add.clickCloseout();
//			// enter name and spec
//			add.enterNameWithSpec("Automation Closeout 1");
//			add.submitTypeAndDate();
//					
//			
//		}
		
		
		
		@Test    (priority = 2)
		public void ApproveCloseout() throws InterruptedException, AWTException {
			 
			CloseoutPage status = new CloseoutPage(driver);
			 
			Thread.sleep(30000);
			status.clickCloseout();                                  // comment code while integrate all classes

			Thread.sleep(4000);
			String desiredCloseoutName = "Automation Closeout 1";                             // always check name add and edit should same
			List<WebElement> closeouts = status.getCloseoutList();

			for (int i = 0; i < closeouts.size(); i++) {
				WebElement closeout = closeouts.get(i);
				String ItemName = closeout.getText();
				if (ItemName.contains(desiredCloseoutName)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", closeout);
					Thread.sleep(3000);

					closeout.click();
					break;
				}
			}			 
			 

		    // 🔽 Small scroll down (adjust value if needed)
		    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

		    Thread.sleep(1000);
 			
		    driver.findElement(By.xpath("//button[.='Choose Files']")).click();

		 //  Wait properly (popup needs time)
		 Thread.sleep(3000);

		 // Bring focus to file dialog (VERY IMPORTANT)
		 Robot robot = new Robot();
		 robot.delay(1000);

		 // copy file path
		 StringSelection file = new StringSelection("C:\\File Types\\spec 03 mcel pob.pdf");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		 // CTRL + V (paste)
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);

		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);

		 // small delay before enter
		 robot.delay(1000);

		 // press ENTER
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(3000);
		    		     
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
		    WebElement approveElement = wait.until(
		        ExpectedConditions.visibilityOf(status.getApproveStatus())
		    );	
		    String actualText = approveElement.getText().trim();
		   
		    Assert.assertEquals(actualText, "Approved");  
		    		 	
		}
		
	 
		
		
		
		@Test(priority = 3)
		public void RejectCloseout() throws InterruptedException {
		
			 CloseoutPage reject = new CloseoutPage(driver);
		
		      reject.clickReject();
		
			 Thread.sleep(3000);
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
			 WebElement rejectElement = wait.until(
				        ExpectedConditions.visibilityOf(reject.getRejectStatus())
				    );	
				    String actualText = rejectElement.getText().trim();
				   
				    Assert.assertEquals(actualText, "Rejected"); 		   
		            
		}
		
		
		@Test (priority = 4)
		public void Comments() throws InterruptedException {
			
			CloseoutPage comment = new CloseoutPage(driver);
			Thread.sleep(3000);
			comment.enterText("script comment 1");
			// need to add implicit wait till 
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.cssSelector(".swal2-title")).getText());
			
			
//			getCommentValidation
			 
			String actualText2 = comment.getTooltipValidation();
			Assert.assertEquals(actualText2, "Comment added successfully.");			
			
		}
		
		 
		
	
		@Test(priority = 6)
		public void UpdateStatus() throws InterruptedException {

		    CloseoutPage edit = new CloseoutPage(driver);
		    Thread.sleep(3000);
 // add scroll up
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		    Thread.sleep(1000);
 
			edit.enterItemAndDescription("Automation Closeout 1-Updated", "Description Testing ");			
			Thread.sleep(2000);				    
		    		    
			System.out.println(driver.findElement(By.cssSelector(".swal2-title")).getText());			
			String actualText2 = edit.getTooltipValidation();
			Assert.assertEquals(actualText2, "Closeout Item Updated Successfully.");
				  					
			
		}
		
		
//		@Test  (priority = 7)
//		public void deleteRestoreCloseout() {
//			
//			  CloseoutPage restore = new CloseoutPage(driver);
//			
//			
//			
//			
//		}
		
		
		
		
		
		
		
		
		
		
		
		 
		
		
		
		 
	 
	
}
