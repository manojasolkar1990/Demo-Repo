package stepDefiition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class amazonStepDefinition {
	
	WebDriver driver;
	
	@Given("^user is Flipcart login Page$")
	public void user_is_Flipcart_login_Page(){
		System.setProperty("WebDriver.Gecko.Driver", "C:/Users/admin/Desktop/Java/New/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	
	@When("^user_enter_username_and_password$")
	public void user_enter_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("0123manoj.asolkar@gmail.com");
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Manoj@1990");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		driver.manage().window().maximize();
	}

	@Then("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		String Title =driver.getTitle();
		System.out.println("Title of flipcart is:"+Title);
		     
	}

	@Then("^user search items \"([^\"]*)\" and add item to cart$ ")
	public void user_search_items_and_add_item_to_cart(String item1) throws Throwable {
		driver.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys(item1);
		driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[1]/div[1]/div/div/img")).click();
		driver.findElement(By.xpath("//button[contains(@class,'_2AkmmA _2Npkh4 _2MWPVK')]")).click();
	}

	@Then("^user remove item from cart$")
	public void user_remove_item_from_cart() throws Throwable {
	   driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/a/div/span")).click();
	   driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/span")).click();
	  String text = driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div/div/div[3]/span")).getText();
	  Assert.assertEquals(text, "Your Shopping Cart is empty");
	  
	}

	@Then("^user update shiping address$")
	public void user_update_shiping_address() throws Throwable {
		WebElement target =driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/div/div/div/div/span/div"));
		Actions act= new Actions(driver);
		act.moveToElement(target).perform();
		driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/a[2]/div")).click();
	     driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]")).click();
	     driver.findElement(By.xpath("//input[contains(@name,'pincode')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@name,'pincode')]")).sendKeys("411058");
	     driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	}


}
