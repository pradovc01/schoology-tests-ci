Feature: Groups

  Scenario: Edit a group
    Given I log in as "Instructor02" user
    And I create a group with:
      | Name        | SeleniumWebDriver |
      | Description | Description       |
      | Privacy     | School            |
      | Access      | Invite Only       |
      | Category    | Musical Groups    |
    When I navigate to "Groups"
    And I edit the "SeleniumWebDriver" group with:
      | Name | SeleniumWebDriver updated |
    Then I should see the "SeleniumWebDriver updated has been saved." message
    And I should see a group with "SeleniumWebDriver updated" as a name