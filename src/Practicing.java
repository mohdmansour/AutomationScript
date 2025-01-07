import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.ThreadSafe;

public class Practicing {
	
	WebDriver driver = new ChromeDriver();
	String website = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void Setup() {
		
		driver.manage().window().maximize();
		driver.get(website);		
	}
	
	@Test(priority = 1, description = "Radio Button Test random", enabled = false)
	public void FirstTest() {
		
		List<WebElement> RadioButtons = driver.findElements(By.className("radioButton"));
		int RandomRadioButton = rand.nextInt(RadioButtons.size());
		RadioButtons.get(RandomRadioButton).click();
		
		
	}
	
	@Test(priority = 2, description = "Radio Button Test for loop", enabled = false)
	public void SecondTest() {
		
		List<WebElement> RadioButtons = driver.findElements(By.className("radioButton"));
		for(int i = 0; i < RadioButtons.size(); i++) {
			
			if(i == 2) {
				
				break;
				
			}
			
			RadioButtons.get(i).click();
		
		}
		
	}
	
	@Test(priority = 3, description = "Dynamic Dropdown Example", enabled = false)
	public void ThirdTest() throws InterruptedException {
		
		WebElement DynamicDropDown = driver.findElement(By.id("autocomplete"));
		String [] CountryCodes = {"fr", "ca", "jo", "om", "ru"};
		int RandomCountryCodes = rand.nextInt(CountryCodes.length);
		DynamicDropDown.sendKeys(CountryCodes[RandomCountryCodes]);
		Thread.sleep(1000);
		DynamicDropDown.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		
		
	}
	
	@Test(priority = 4, description = "Test Static Dropdown", enabled = false)
	public void FourthTest() {
		WebElement SelectOption = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(SelectOption);		
		sel.selectByIndex(3);
	}
	
	@Test(priority = 5, description = "Test Checkbox Example", enabled = false)
	public void FifthTest() {
		List<WebElement> Checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int RandomCheckBoxes = rand.nextInt(Checkboxes.size());
		Checkboxes.get(RandomCheckBoxes).click();
		
		
	}
	
	@Test(priority = 6, description = "Test Switch To Alert Example", enabled = false)
	public void SixthTest() throws InterruptedException {
		
		WebElement TextBox = driver.findElement(By.id("name"));
		WebElement AlertButton = driver.findElement(By.id("alertbtn")); 
		WebElement ConfirmButton = driver.findElement(By.id("confirmbtn"));
		
		TextBox.sendKeys("Mohammad");
		AlertButton.click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		
	}
	
	@Test(priority = 7, description = "window test", enabled = false)
	
    public void windows() {
		
		WebElement WindowButton = driver.findElement(By.id("openwindow"));
		WindowButton.click();
		
		List<String> WebHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(WebHandle.get(1));
		
		WebElement ContactButton = driver.findElement(By.id("menu-item-9680"));
		ContactButton.click();
		
		System.out.println(driver.getTitle() + " contact page");
		driver.close();

        driver.switchTo().window(WebHandle.get(0));
		
		
	}
	
	@Test(priority = 8, description = "tab test", enabled = false)
	public void Tabs() throws InterruptedException {
		
		WebElement TabButton = driver.findElement(By.id("opentab"));
		TabButton.click();
		
		List<String> TabsHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(TabsHandle.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + " youtube page");
		
		driver.close();
        driver.switchTo().window(TabsHandle.get(0));
		
		
	}
	
	@Test(priority = 9, description = "MtTest", enabled = false)
	public void SeventhTest() throws InterruptedException {
		
		WebElement TextBox = driver.findElement(By.id("name"));
		WebElement AlertButton = driver.findElement(By.id("alertbtn")); 
		WebElement ConfirmButton = driver.findElement(By.id("confirmbtn"));
		
		String [] Names = {"Ali", "Mohammad", "Ahmad", "Mazen"};
		
		for(int i = 0; i < Names.length; i++) {
			
			if(Names[i].startsWith("A")) {
				
				TextBox.sendKeys(Names[i]);
				Thread.sleep(1000);
				ConfirmButton.click();
				Thread.sleep(1000);
                driver.switchTo().alert().accept();
				
			}
			else {

				TextBox.sendKeys(Names[i]);
				Thread.sleep(1000);
				AlertButton.click();
				Thread.sleep(1000);
                driver.switchTo().alert().accept();
                
			}
				
			}	
			
		}
		
    @Test(priority = 10, description = "table")
    public void Table() {
    	
    	WebElement Table = driver.findElement(By.id("product"));
    	List <WebElement> Rows = Table.findElements(By.tagName("tr"));
    	
    	for(int i = 1; i< Rows.size(); i++) {
    		
    		int x = Rows.get(i).findElements(By.tagName("td")).size();
    		System.out.println(Rows.get(i).findElements(By.tagName("td")).get(x-1).getText());
    	}
    	
    	
    	//dont forget eno toktob why failed lama kanat ==0 
    }
		
		
	
	
	@AfterTest
	public void PostTest() {
		
		
		
		
	}
}
