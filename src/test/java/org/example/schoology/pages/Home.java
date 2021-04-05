package org.example.schoology.pages;

import org.openqa.selenium.By;

import org.example.core.ui.AbstractPage;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String menuName) {
        action.jsClick(driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))));
        return new SubMenu();
    }

}
