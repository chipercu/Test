package org.example.Reflection_1.Config;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class XPath {

    private String xpath;
    private Optional<WebElement> element;


    public XPath(String xpath) {
        this.xpath = xpath;
    }
    public static Function<WebElement, Boolean> elementIsVisibleAndEnabled(){
        return webElement -> webElement.isDisplayed() && webElement.isEnabled();
    }

//    public Optional<WebElement> getElement(){
//        WebDriver driver = new ChromeDriver();
////        try {
////            By by = By.xpath(xpath);
////            Function<By, Boolean> isDisplayed = b -> {
////                final WebElement webElement = driver.findElement(b);
////                return webElement.isDisplayed() && webElement.isEnabled();
////            };
//////            new TextField().is().text();
////
////
////
////
//////            final WebElement until = new WebDriverWait(driver, Duration.ofSeconds(4)).until(visibilityOfElementLocated(by));
////
////            return Optional.of(until);
////        }catch (Exception e){
////            return Optional.empty();
////        }
//    }

}
