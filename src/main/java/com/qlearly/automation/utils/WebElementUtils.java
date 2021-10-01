package com.qlearly.automation.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebElementUtils {

  private static WebElementUtils utils;

  private WebElementUtils() {

  }

  public static WebElementUtils get() {
    if (utils == null) {
      utils = new WebElementUtils();
    }
    return utils;
  }

  public WebElement getElement(By by) {
    return Executor.getDriver().findElement(by);
  }

  public List<WebElement> getElements(By by) {
    return Executor.getDriver().findElements(by);
  }

  public WebElement getChildElement(By parent, By child) {
    return Executor.getDriver().findElement(parent).findElement(child);
  }

  public WebElement getChildElement(WebElement parent, By child) {
    return parent.findElement(child);
  }

  public List<WebElement> getChildElements(WebElement parent, By child) {
    return parent.findElements(child);
  }

  public void verifyElementPresence(By by) {
    Assert.assertTrue(getElement(by).isDisplayed(), "Element is not present in the UI");
  }

  public void verifyChildElementPresence(By parent, By child) {
    Assert.assertTrue(getChildElement(parent, child).isDisplayed(),
        "Element is not present in the UI");
  }

  public void click(By by) {
    click(getElement(by));
  }

  public void click(By parent, By child) {
    click(getChildElement(parent, child));
  }

  public void click(WebElement element) {
    element.click();
    WebDriverUtils.get().waitForPageLoad();
  }

  public void performJSClick(By element) {
    ((JavascriptExecutor) Executor.getDriver())
        .executeScript("arguments[0].click()", getElement(element));
    WebDriverUtils.get().waitForPageLoad();
  }

  public WebElement getElementUsingContainsText(String htmlElement, String text) {
    return Executor.getDriver()
        .findElement(By.xpath("//" + htmlElement + "[contains(text(),\"" + text + "\")]"));
  }

  public By getByUsingExactTextMatch(String htmlElement, String text) {
    return By.xpath("//" + htmlElement + "[text()=\"" + text + "\"]");
  }

  public By getByUsingContainsTextMatch(String htmlElement, String text) {
    return By.xpath("//" + htmlElement + "[contains(text(),\"" + text + "\")]");
  }

  public void waitForElement(By by) {
    WebDriverWait wait = new WebDriverWait(Executor.getDriver(), 10);
    wait.until(ExpectedConditions.elementToBeClickable(by));
  }

  public String getElementText(By by) {
    return Executor.getDriver().findElement(by).getText();
  }

  public String getElementAttributeValue(WebElement element, String attribute) {
    return element.getAttribute(attribute);
  }

  public String getElementText(WebElement element) {
    return element.getText();
  }

  public WebElement getElementByIndexInList(By by, int index) {
    return getElements(by).get(index);
  }

  public void type(By by, String text) {
    WebElement element = getElement(by);
    element.clear();
    element.sendKeys(text);
  }

  public void type(By parent, By child, String text) {
    WebElement element = getChildElement(parent, child);
    element.clear();
    element.sendKeys(text);
  }

  public void verifyAbsenceOfElement(By by) {
    try {
      verifyElementPresence(by);
    } catch (Exception e) {
//      System.out.println("Element is not present");
    }
  }

  public void verifyAbsenceOfElement(WebElement element) {
    try {
      Assert.assertFalse(element.isDisplayed());
    } catch (Exception e) {
//      System.out.println("Element is not present");
    }
  }


}
