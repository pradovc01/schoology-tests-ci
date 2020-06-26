package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String menuName) {
        driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
        return new SubMenu();
    }

}
