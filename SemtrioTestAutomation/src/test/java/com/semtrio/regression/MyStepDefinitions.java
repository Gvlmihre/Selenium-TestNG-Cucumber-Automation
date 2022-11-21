package com.semtrio.regression;

import com.semtrio.configutility.ApplicationConfig;
import com.semtrio.configutility.TestBase;
import com.semtrio.uipages.AlbumsPage;
import com.semtrio.uipages.HomePage;
import com.semtrio.uipages.PostsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepDefinitions extends TestBase {

    HomePage homePage;
    PostsPage postsPage;

    AlbumsPage albumsPage;
    String configFile="config.properties";

    @Before
    public void setUp(){
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile, "frontEndURL"));
        homePage=new HomePage(driver);
        postsPage=new PostsPage(driver);
        albumsPage=new AlbumsPage(driver);
    }

    //Test 1
    @Given("a user is on the homepage")
    public void aUserIsOnTheHomepage() {
        homePage.verifyUserIsOnHomepage();
    }

    @When("the user selects a user from the users dropdown list")
    public void theUserSelectsAUserFromTheUsersDropdownList() {
       homePage.selectUserFromDropdown();
    }

    @Then("the posts and the albums displays")
    public void thePostsAndTheAlbumsDisplays() {
        Assert.assertTrue(homePage.verifyUserSelectedSuccessfully());
    }


    //Test 2
    @Given("a user is on the dashboard page")
    public void aUserIsOnTheDashboardPage() {
        homePage.selectUserFromDropdown();
        postsPage.verifyTheUserIsOnTheDashboardPage();
    }

    @When("the user clicks on a post")
    public void theUserClicksOnAPost() {
        postsPage.clickOnPostForComments();
    }

    @Then("the user can see the comments of a post")
    public void theUserCanSeeTheCommentsOfAPost() {
        Assert.assertTrue(postsPage.verifyCommentsDisplayed());
    }



    //Test 3

    @Given("A user is on the dashboard page")
    public void AUserIsOnTheDashboardPage() {
        homePage.selectUserFromDropdown();
        postsPage.verifyTheUserIsOnTheDashboardPage();
    }

    @When("the user clicks on an album")
    public void theUserClicksOnAnAlbum() {
        albumsPage.clickOnAlbumsForPhotos();
    }

    @Then("the user can see the photos")
    public void theUserCanSeeThePhotos() {
        Assert.assertTrue(albumsPage.verifyAlbumOpenedSuccessfully());
    }
}
