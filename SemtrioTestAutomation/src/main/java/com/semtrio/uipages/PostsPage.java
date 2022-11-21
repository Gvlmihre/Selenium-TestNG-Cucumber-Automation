package com.semtrio.uipages;

import com.semtrio.configutility.TestBase;
import com.semtrio.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostsPage extends TestBase {

    TestUtility testUtility;

    WebDriver driver;

    public PostsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//*[@class='posts-section']/div/div[1]")
    WebElement firstPost;

    @FindBy(xpath = "//*[@class='comments']/div[1]")
    WebElement commentSection;


    public void verifyTheUserIsOnTheDashboardPage(){
        testUtility.waitForElementPresent(firstPost);
        firstPost.isDisplayed();
    }

    public void clickOnPostForComments(){
        testUtility.waitForElementPresent(firstPost);
        firstPost.click();
    }

    public boolean verifyCommentsDisplayed(){
        testUtility.waitForElementPresent(commentSection);
        return commentSection.isDisplayed();
    }


}
