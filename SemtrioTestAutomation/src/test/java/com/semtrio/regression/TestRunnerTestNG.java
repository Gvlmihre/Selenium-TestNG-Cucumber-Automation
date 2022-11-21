package com.semtrio.regression;

import com.semtrio.configutility.ApplicationConfig;
import com.semtrio.configutility.TestBase;
import com.semtrio.configutility.TestUtility;
import com.semtrio.uipages.AlbumsPage;
import com.semtrio.uipages.HomePage;
import com.semtrio.uipages.PostsPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRunnerTestNG extends TestBase {

    TestUtility testUtility;
    HomePage homePage;
    PostsPage postsPage;
    AlbumsPage albumsPage;
    String configFile="config.properties";


    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);
        browserSetUp(ApplicationConfig.readFromConfigProperties(
                configFile, "frontEndURL"));
        context.setAttribute("driver", driver);
        homePage=new HomePage(driver);
        postsPage=new PostsPage(driver);
        albumsPage=new AlbumsPage(driver);
}

    @Test(description = "Test 1", priority = 1)
    public void selectAUser(){
       homePage.selectUserFromDropdown();
       Assert.assertTrue(homePage.verifyUserSelectedSuccessfully());
    }

    @Test(description = "Test 2", priority = 2)
    public void seeComments(){
        postsPage.clickOnPostForComments();
        Assert.assertTrue(postsPage.verifyCommentsDisplayed());
    }

    @Test(description = "Test 3", priority = 3)
    public void seePhotos(){
        albumsPage.clickOnAlbumsForPhotos();
        Assert.assertTrue(albumsPage.verifyAlbumOpenedSuccessfully());
    }




}
