package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.testng.asserts.Assertion;

import org.example.core.AssertionGroup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.EditGroupPopup;
import org.example.schoology.pages.groups.GroupForm;
import org.example.schoology.pages.groups.Groups;

public class GroupStepDefs {

    private Groups groups;

    private Assertion assertion;

    public GroupStepDefs(final AssertionGroup assertionGroup, final Groups groups) {
        assertion = assertionGroup.getAssertion();
        this.groups = groups;
    }

    @And("I create a group with:")
    public void iCreateAGroupWith(final Map<GroupForm, String> datatable) {
        String menu = "Groups";
        SubMenu subMenu = new Home().clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateGroupPopup createGroupPopup = this.groups.clickCreateGroupButton();
        createGroupPopup.create(datatable);
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(final String name, final Map<GroupForm, String> datatable) {
        EditGroupPopup editGroupPopup = groups.clickEditGroup(name);
        groups = editGroupPopup.edit(datatable);
    }

    @And("I should see a group with {string} as a name")
    public void iShouldSeeAGroupWithAsName(final String groupName) {
        assertion.assertEquals(groupName, groups.getGroupByName(groupName));
    }

}
