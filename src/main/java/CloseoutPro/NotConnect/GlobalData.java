package CloseoutPro.NotConnect;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalData {
	 
public static WebDriver driver;

	public void Initialize() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://web.closeout-pro.com/login");      // Production
		
//		driver.get("https://mongoweb.closeout-test.in/login");  //  Test
	 
		
	}
	
	
	public void LoginCredentials() {	
		LoginPage login = new LoginPage(driver);
		login.Login("Neeleshwari.mule@hsmedifice.com", "Neel@290501");		
	 
		driver.findElement(By.xpath("(//button[.=' Cancel '])[1]")).click();
	}
	
	
	
	
	public void selectCompany() {		
		driver.findElement(By.xpath("//label[.='HSM Contech']")).click();
		driver.findElement(By.xpath("//button[.=' Update ']")).click();				 
		
	}
	
	
	 
	public void ProfileDropdown() {
		driver.findElement(By.cssSelector(".fa.fa-angle-down")).click();
		
	}
	
	 
	
//	// Parent Contains all projects name
//	By projectList = By.xpath("//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mb-4 ng-star-inserted']");
//
//	public List<WebElement> getProjectList() {
//		return driver.findElements(projectList);
//	}

	 
	By projectList = By.xpath("//div[@class='col-12 col-sm-6 col-lg-4 col-xl-3 mb-4 ng-star-inserted']");

	public List<WebElement> getProjectList() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(projectList));

	    return driver.findElements(projectList);
	}
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void selectProject() throws InterruptedException{
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



