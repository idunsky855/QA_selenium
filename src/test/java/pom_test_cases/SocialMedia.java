package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import pages.AboutPage;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.*;

public class SocialMedia {
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
    public void facebook() {
        // Test name: go to facebook
        Logger logger = LogManager.getLogger(SocialMedia.class);
        logger.info("Go to Facebook");
        driver.get("https://atid.store/about/");
        logger.debug("Opened chrome - got into website to about page");
        AboutPage page = new AboutPage(driver);

        String currentURL = page.goToFacebook();
        logger.debug("Clicked Facebook button");

        if (currentURL.equals("https://atid.store/about/"))
            logger.debug("TEST FAILED - still on site");
        else
            logger.debug("'TEST SUCCEEDED!'");

    }

    @Test
    public void twitter() {
        // Test name: go to twitter
        Logger logger = LogManager.getLogger(SocialMedia.class);
        logger.info("Go to Twitter");
        driver.get("https://atid.store/about/");
        logger.debug("Opened chrome - got into website to about page");
        AboutPage page = new AboutPage(driver);

        String currentURL = page.goToTwitter();
        logger.debug("Clicked Twitter button");

        if (currentURL.equals("https://atid.store/about/"))
            logger.debug("TEST FAILED - still on site");
        else
            logger.debug("'TEST SUCCEEDED!'");

    }

    @Test
    public void instagram() {
        // Test name: go to instagram
        Logger logger = LogManager.getLogger(SocialMedia.class);
        logger.info("Go to Instagram");
        driver.get("https://atid.store/about/");
        logger.debug("Opened chrome - got into website to about page");
        AboutPage page = new AboutPage(driver);

        String currentURL = page.goToInstagram();
        logger.debug("Clicked Instagram button");

        if (currentURL.equals("https://atid.store/about/"))
            logger.debug("TEST FAILED - still on site");
        else
            logger.debug("'TEST SUCCEEDED!'");

    }

    @Test
    public void google() {
        // Test name: go to googlePlus
        Logger logger = LogManager.getLogger(SocialMedia.class);
        logger.info("Go to GooglePlus");
        driver.get("https://atid.store/about/");
        logger.debug("Opened chrome - got into website to about page");
        AboutPage page = new AboutPage(driver);

        String currentURL = page.goToGooglePlus();
        logger.debug("Clicked Google Plus button");

        if (currentURL.equals("https://atid.store/about/"))
            logger.debug("TEST FAILED - still on site");
        else
            logger.debug("'TEST SUCCEEDED!'");

    }





    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        org.junit.runner.Result result = junit.run(SocialMedia.class);

        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);

        }
    }
}