package org.example.schoology.pages.courses;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;

public abstract class AbstractCoursePopup extends AbstractPage {

    @FindBy(css = "#edit-course-name")
    private WebElement courseNameTextField;

    @FindBy(css = "#edit-section-name-1")
    private WebElement sectionNameTextField;

    @FindBy(css = "#edit-subject-area")
    private WebElement subjectAreaDropDown;

    @FindBy(css = "#edit-grade-level-range-start")
    private WebElement levelDropDown;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void fill(final Map<CourseForm, String> courseMap) {
        EnumMap<CourseForm, Step> stepsMap = new EnumMap<>(CourseForm.class);
        stepsMap.put(CourseForm.COURSE_NAME, () -> setName(courseMap.get(CourseForm.COURSE_NAME)));
        stepsMap.put(CourseForm.SECTION_NAME, () -> setSection(courseMap.get(CourseForm.SECTION_NAME)));
        stepsMap.put(CourseForm.SUBJECT_AREA, () -> selectSubjectArea(courseMap.get(CourseForm.SUBJECT_AREA)));
        stepsMap.put(CourseForm.LEVEL, () -> selectLevel(courseMap.get(CourseForm.LEVEL)));

        for (final CourseForm keyField : courseMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    public void setName(final String name) {
        action.setValue(courseNameTextField, name);
    }

    private void setSection(final String section) {
        action.setValue(sectionNameTextField, section);
    }

    public void selectSubjectArea(final String area) {
        Select subjectArea = new Select(subjectAreaDropDown);
        subjectArea.selectByVisibleText(area);
    }

    public void selectLevel(final String level) {
        Select levelField = new Select(levelDropDown);
        levelField.selectByVisibleText(level);
    }
}
