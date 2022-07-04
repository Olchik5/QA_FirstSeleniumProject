package com.telran.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HwLoginGreenData {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://gdcloud.ru/release-17/auth/login.html#/?_k=gg6ctj");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public boolean isElementPresent(By userName){
        return  wd.findElements(By.xpath("//span[@id='userName']")).size() > 0;
    }

    @Test
    public void LoginUserPositiveTest(){
        //fill login form tester/K35G3U
        type(By.cssSelector("[name='login']"), "tester");
        type(By.cssSelector("[name='password']"), "K35G3U");
        //click on the button Войти
        click(By.xpath("//button[@id='login_button']"));
        //assert  Иванов QA.test
        Assert.assertTrue(isElementPresent(By.xpath("//span[@id='userName']")));

    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }

}
