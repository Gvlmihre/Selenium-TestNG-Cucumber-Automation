package com.semtrio.uipages;

import com.semtrio.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlbumsPage {
    TestUtility testUtility;

    WebDriver driver;

    public AlbumsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//*[@class='albums-section']/div/div[1]")
    WebElement firstAlbum;

   @FindBy(xpath = "//*[@class='photos-section']")
    WebElement photo;

    public void clickOnAlbumsForPhotos(){
        testUtility.waitForElementPresent(firstAlbum);
        firstAlbum.click();
    }

    public boolean verifyAlbumOpenedSuccessfully(){
        return photo.isDisplayed();

    }


}
