package pom_test_cases;

//Generated by Selenium IDE
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product to Empty cart");
		// Test name: add product to empty cart
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://atid.store/product/anchor-bracelet/");
		logger.debug("Opened chrome - got into website");
		// 2 | type | name=add-to-cart | click on it
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked add to cart button");
		// 3 | spanText | span in cart icon | getText
		String spanText = driver.findElement(By.xpath("//*[@id=\"ast-site-header-cart\"]/div[1]/a/div/span")).getText();

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
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product to non empty cart");
		// Test name: add products to non empty cart
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://atid.store/product/anchor-bracelet/");
		logger.debug("Opened chrome - got into website");
		// 2 | type | name=add-to-cart | click on it
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked add to cart button");

		driver.get("https://atid.store/product/atid-black-shoes/");
		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("3");
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked Add for 3 more items");

		// 3 | spanText | span in cart icon | getText
		String spanText = driver.findElement(By.xpath("//*[@id=\"ast-site-header-cart\"]/div[1]/a/div/span")).getText();

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
		Logger logger = LogManager.getLogger(AddProductToCart.class);
		logger.info("Add a product that already exist in the cart");
		// Test name: add a product that already exist in the cart
		// Step # | name | target | value
		// 1 | open | / |
		driver.get("https://atid.store/product/anchor-bracelet/");
		logger.debug("Opened chrome - got into website");
		// 2.1 | type | name=add-to-cart | click on it
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked add to cart button - first time");

		// 2.2 | type | name=add-to-cart | click on it
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked Add the same item again");

		// 3 | spanText | span in cart icon | getText
		String spanText = driver.findElement(By.xpath("//*[@id=\"ast-site-header-cart\"]/div[1]/a/div/span")).getText();

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