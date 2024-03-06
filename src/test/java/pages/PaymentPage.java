package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    By pay = By.xpath("//*[@id=\"post-39\"]/div/div/section[2]/div/div/div/div/div/div/div/div[2]/div/div/a");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPay() throws NoSuchElementException {
        driver.findElement(this.pay).click();
    }

}
