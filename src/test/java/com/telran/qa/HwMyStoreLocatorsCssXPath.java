package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HwMyStoreLocatorsCssXPath {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void startFindCss(){
        //tag name
        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.cssSelector("h3"));
        //id
        wd.findElement(By.cssSelector("#page"));

        //class name
        wd.findElement(By.cssSelector(".cat-title"));
        wd.findElement(By.cssSelector(".form-group"));
        //attribute
        wd.findElement(By.cssSelector("[href='http://automationpractice.com/']"));
        wd.findElement(By.cssSelector("[name]"));
        //contains
        wd.findElement(By.cssSelector("[href*='auto']"));
        //start with http://au
        wd.findElement(By.cssSelector("[href^='http://au']"));
        //end on ice.com
        wd.findElement(By.cssSelector("[href$='ice.com']"));
    }

    @Test
    public void startFindXpath(){
        //tag name
        wd.findElement(By.xpath("//div"));
        wd.findElement(By.xpath("//h3"));
        //id
        wd.findElement(By.xpath("//*[@id='page']"));
        //class name
        wd.findElement(By.xpath("//*[@class='cat-title']"));
        wd.findElement(By.xpath("//*[@class='form-group']"));
        //attribute
        wd.findElement(By.xpath("//*[@href='http://automationpractice.com/']"));
        wd.findElement(By.xpath("//*[@name]"));
        //start with http://au
        wd.findElement(By.xpath("//*[starts-with(@href,'http://au')]"));
        //contains
        wd.findElement(By.xpath("//*[contains(.,'auto')]"));
        //end on ice.com
        wd.findElement(By.xpath("//*[contains(.,'ice.com')]"));
    }



    @AfterMethod
    public void tearDown(){
        wd.quit();

    }
}
