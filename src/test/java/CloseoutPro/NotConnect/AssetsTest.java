package CloseoutPro.NotConnect;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssetsTest extends GlobalData {

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
    
		
	
	@Test  (priority = 2)
	public void createAsset() throws InterruptedException {
				
		AssetsPage add = new AssetsPage(driver);
		
		Thread.sleep(3000);
		add.clickAsset();
		Thread.sleep(1000);		
		add.clickCreate();		
		
		add.createAsset1("AutomationAsset1");
						
		 // Handle dynamic custom fields
	    add.fillCustomFields();
		
	    Thread.sleep(1000);
		add.clickCreateAsset();
					 
		
	}
	
	
	@Test (priority = 3)
	public void editAsset() throws InterruptedException {
		
		AssetsPage edit = new AssetsPage(driver);
		
		
		  Thread.sleep(3000);
		edit.clickEdit();
		  Thread.sleep(3000);
		edit.editasset("AutomationAsset1 Updated");
		
		 Thread.sleep(3000);
		String actualText = edit.getAssetName();		   
	    Assert.assertEquals(actualText, "AutomationAsset1 Updated"); 
		 
		
		
	}
	
	
	
	
	
//	@Test (priority = 4)
//	public void deleteAsset() throws InterruptedException {
//		
//		AssetsPage delete = new AssetsPage(driver);
//	
//	
//	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
