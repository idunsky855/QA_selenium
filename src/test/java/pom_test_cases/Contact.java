package pom_test_cases;

//Generated by Selenium IDE
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
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

            driver.findElement(By.xpath("//*[@id=\"wpforms-15-field_0\"]")).sendKeys((String) obj.get("name")); // name
                                                                                                                // input
            driver.findElement(By.xpath("//*[@id=\"wpforms-15-field_5\"]")).sendKeys((String) obj.get("subject")); // subject
                                                                                                                   // input
            driver.findElement(By.xpath("//*[@id=\"wpforms-15-field_4\"]")).sendKeys((String) obj.get("email")); // email
                                                                                                                 // input
            driver.findElement(By.xpath("//*[@id=\"wpforms-15-field_2\"]"))
                    .sendKeys((String) obj.get("message")); // message input
            driver.findElement(By.xpath("//*[@id=\"wpforms-submit-15\"]")).click(); // Send message click button

            try {
                driver.findElement(By.xpath((String) obj.get("expectedResult")));
                logger.info("Test Succeeded");
            } catch (Exception e) {
                logger.info("Test Failed");
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
