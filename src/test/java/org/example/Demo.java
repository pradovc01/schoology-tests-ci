package org.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	@Test
	public void demo() {

		// puente de comunicacion con el browser
		WebDriverManager.chromedriver().setup();

		// open the browser
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// interceptar timeout // conocer la app
		// set Timeout 3

		// resolution mobile iphone plus
		driver.manage().window().setSize(new Dimension(414, 736));


		// load the url
		driver.get("https://formy-project.herokuapp.com/form");

		WebElement webElement = driver.findElement(By.cssSelector("#checkbox-2"));
		webElement.click();

		List<WebElement> webElements = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(webElements.size());

//		driver.findElement(By.cssSelector(".not-exist")).click();

		List<WebElement> webElementsNotExit = driver.findElements(By.cssSelector(".not-exist"));
		System.out.println(webElementsNotExit.size());

		Select select = new Select(driver.findElement(By.cssSelector("#select-menu")));
		select.selectByValue("3");

		select.selectByVisibleText("0-1");

		select.selectByIndex(4);

		List<WebElement> options = select.getOptions();


		// set a textbox
		driver.findElement(By.cssSelector("#first-name")).sendKeys("Testing");



//		driver.close();
		driver.quit();

		// No usar nunca estos methods
//		By.id() #
//		By.name() [name='']
//		By.className() .
//		By.tagName() //
//		By.partialLinkText() //[contains(text(), '')]
//		By.linkText() //[text()=""]

		// siempre tratar de usar estos metodos
//		By.cssSelector()
//		By.xpath()

	}

	@Test
	public void demoSchoology() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://app.schoology.com/login");

		driver.findElement(By.cssSelector("#edit-mail")).sendKeys("carledriss+01@gmail.com");
		driver.findElement(By.cssSelector("#edit-pass")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("#edit-submit")).click();

		driver.findElement(By.xpath("//span[text()='Courses']/parent::button")).click();

		driver.findElement(By.cssSelector("a[href='/courses']")).click();

		driver.findElement(By.cssSelector("a.create-course-btn")).click();

		String courseName = "Test Course";
		driver.findElement(By.cssSelector("#edit-course-name")).sendKeys(courseName);
		WebElement sectionField = driver.findElement(By.cssSelector("#edit-section-name-1"));
		sectionField.clear();
		sectionField.sendKeys("Section");
		Select subjectArea = new Select(driver.findElement(By.cssSelector("#edit-subject-area")));
		subjectArea.selectByVisibleText("Mathematics");
		Select level = new Select(driver.findElement(By.cssSelector("#edit-grade-level-range-start")));
		level.selectByVisibleText("Undergraduate");

		driver.findElement(By.cssSelector("#edit-submit")).click();

		driver.findElement(By.xpath("//span[text()='Courses']/parent::button")).click();

		driver.findElement(By.cssSelector("a[href='/courses']")).click();

		String courseActions = "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
		driver.findElement(By.xpath(String.format(courseActions, courseName))).click();
	}

}
