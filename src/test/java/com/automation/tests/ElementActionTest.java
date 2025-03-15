package com.automation.tests;

import com.automation.utils.ElementActionUtil;
import com.automation.utils.WebDriverManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementActionTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManagerUtil.getDriver("chrome");
    }

    @Test
    public void testElementActionsWithLambdas(){
        driver.get("http://18.118.14.155:8080/bank/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("username"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        ElementActionUtil.performAction(usernameField, e -> e.sendKeys("testuser"));
        ElementActionUtil.performAction(passwordField, e -> e.sendKeys("password"));
        ElementActionUtil.performAction(loginButton, WebElement::click);
    }
}
