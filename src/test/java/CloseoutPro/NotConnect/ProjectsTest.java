package CloseoutPro.NotConnect;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTest extends GlobalData {

	
    @Test    (priority = 1)
    public void Projects() {
        Initialize();
        LoginCredentials();
    }
	
    @Test    (priority=2)     
    public void createProject() throws InterruptedException {
    	
    	ProjectsPage add = new ProjectsPage(driver);  

    	Thread.sleep(5000);
    	add.createProject("806524", "NotConnect Automation Project", "Nagpur");
    	 	
    }
    
    
    @Test       (priority = 3)     
    public void editProject() throws InterruptedException {
        ProjectsPage edit = new ProjectsPage(driver);

        Thread.sleep(10000);  
        String desiredProjectName = "806524 - NotConnect Automation Project";
        List<WebElement> Projects = edit.getProjectList();

        for (int i = 0; i < Projects.size(); i++) {
            WebElement Project = Projects.get(i);
            String ProjectName = Project.getText();

            if (ProjectName.contains(desiredProjectName)) {
               
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Project);
                Thread.sleep(500);  
                
                Project.findElement(By.xpath("./div/div[3]/div[2]/a[2]")).click();
                Thread.sleep(3000);
                break;
            }
        }
  
          edit.editProject("123", "NotConnect Automation Project", "Nagpur");
        
    }

	@Test        (priority=4)            //   (enabled=false)    
    public void delete() throws InterruptedException {
    	
    	
		ProjectsPage delete = new ProjectsPage(driver);
		
		Thread.sleep(5000);  
        String desiredProjectName = "NotConnect Automation Project";
        List<WebElement> Projects = delete.getProjectList();

        for (int i = 0; i < Projects.size(); i++) {
            WebElement Project = Projects.get(i);
            String UserName = Project.getText();

            if (UserName.contains(desiredProjectName)) {
               
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Project);
                Thread.sleep(500);  
                
                Project.findElement(By.xpath("./div/div[3]/div[2]/a[3]")).click();
                break;
            }
        }
  
           delete.deleteConfirm();         
           
    	
    }
    
	
	
	
	 
    
	@Test      (priority=5 )
    public void RestoreProject() throws InterruptedException {
    	
		ProjectsPage restore = new ProjectsPage(driver);
		
		Thread.sleep(2000);
		restore.archiveClick();
		
		Thread.sleep(5000);  
        String desiredProjectName = "NotConnect Automation Project";
        List<WebElement> Projects = restore.getProjectList();

        for (int i = 0; i < Projects.size(); i++) {
            WebElement Project = Projects.get(i);
            String UserName = Project.getText();

            if (UserName.contains(desiredProjectName)) {
               
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Project);
                Thread.sleep(500);  
                
                Project.findElement(By.xpath("./div/div[3]/div[2]/a[2]")).click();
                break;
            }
        }
				
        restore.restoreProject();	
	 
        Thread.sleep(5000);

        System.out.println(restore.getRestoreValidation());
		String restorevalidate = restore.getRestoreValidation();
		Assert.assertEquals(restorevalidate, "Restore!");
        
        
        
        
        
    }
    

}