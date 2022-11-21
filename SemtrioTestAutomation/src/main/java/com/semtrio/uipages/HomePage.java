package com.semtrio.uipages;

import com.semtrio.configutility.TestBase;
import com.semtrio.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    TestUtility testUtility;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(css = "select.search-user")
    WebElement usersDropdownList;

    @FindBy(css = "div.posts-section")
    WebElement postsSection;

    public void verifyUserIsOnHomepage(){
        testUtility.waitForElementPresent(usersDropdownList);
        usersDropdownList.isDisplayed();
    }

    public void selectUserFromDropdown(){
        testUtility.waitForElementPresent(usersDropdownList);
        testUtility.selectValueFromDropDown(usersDropdownList,"6");
    }

    public boolean verifyUserSelectedSuccessfully(){
        testUtility.waitForElementPresent(postsSection);
        return postsSection.isDisplayed();

    }

}
