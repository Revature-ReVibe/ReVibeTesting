package gluecode;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * This file is called a "Step Definition File". It contains what we refer to as a "Gluecode". Gluecode is
 * the code that is generated for us via Cucumber.
 */
public class Gluecode {
	
	private static WebDriver driver;

	@Given("the user is on the home page")
	public void a_user_is_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Navigate to the home page
		driver.get("http://localhost:4200/");
	}

	@Then("the user is redirected to the profile page")
	public void the_user_is_redirected_to_the_profile_page() {
		Assert.assertEquals("http://localhost:4200/account", driver.getCurrentUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	@When("the user clicks the profile button")
	public void i_click_submit() {
		WebElement profileButton = driver.findElement(By.id("profile"));
		profileButton.click();
	}
}
