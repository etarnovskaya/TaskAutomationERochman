package com.elena.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
       wd = new ChromeDriver();
    }

    @Test
    public void loginTest(){
        click(By.cssSelector("[href='/login']"));

    }


    @AfterMethod
    public void tearDown(){

    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text!=null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void confirmAlert(){
        wd.switchTo().alert().accept();
    }
}
