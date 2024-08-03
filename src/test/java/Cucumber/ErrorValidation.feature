
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @Errors
  Scenario Outline: Error Message is displayed
    Given User tries logging in with username <username> and incorrect password <password>
    Examples: 
      | username  | password |  
      | moe@hotmail.com | 1234| 
      
