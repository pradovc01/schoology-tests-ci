package org.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
