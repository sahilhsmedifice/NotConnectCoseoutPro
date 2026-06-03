package CloseoutPro.NotConnect;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class specificationTest extends GlobalData {

	
	
	  @Test    (priority = 1)
	    public void Specifications() throws InterruptedException {
	        Initialize();
	        LoginCredentials();
	   
	      	Thread.sleep(10000);  
	      	
	        String desiredProjectName = "123 - NotConnect Automation Project";
	        List<WebElement> Projects =  getProjectList();

	        for (int i = 0; i < Projects.size(); i++) {
	            WebElement Project = Projects.get(i);
	            String UserName = Project.getText();

	            if (UserName.contains(desiredProjectName))  {
	               
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Project);
	                Thread.sleep(500);  
	                
	                Project.click();
	                break;
	             }
	         }
	   }
	    

	    @Test  (priority=2) 
	    public void AddSpecification() {
	    	
	    	specificationPage add = new specificationPage(driver);	    	
	    	add.addSpecification("1234", "Test Spec");	    	
	    	 
	    }
	    
	    
	    
	    @Test     (priority=3) 
	    public void UploadSpecification() throws InterruptedException, AWTException {
	  	
	    	specificationPage upload = new specificationPage(driver);	
	    	    	
	    Thread.sleep(4000);	
	    	 
	    	upload.uploadspec();
	    		    	     	
          Thread.sleep(2000);
 			
		    driver.findElement(By.xpath("//ngx-dropzone-label[.='Drag and Drop']")).click();

		 //  Wait properly (popup needs time)
		 Thread.sleep(5000);

		 // Bring focus to file dialog (VERY IMPORTANT)
		 Robot robot = new Robot();
		 robot.delay(3000);

		 // copy file path
		 StringSelection file = new StringSelection("C:\\File Types\\spec 03 mcel pob.pdf");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		 // CTRL + V (paste)
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);

		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);

		 // small delay before enter
		 robot.delay(3000);

		 // press ENTER
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(3000);
	    	    
		 upload.clickSave();
		  
	    }
	    
	    
	    
	    
	     
	    
	    
	    

}    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	 	
	    
	
	
	     
	
	