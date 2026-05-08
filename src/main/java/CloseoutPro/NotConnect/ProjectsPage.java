package CloseoutPro.NotConnect;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage {

	
	WebDriver driver;
	
	// constructer
	 public ProjectsPage(WebDriver driver) {
	        this.driver = driver;
	    }
	
	
// location	       Add project
	 By addBtn = By.id("addProjectBtn");	 
	 By addProject = By.xpath("//button[.=' Add Project ']");	 
	 By num = By.xpath("//input[@formcontrolname='projectNumber']");
	 By Name = By.xpath("//input[@formcontrolname='projectName']");
	 By loc = By.xpath("//input[@formcontrolname='address']");
	 By submit = By.xpath("//button[.=' Create Project ']");
	 
	 
	 
	 public void createProject(String number, String name, String location) {
		 driver.findElement(addBtn).click();
		 driver.findElement(addProject).click();
		 driver.findElement(num).sendKeys(number);
		 driver.findElement(Name).sendKeys(name);
		 driver.findElement(loc).sendKeys(location);
		 driver.findElement(submit).click();
	 }
	 
	 
	
// Edit project      locaters
	 	 
	// Parent  Contains all projects name  
	    By projectList = By.xpath("//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mb-4 ng-star-inserted']");
	    public List<WebElement> getProjectList() {
	        return driver.findElements(projectList);
	    }
	 
	 
	 // use common locater from add
	 By editSubmit = By.xpath("//button[.=' Update Project ']");	
	 
	 public void editProject(String number, String name, String location) {
		 driver.findElement(num).clear();
		 driver.findElement(num).sendKeys(number);
		 driver.findElement(Name).clear();
		 driver.findElement(Name).sendKeys(name);
		 driver.findElement(loc).clear();
		 driver.findElement(loc).sendKeys(location);
		 driver.findElement(editSubmit).click();
	 }
	 
	 
// delete project
	 
	 
	 By confirm = By.xpath("//button[.='Yes, delete it!']");
	  
	 public void deleteConfirm() {
		 driver.findElement(confirm).click();	 
	 }
	 
	 
	 
	 
	 
// permanent delete	 
	 
	 
	 By archive = By.xpath("//span[.='Archived']");
//	 By restore = By.xpath("(//i[@class='fa fa-refresh text-primary'])[2]");
//	 By resConfirm = By.cssSelector(".swal2-confirm.swal2-styled");\
	 
	 By DeleteConfirm  = By.xpath("//button[.='Yes']");
	 
	 
	 public void archiveClick () {
		driver.findElement(archive).click();
 
	 }
	 
	 
	 public void permanentDelete() {
		 driver.findElement(DeleteConfirm).click();
	 }
	 
	 
	 
	 
	  
	 
	 
	 
	 
	
	
}