package driveractions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DriverClass {

    private WebDriver driver;

    public DriverClass(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getTextForElementWithIndex(By locator, int index) {
        return driver.findElements(locator).get(index).getText();
    }
}
