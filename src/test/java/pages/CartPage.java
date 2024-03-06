package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By removeBtn = By.xpath("//*[@id=\"post-39\"]/div/div/section[2]/div/div/div/div/div/div/div/form/table/tbody/tr[1]/td[1]/a");
    By proceedToCheckout = By.xpath("//*[@id=\"post-39\"]/div/div/section[2]/div/div/div/div/div/div/div/div[2]/div/div/a");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickRemove(){
        driver.findElement(this.removeBtn).click();
    }

    public void proceedToCheckout() throws NoSuchElementException{
        driver.findElement(this.proceedToCheckout).click();
    }




}
