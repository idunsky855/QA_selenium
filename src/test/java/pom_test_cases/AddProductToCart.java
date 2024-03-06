package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProductPage;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;

public class AddProductToCart {
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
	public void addProductTest() {
		// Test name: add product to empty cart
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product to Empty cart");
		driver.get("https://atid.store/product/anchor-bracelet/");
		ProductPage page = new ProductPage(driver);
		
		logger.debug("Opened chrome - got into website");
		
		page.clickAddToCart();
		logger.debug("Clicked add to cart button");

		String spanText = page.getCartIconText();

		String res;
		if (spanText.equals("1")) {
			res = "'TEST SUCCEEDED!' - cart items count icon changed to 1";
		} else {
			res = "TEST FAILED! - cart items count icon DID NOT change to 1";
		}
		logger.info(res);
	}

	@Test
	public void addMoreProducts() {
		// Test name: add products to non empty cart
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product to non empty cart");
		driver.get("https://atid.store/product/anchor-bracelet/");
		ProductPage page = new ProductPage(driver);

		logger.debug("Opened chrome - got into website");
		page.clickAddToCart();
		logger.debug("Clicked add to cart button");

		driver.get("https://atid.store/product/atid-black-shoes/");
		page = new ProductPage(driver);

		WebElement quantity = page.getQuantityElement();
		quantity.clear();
		quantity.sendKeys("3");
		page.clickAddToCart();
		logger.debug("Clicked Add for 3 more items");
		
		String spanText = page.getSpanText();
		String res;
		if (spanText.equals("4")) {
			res = "'TEST SUCCEEDED!' - cart items count icon changed to 4";
		} else {
			res = "Test FAILED! - cart items count icon DID NOT change to 4";
		}
		logger.info(res);

	}

	@Test
	public void addTheSameProduct() {
		// Test name: add a product that already exist in the cart
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product that already exist in the cart");
		driver.get("https://atid.store/product/anchor-bracelet/");
		ProductPage page = new ProductPage(driver);

		logger.debug("Opened chrome - got into website");
		
		page.clickAddToCart();;
		logger.debug("Clicked add to cart button - first time");

		page.clickAddToCart();
		logger.debug("Clicked Add the same item again");

		String spanText = page.getSpanText();

		String res;
		if (spanText.equals("2")) {
			res = "'TEST SUCCEEDED!' - cart items count icon changed to 2";
		} else {
			res = "TEST FAILED! - cart items count icon DID NOT change to 2";
		}
		logger.info(res);
	}

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));

		org.junit.runner.Result result = junit.run(AddProductToCart.class);

		if (result.getFailureCount() > 0) {
			System.out.println("Test failed.");
			System.exit(1);
		} else {
			System.out.println("Test finished successfully.");
			System.exit(0);

		}
	}
}