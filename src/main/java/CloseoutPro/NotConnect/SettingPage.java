package CloseoutPro.NotConnect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingPage {


	WebDriver driver;

	// constructer
	public SettingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By settings = By.id("menu9");
	
	public void clickSettings() {
		driver.findElement(settings).click();
	}
	
	
	
	By projectsetting =  By.xpath("//span[.='Project Settings']");
	By closeoutsetting = By.xpath("//div[.=' Closeout Setting ']");
	
	public void gotoCloseoutSetting() {
		driver.findElement(projectsetting).click();
		driver.findElement(closeoutsetting).click();
	}
	
	
	// add type
	
	By addtype = By.xpath("//button[.=' Add Type ']");
	By typename = By.xpath("//input[@formcontrolname='title']");
	By addbtn = By.xpath("//button[.=' Add ']");
	
	public void addCloseoutType(String TypeName) {
		driver.findElement(addtype).click();
		driver.findElement(typename).sendKeys(TypeName);
		driver.findElement(addbtn).click();
		 
	}
	
	
	
	// update type
	
	By updatebtn = By.cssSelector(".fa.fa-pencil.text-primary");
	By updatefield = By.xpath("//input[@formcontrolname='title']");
	By update = By.xpath("//button[@class='btn-create']");
	
	public void updateCloseoutType(String UpdateType) {
		driver.findElement(updatebtn).click();
		driver.findElement(updatefield).clear();
		driver.findElement(updatefield).sendKeys(UpdateType);
		driver.findElement(update).click();
	}
	
	
	// delete type 
	
	By delete = By.cssSelector(".fa.fa-trash-o.text-primary");	
	By yesdelete =  By.xpath("//button[.='Yes, delete it!']");
	
	public void deleteCloseoutType() {
		driver.findElement(delete).click();
		driver.findElement(yesdelete).click();
	}
	
	
	// phase setting
	
	
	By phasesetting = By.xpath("//button[.='Phase Settings']");	
	
	
	public void clickPhaseSetting() {
		driver.findElement(phasesetting).click();
	}
	 
	
	By toggle = By.cssSelector(".rect-slider");	
	
	public void onffToggle() {
		driver.findElement(toggle).click();
	}	
	
	By createphase = By.xpath("//button[.=' Create Phase ']");	
	By phasename = By.xpath("//input[@formcontrolname='PhaseName']");
	By phasedescription = By.xpath("//input[@formcontrolname='Description']");
	
	By completiondate = By.xpath("//input[@formcontrolname='CompletionDate']");
	By previousmonth = By.xpath("//span[.='‹']");
	By dateselect = By.xpath("(//span[.='1'])[1]");
	
	
	
	By createphase2 = By.xpath("(//button[.=' Create Phase '])[2]");
	By backbutton = By.xpath("//button[@class='back-btn']");
	
	public void createPhase() throws InterruptedException {
		driver.findElement(createphase).click(); 
		Thread.sleep(2000);
		driver.findElement(phasename).sendKeys("Automation phase");  
		driver.findElement(phasedescription).sendKeys("Automation phase description"); 
		
		driver.findElement(completiondate).click();
		Thread.sleep(1000);
		driver.findElement(previousmonth).click();
		Thread.sleep(1000);
		driver.findElement(dateselect).click();
		Thread.sleep(1000);
		
		
		driver.findElement(createphase2).click();
		driver.findElement(backbutton).click();
	}	
	
		
	// edit delete phaase
	 
	By editbtn =  By.cssSelector(".fa.fa-pencil");
	By updatephasebtn = By.xpath("//button[.=' Update Phase ']");
	
	public void updatePhase() {
		driver.findElement(editbtn).click(); 
		driver.findElement(phasename).clear();
		driver.findElement(phasename).sendKeys("Automation phase-Updated");  	 
		driver.findElement(updatephasebtn).click();
		 
	}	
	
	
	
	// delete phase
	
	By deletephase = By.cssSelector(".fa.fa-trash-o");
	By yesdeletephase = By.xpath("//button[.='Yes, delete it!']");
	
	public void deletePhase(){
		driver.findElement(deletephase).click();
		driver.findElement(yesdeletephase).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
