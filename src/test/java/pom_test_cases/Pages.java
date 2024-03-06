package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;

public class Pages {
	private WebDriver driver;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = TestBase.initializeDriver();
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void GoToNextPage() {
		Logger logger = LogManager.getLogger(Pages.class);
		logger.info("Go to next page from first page");
		// Test name: Go to next page from first page
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://atid.store/store");
		logger.debug("Opened chrome - got into website on store first page");

		// 2 | click | by xpath | click on it
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav[2]/ul/li[2]/a")).click();
		String currentURL = driver.getCurrentUrl();

		logger.info(currentURL);
		if (currentURL.equals("https://atid.store/store/page/2/")) {
			logger.debug("'TEST SUCCEEDED!' - we're on the 2nd page");
		} else {
			logger.debug("TEST FAILED - Current URL does not match 2nd page");
		}
	}

	@Test
	public void GoToPreviousPage() {
		Logger logger = LogManager.getLogger(Pages.class);
		logger.info("Go to previous page from 2nd page");
		// Test name: Go to next page from first page
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://atid.store/store/page/2/");
		logger.debug("Opened chrome - got into website on store 2nd page");

		// 2 | click | by xpath | click on it
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav[2]/ul/li[1]/a")).click();
		String currentURL = driver.getCurrentUrl();

		logger.info(currentURL);
		if (currentURL.equals("https://atid.store/store/")) {
			logger.debug("'TEST SUCCEEDED!' - we're on the 1st page");
		} else {
			logger.debug("TEST FAILED - Current URL does not match 1st page");
		}
	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));

		org.junit.runner.Result result = junit.run(Pages.class);

		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);

		}
	}
}