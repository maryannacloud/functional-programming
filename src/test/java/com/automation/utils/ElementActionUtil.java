package com.automation.utils;

import org.openqa.selenium.WebElement;

import java.util.function.Consumer;

public class ElementActionUtil {

    public static void performAction(WebElement element, Consumer<WebElement> action){
        action.accept(element);
    }

}
