package CloseoutPro.NotConnect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class specificationTest extends GlobalData {

	
	
	  @Test    (priority = 1)
	    public void Projects() {
	        Initialize();
	        LoginCredentials();
	    }
		
	    @Test     (priority=2)            // (priority=2)     //  (enabled=false)
	    public void getProject() throws InterruptedException {
	      
	    	Thread.sleep(2000);  
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
	    

	    @Test   (priority=3) 
	    public void AddSpecification() {
	    	
	    	specificationPage add = new specificationPage(driver);	    	
	    	add.addSpecification("1234", "Test Spec");	    	
	    	
	    }
	    
	    
//	    
//	    @Test     (priority=4) 
//	    public void EditSpecification() {
//	    
//	    
//	    	//.......code
//	    
//	    }
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    @Test  (priority=5) 
//	    public void uplaodSpecification() {
//	    	
//	    	
//	    	//.......code
//	    	
//	    	
//	    	
//	    }
//	    
	    
	    
	    
	    
	    
	    

}    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	 	
	    
	
	
	     
	
	