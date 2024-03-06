package pom_test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {



    public static WebDriver initializeDriver(){
        return new ChromeDriver();
    }
    
}
