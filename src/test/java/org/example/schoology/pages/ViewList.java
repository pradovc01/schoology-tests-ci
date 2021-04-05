package org.example.schoology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

public class ViewList extends AbstractPage {

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    @FindBy(css = "ul[style=\"display: block;\"] .action-edit a")
    protected WebElement editOption;

    @FindBy(css = "ul[style=\"display: block;\"] .action-delete a")
    protected WebElement deleteOption;

    public String getMessage() {
        return action.getText(messages);
    }

}
