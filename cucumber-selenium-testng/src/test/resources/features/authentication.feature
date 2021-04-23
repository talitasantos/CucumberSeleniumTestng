#Author: talitasantos2310@gmail.com
@authentication
Feature: Authentication
  As a user
  I want to create an account or sign in system with already registred user
  So that I can shop

  Background: Access sign in
    Given I clicked sign in

  @successfullyCreateAnAccount
  Scenario: Title of your scenario
    Given I entered a valid email address "tribeiro4@email.com"
    When I click create an account
    And select title
    And fill first name "Talita"
    And fill last name "Ribeiro"
    And fill password "pudim"
    And select date of birth "23" "10" "1991"
    And select to receive newsletter
    And fill company "Tribeiro's Candy"
    And fill address "2310, Brigadeiro Avenue"
    And fill city "Jacksonville"
    And select "Florida" state
    And fill zip code "07036"
    And fill home phone "11 2222-2222"
    And fill mobile phone "55 5555-5555"
    And fill alternative address "0308, Brownie Avenue"
    When I click register
    Then system returns "http://automationpractice.com/index.php?controller=my-account" page
