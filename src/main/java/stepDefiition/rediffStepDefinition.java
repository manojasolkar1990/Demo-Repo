package stepDefiition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class rediffStepDefinition {
	WebDriver driver;
	@Given("^user is on rediff home Page$")
	public void user_is_on_rediff_home_Page(){
		System.setProperty("WebDriver.Gecko.Driver", "C:/Users/admin/Desktop/Java/New/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	
	@When("^user select groupZ under loser weekly tab$")
	public void user_select_groupZ_under_loser_weekly_tab() throws Throwable {
		driver.findElement(By.xpath("//h2[contains(text(),'Losers')]//following::a[text()='Weekly']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Group Z')]")).click();
	}

	@Then("^user is reading table data$")
	public void user_is_reading_table_data() throws Throwable {
		//no of rows
		List<WebElement> rows =	driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		int row_size =rows.size();
		
		System.out.println("no of rows is :" +row_size);
		for(int i=0;i<row_size;i++){
			
			// no of column
			List<WebElement> col = rows.get(i).findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
			int col_size = col.size();
			
			System.out.println("num of cell in row" + i + "are" +col_size );
			
			for(int j=0; j<col_size;j++){
				String value = col.get(j).getText();
				System.out.println(value);
			}
	
		} 
	}

	@Then("^user store table data into hashmap$")
	public void user_store_table_data_into_hashmap() throws Throwable {
	    
	}

	@Then("^user store map data into excel data$")
	public void user_store_map_data_into_excel_data() throws Throwable {
	    
	   
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	   driver.close();
	   
	}


}

