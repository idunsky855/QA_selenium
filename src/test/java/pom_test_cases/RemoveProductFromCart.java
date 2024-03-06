package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.ProductPage;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;

public class RemoveProductFromCart {
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
	public void removeExistingProductFromCart() {
		// Test name: Remove existing product from cart
		Logger logger = LogManager.getLogger(RemoveProductFromCart.class);
		logger.info("Remove existing product from cart");
		driver.get("https://atid.store/product/anchor-bracelet/");
		logger.debug("Opened chrome - got into website");
		ProductPage prodPage = new ProductPage(driver);

		prodPage.clickAddToCart();
		logger.debug("Clicked add to cart button");

		driver.get("https://atid.store/cart-2/");
		CartPage cartPage = new CartPage(driver);

		cartPage.clickRemove();
		logger.debug("Clicked remove item from cart");

		try {
			cartPage.proceedToCheckout();
			logger.debug("TEST FAILED - Clicked 'Proceed to checkout' button = the cart is not empty");
		} catch (Exception e) {
			logger.debug("'TEST SUCCEEDED!' - No 'Proceed to checkout' button = the cart is empty");
		}
	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));

		org.junit.runner.Result result = junit.run(RemoveProductFromCart.class);

		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);

		}
	}
}