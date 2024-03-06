package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;
import io.github.sridharbandi.HtmlCsRunner;
import java.io.IOException;

public class Accessibility {
	private WebDriver driver;
	JavascriptExecutor js;
	private HtmlCsRunner htmlCsRunner;

	@Before
	public void setUp() {
		driver = TestBase.initializeDriver();
		js = (JavascriptExecutor) driver;
		htmlCsRunner = new HtmlCsRunner(driver);
	}

	@After
	public void tearDown() throws IOException {
		htmlCsRunner.execute();
		driver.quit();
		htmlCsRunner.generateHtmlReport();
	}

	@Test
	public void AccessibilityTest() {
		// Test name: Accessibility Test
		Logger logger = LogManager.getLogger(Accessibility.class);
		logger.info("Accessibility Test");

		driver.get("https://atid.store/");
		logger.debug("Opened chrome - got onto the website");
		logger.info("Generated Accessibility test files!! - under /target/java-a11y/htmlcs/ directory");
	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));

		org.junit.runner.Result result = junit.run(Accessibility.class);

		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);

		}
	}
}