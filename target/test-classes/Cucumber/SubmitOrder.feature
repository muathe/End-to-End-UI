
@tag
Feature: Successfully purchase an order of your choosing



  @tag2
  Scenario Outline: Successfully make an order
    Given User is able to login with username <username> and password <password>
    When User verifies the correct product <productname> is inside the cart
    And User can checkout the product with country <fcountry> <scountry> name
    Then "THANKYOU FOR THE ORDER." message should be displayed on the confirmation page

    Examples: 
      | username        | password | productname      | fcountry | scountry|
      | moe@hotmail.com |12345     |ADIDAS ORIGINAL   | United   |Kingdom|

