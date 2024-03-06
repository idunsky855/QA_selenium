package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;
    // locator for add to cart button
    By addToCartBtn = By.name("add-to-cart");
    // locator for Cart Icon
    By cartIcon = By.xpath("//*[@id=\"ast-site-header-cart\"]/div[1]/a/div/span");
    // locator for quantity
    By quantity = By.name("quantity");
    // locator for spanText
    By spanText = By.xpath("//*[@id=\"ast-site-header-cart\"]/div[1]/a/div/span");
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(this.addToCartBtn).click();
    }

    public String getCartIconText(){
        return driver.findElement(this.cartIcon).getText();
    }

    public void getElement(String xpath) throws NoSuchElementException {
        driver.findElement(By.xpath(xpath));
    }

    public WebElement getQuantityElement(){
        return driver.findElement(this.quantity);
    }

    public String getSpanText(){
        return driver.findElement(this.spanText).getText();
    }

}
