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
		Logger logger = LogManager.getLogger(RemoveProductFromCart.class);
		logger.info("Remove existing product from cart");
		// Test name: Remove existing product from cart
		// Step # | name | target | value
		// 1 | open | / |
        driver.get("https://atid.store/product/anchor-bracelet/");
		logger.debug("Opened chrome - got into website");
		// 2 | type | name=add-to-cart | click on it
		driver.findElement(By.name("add-to-cart")).click();
		logger.debug("Clicked add to cart button");

        driver.get("https://atid.store/cart-2/");
        
        driver.findElement(By.xpath("//*[@id=\"post-39\"]/div/div/section[2]/div/div/div/div/div/div/div/form/table/tbody/tr[1]/td[1]/a")).click();
        logger.debug("Clicked remove item from cart");
        
        try{
		Thread.sleep(2000);
        
            // 3 | click |  by xpath | click on it
		driver.findElement(By.xpath("//*[@id=\"post-39\"]/div/div/section[2]/div/div/div/div/div/div/div/div[2]/div/div/a")).click();
		logger.debug("TEST FAILED - Clicked 'Proceed to checkout' button = the cart is not empty");

        Thread.sleep(2000);
        }catch(Exception e){
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