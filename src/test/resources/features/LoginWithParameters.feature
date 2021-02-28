Feature: Login with parameters


  @LibrarianParam
  Scenario: Login as librarian 13
    Given I am on the login page
    When I enter username "librarian22@library"
    And I enter password 'bJRnAAyp'
    And click the sign in button
    And there should be 2799 users
    Then dashboard should be displayed


  @studentParam
  Scenario: Login as librarian 13
    Given I am on the login page
    When I enter username "student26@library"
    And I enter password 'JTvaF3br'
    And click the sign in button
    Then books should be displayed

  @wip
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian14@library" and "87x8afWY"
    Then dashboard should be displayed





