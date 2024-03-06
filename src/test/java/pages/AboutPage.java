package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutPage {
    WebDriver driver;
    By facebook = By.xpath("//*[@id=\"post-43\"]/div/div/section[4]/div[2]/div/div/div[3]/div/div/span[1]/a");
    By twitter = By.xpath("//*[@id=\"post-43\"]/div/div/section[4]/div[2]/div/div/div[3]/div/div/span[2]/a");
    By instagram = By.xpath("//*[@id=\"post-43\"]/div/div/section[4]/div[2]/div/div/div[3]/div/div/span[3]/a");
    By google = By.xpath("//*[@id=\"post-43\"]/div/div/section[4]/div[2]/div/div/div[3]/div/div/span[4]/a");

    public AboutPage(WebDriver driver){
        this.driver = driver;
    }

    public String goToFacebook(){
        driver.findElement(this.facebook).click();
        return driver.getCurrentUrl();
    }

    public String goToTwitter(){
        driver.findElement(this.twitter).click();
        return driver.getCurrentUrl();
    }

    public String goToInstagram(){
        driver.findElement(this.instagram).click();
        return driver.getCurrentUrl();
    }

    public String goToGooglePlus(){
        driver.findElement(this.google).click();
        return driver.getCurrentUrl();
    }


    
}
