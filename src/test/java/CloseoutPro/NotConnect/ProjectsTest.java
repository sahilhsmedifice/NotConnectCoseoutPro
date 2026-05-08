package CloseoutPro.NotConnect;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProjectsTest extends GlobalData {

	
    @Test    (priority = 1)
    public void Projects() {
        Initialize();
        LoginCredentials();
    }
	
    @Test          (enabled=false)             //    (priority=2)     
    public void createProject() throws InterruptedException {
    	
    	ProjectsPage add = new ProjectsPage(driver);  

    	Thread.sleep(3000);
    	add.createProject("806524", "NotConnect Automation Project", "Nagpur");
    	 	
    }
    
    
    @Test       (priority = 2)          //  (enabled=false)
    public void editProject() throws InterruptedException {
        ProjectsPage edit = new ProjectsPage(driver);

        Thread.sleep(3000);  
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

	@Test        (priority=3 )            //   (enabled=false)    //  (priority=4 )
    public void delete() throws InterruptedException {
    	
    	
		ProjectsPage delete = new ProjectsPage(driver);
		
		Thread.sleep(3000);  
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
    
	
	
	
	// need to restore project, perform delete project action on last
    
	@Test      (priority=4 )
    public void permanentDelete() throws InterruptedException {
    	
		ProjectsPage Pdelete = new ProjectsPage(driver);
		
		Pdelete.archiveClick();
		
		Thread.sleep(3000);  
        String desiredProjectName = "NotConnect Automation Project";
        List<WebElement> Projects = Pdelete.getProjectList();

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
				
	//	Pdelete.permanentDelete();	
	 
		
    }
    

}