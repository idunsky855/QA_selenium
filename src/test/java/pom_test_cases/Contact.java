package pom_test_cases;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.*;

public class Contact {
    private WebDriver driver;
    JavascriptExecutor js;
    private JSONArray cases;

    @Before
    public void setUp() throws IOException, ParseException {
        driver = TestBase.initializeDriver();
        js = (JavascriptExecutor) driver;

        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader;
            reader = new FileReader("ContactJson.json");
            // Read JSON file
            cases = (JSONArray) jsonParser.parse(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contactTest() {
        // Test name: Contact us

        Logger logger = LogManager.getLogger(Contact.class);
        logger.info("Contact us test");
        
        
        for (int i = 0; i < cases.size(); i++) {
            JSONObject obj = (JSONObject) cases.get(i);
            driver.get("https://atid.store/contact-us/");
            logger.info(String.format("On Contact us page - Test case %d", i + 1));
            ContactUsPage page = new ContactUsPage(driver);

            page.enterName((String) obj.get("name")); // name input
            page.enterSubject((String) obj.get("subject")); // subject input
            page.enterEmail((String) obj.get("email")); // email input
            page.enterMessage((String) obj.get("message")); // message input
            page.clickButton(); // Send message click button

            try {
                page.getElement((String) obj.get("expectedResult"));
                logger.info(String.format("'TEST SUCCEEDED!' - test case %d",i+1));
            } catch (Exception e) {
                logger.info(String.format("TEST FAILED! - test case %d",i+1));
            }

        }

        driver.quit();
    }

    public static void main(String args[]) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        org.junit.runner.Result result = junit.run(Contact.class);

        if (result.getFailureCount() > 0) {
            System.out.println("Test failed.");
            System.exit(1);
        } else {
            System.out.println("Test finished successfully.");
            System.exit(0);

        }
    }
}
