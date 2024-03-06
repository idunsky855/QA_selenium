package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    WebDriver driver; 
    By next = By.xpath("//*[@id=\"main\"]/div/nav[2]/ul/li[2]/a");
    By prev = By.xpath("//*[@id=\"main\"]/div/nav[2]/ul/li[1]/a");

    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public String goToNextPage(){
        driver.findElement(this.next).click();
        return driver.getCurrentUrl();   
    }

    public String goToPreviousPage(){
        driver.findElement(this.prev).click();
        return driver.getCurrentUrl();
    }

}
