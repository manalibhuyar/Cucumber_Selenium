Feature: Transaction List Validation

  @uat @test1
  Scenario: Transaction List Validation
    Given user launch Chrome browser
    And user lands on blockstream page
    Then user validates section has heading "25 of 2875 Transactions"


  @uat @test2
  Scenario: Transaction List Validation
    Given user launch Chrome browser
    And user lands on blockstream page
    Then user prints transaction for one input and two output
