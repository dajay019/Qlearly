package com.qlearly.automation.uielements.overlays;

import com.qlearly.automation.utils.WebDriverUtils;
import com.qlearly.automation.utils.WebElementUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpenedTabsOverlay {

  private By openedTabsLink = By.id("showCrntSsion");
  private By openedTabsOverlayEntries = By.cssSelector("#csc_right li");
  private By openedTabBookmarkUrl = By.cssSelector("a.bookmark-url");

  public void switchToFourthLinkInCurrentSession() {
    String fourthTabWindowHandle = WebDriverUtils.get().getWindowHandles().get(4);
    WebElementUtils.get().click(openedTabsLink);
    List<WebElement> openedSessions = WebElementUtils.get().getElements(openedTabsOverlayEntries);
    String bookmarkUrl = WebElementUtils.get()
        .getElementAttributeValue(
            WebElementUtils.get().getChildElement(openedSessions.get(3), openedTabBookmarkUrl),
            "href");
    WebElementUtils.get().click(openedSessions.get(3));
    WebDriverUtils.get().switchTo(fourthTabWindowHandle);
    WebDriverUtils.get().assertPageUrl(bookmarkUrl);
  }

}
