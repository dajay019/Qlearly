package com.qlearly.automation.utils;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebDriverUtils {

  private static WebDriverUtils driverUtils;

  private WebDriverUtils() {

  }

  public static WebDriverUtils get() {
    if (driverUtils == null) {
      driverUtils = new WebDriverUtils();
    }
    return driverUtils;
  }

  public void loadUrl(String url) {
    Executor.getDriver().get(url);
    waitForPageLoad();
  }

  public void refreshBrowser() {
    Executor.getDriver().navigate().refresh();
    waitForPageLoad();
  }

  public void dismissAlert() {
    Executor.getDriver().switchTo().alert().dismiss();
  }

  public void waitForPageLoad() {
    Executor.getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
    Executor.getDriver().manage().timeouts().pageLoadTimeout(30, SECONDS);
  }

  public void switchTab() {
    for (String windowHandle : Executor.getDriver().getWindowHandles()) {
      if (!windowHandle.contentEquals(Executor.getDriver().getWindowHandle())) {
        Executor.getDriver().switchTo().window(windowHandle);
        break;
      }
    }
  }

  public void closeAndSwitchTab() {
    String presentWindow = Executor.getDriver().getWindowHandle();
    for (String windowHandle : Executor.getDriver().getWindowHandles()) {
      if (!windowHandle.contentEquals(presentWindow)) {
        Executor.getDriver().close();
        Executor.getDriver().switchTo().window(windowHandle);
        break;
      }
    }
  }

  public void closeTab() {
    Executor.getDriver().close();
  }

  public void closeBrowser() {
    Executor.getDriver().quit();
  }

  public void wait(int secs) {
    try {
      Thread.sleep(secs * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void assertElementText(WebElement element, String text) {
    Assert.assertTrue(WebElementUtils.get().getElementText(element).contentEquals(text),
        "Element does not have matching text");
  }

  public void assertElementText(By element, String text) {
    assertElementText(WebElementUtils.get().getElement(element), text);
  }

  public void assertElementValue(WebElement element, String text) {
    Assert.assertTrue(element.getAttribute("value").contentEquals(text),
        "Element does not have matching text");
  }

  public void assertElementValue(By element, String text) {
    assertElementValue(WebElementUtils.get().getElement(element), text);
  }

  public void acceptAlert() {
    Executor.getDriver().switchTo().alert().accept();
  }

  public void switchTo(String handle) {
    Executor.getDriver().switchTo().window(handle);
  }

  public String getWindowHandle() {
    return Executor.getDriver().getWindowHandle();
  }

  public List<String> getWindowHandles() {
    List<String> handles;
    handles = new ArrayList<>(Executor.getDriver().getWindowHandles());
    return handles;
  }

  public void assertPageUrl(String bookmarkUrl) {
    Assert.assertTrue(Executor.getDriver().getCurrentUrl().contentEquals(bookmarkUrl));
  }
}
