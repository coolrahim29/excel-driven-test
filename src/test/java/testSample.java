import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testSample {

	@Test
	public void seleniumTest() throws IOException, InterruptedException {

		// Instantiate driver, wait and path for chrome browser jar file

		dataDriven d = new dataDriven();
		ArrayList navigate = d.getData("Navigate");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.manage().window().maximize();

		// get data from excel sheet to a variable

		String firstname = (String) navigate.get(2);
		String lastname = (String) navigate.get(3);
		String emailid = (String) navigate.get(4);
		String password = (String) navigate.get(5);
		String option1 = (String) navigate.get(6);
		String option2 = (String) navigate.get(7);
		String option3 = (String) navigate.get(8);

		// fill up the first sign in page

		driver.get((String) navigate.get(1));
		driver.findElement(By.xpath("//*[@id=\"form-sign-up\"]/label[1]/input")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"form-sign-up\"]/label[2]/input")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"form-sign-up\"]/label[3]/input")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id=\"form-sign-up\"]/label[4]/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"form-sign-up\"]/button")).click();
		// Thread.sleep(10000);

		// navigate to second page wait for page to load and select further data.

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/span/select")));
		Select dropdown1 = new Select(driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/span/select")));
		dropdown1.selectByVisibleText(option1);

		Select dropdown2 = new Select(driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[2]/span/select")));
		dropdown2.selectByVisibleText(option2);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[3]/button")).click();

		// navigate to third page wait for page to load and select further data.

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/span/select")));

		Thread.sleep(5000);
		Select dropdown3 = new Select(driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/span/select")));
		dropdown3.selectByVisibleText(option3);

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[2]/fieldset/div/div[2]/div"))
				.click();

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[3]/fieldset/div/div[1]/div/label"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[4]/div[2]/button"))
				.click();

		// navigate to fourth page wait for page to load and select further data.

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/fieldset/div/div[3]/div")));

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/fieldset/div/div[3]/div"))
				.click();

		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[2]/fieldset/div/div/div[3]/div"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[3]/div[2]/button"))
				.click();

		// navigate to fifth page wait for page to load and select further data.

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/fieldset/div/div[1]/div")));

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[1]/fieldset/div/div[1]/div"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/form/div[2]/div[2]/button"))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]")));

		// navigate to last page wait for page to load and assert that sign up was
		// successful and then end Test case with quitting.

		// Thread.sleep(5000);
		String str = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]")).getText();

		assertTrue(str.contains(firstname));

		driver.quit();
	}

}