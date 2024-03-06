package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.PaymentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;

public class Payment {
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
	public void payWithEmptyCart() {
		// Test name: pay with empty cart
		Logger logger = LogManager.getLogger(Payment.class);
		logger.info("Pay with empty cart");
		driver.get("https://atid.store/cart-2");
		PaymentPage page = new PaymentPage(driver);
		logger.debug("Opened chrome - got into website");
		
		try {
			page.clickPay();
			logger.debug("TEST FAILED - Clicked 'Proceed to checkout' button");
		} catch (Exception e) {
			logger.debug("'TEST SUCCEEDED!' - No 'Proceed to checkout' button");
		}
	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));

		org.junit.runner.Result result = junit.run(Payment.class);

		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);

		}
	}
}