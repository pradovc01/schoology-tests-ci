package org.example.schoology.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import org.example.core.AssertionGroup;
import org.example.core.ui.SharedDriver;

public class CommonHooks {

    private final AssertionGroup assertionGroup;

    public CommonHooks(final SharedDriver sharedDriver, final AssertionGroup assertionGroup) {
        this.assertionGroup = assertionGroup;
    }

    @Before(value = "@softAssert")
    public void beforeSoftAssert() {
        assertionGroup.setAssertion(new SoftAssert());
    }

    @Then("I assert all")
    public void afterSoftAssert() {
        ((SoftAssert) assertionGroup.getAssertion()).assertAll();
    }

}
