package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactUsPage {
    WebDriver driver;
    //locator for name
    By name = By.xpath("//*[@id=\"wpforms-15-field_0\"]");
    //locator for subject
    By subject = By.xpath("//*[@id=\"wpforms-15-field_5\"]");
    //locator for email
    By email = By.xpath("//*[@id=\"wpforms-15-field_4\"]");
    //locator for message
    By message = By.xpath("//*[@id=\"wpforms-15-field_2\"]");
    //locator for button
    By btn = By.xpath("//*[@id=\"wpforms-submit-15\"]");

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterName(String name){
        driver.findElement(this.name).sendKeys(name);
    }

    public void enterSubject(String subject){
        driver.findElement(this.subject).sendKeys(subject);       
    }

    public void enterEmail(String email){
        driver.findElement(this.email).sendKeys(email);
    }

    public void enterMessage(String message){
        driver.findElement(this.message).sendKeys(message);
    }

    public void clickButton(){
        driver.findElement(this.btn).click();
    }

    public void getElement(String xpath) throws NoSuchElementException {
        driver.findElement(By.xpath(xpath));
    }


}
