package com.semtrio.configutility;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {

    private WebDriver driver;

    private int timeout = Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties", "timeout"));

    Faker faker = new Faker();

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int generateRandomNumbers(){
        int randomNumber= faker.number().numberBetween(0,1000000000*10000);
        return randomNumber;
    }

    public void selectValueFromDropDown(WebElement webelement, String value) {
        Select s = new Select(webelement);
        s.selectByValue(value);
    }
}
