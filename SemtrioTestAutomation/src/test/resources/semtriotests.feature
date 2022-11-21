@CucumberTest
  Feature: A user can view the posts and albums of a user

    @SelectAUser
    Scenario: a user can select a user from the dropdown list
      Given a user is on the homepage
      When the user selects a user from the users dropdown list
      Then the posts and the albums displays

    @SeeComments
    Scenario: a user can see the comments of a post
      Given a user is on the dashboard page
      When the user clicks on a post
      Then the user can see the comments of a post

    @SeePhotos
    Scenario: a user can see the photos of an album
      Given A user is on the dashboard page
      When the user clicks on an album
      Then the user can see the photos

