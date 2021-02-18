package org.example.schoology.steps;

import java.util.Arrays;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.Assertion;

import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.courses.CourseForm;
import org.example.schoology.pages.groups.GroupForm;

public class CommonStepDefs {

    private final Assertion assertion;

    private Home home;

    public CommonStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup) {
        assertion = assertionGroup.getAssertion();
    }

    @DataTableType
    public CourseForm courseMap(final String courseFormField) {
        return Arrays.stream(CourseForm.values())
                .filter(e -> e.getName().equalsIgnoreCase(courseFormField))
                .findFirst()
                .orElseThrow();
    }

    @DataTableType
    public GroupForm groupMap(final String groupFormField) {
        return Arrays.stream(GroupForm.values())
                .filter(e -> e.getName().equalsIgnoreCase(groupFormField))
                .findFirst()
                .orElseThrow();
    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(final String account) {
        Login login = new Login();
        home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
                Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
    }

    @When("I navigate to {string}")
    public void iNavigateToCourses(final String menu) {
        SubMenu subMenu = home.clickMenu(menu);
        // Not put logic
        // for instance: if else, loops read files, handles strings, mathematical operations.
        subMenu.clickViewListLink(menu);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(final String message) {
        assertion.assertEquals(message, new ViewList().getMessage(), "Message banner");
    }

}
