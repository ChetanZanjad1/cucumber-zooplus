
Feature: Place order

  Scenario: lauch browser and enter URL
    Given launch browser
    When user is on zooplus dashboard
    Then user navigate to homepage
    
   Scenario: Navivgate to PLP
    Given user on homepage
    When user trying to Navivgate on PLP
    Then user navigate to PLP
    
    Scenario: select random product and navigate to PDP
    Given user on PLP
    When user trying to Navivgate on PDP by selecting random product
    Then user navigate to PDP
    
     Scenario: Add product into cart
    Given user is on PDP
    When user trying to add product into cart
    Then user able to added product
    
    Scenario: Verify proceed button enable or not on checkout overiew page
    Given user is on checkout overview
    When user trying to enable proceed button by add product into cart
    Then user can see proceed button enable
    
    Scenario: user want to login with valide credential
    Given user is on checkout overview
    When user trying to login with valide credential
    Then user sucessfully login
    
     Scenario: user want to change payment method
    Given user is on checkout preview page
    When user trying to change payment method
    Then user sucessfully changed payment method
    
     Scenario: user want to place order
    Given user changed payment method
    When user trying to place order
    Then user sucessfully place order and navigate to order finish page