package com.qlearly.automation.userdefinedobjects;

import static com.qlearly.automation.constants.HTMLElements.ANCHOR;

import com.qlearly.automation.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ColumnEntry {

  public WebElement getParent() {
    return parent;
  }

  private WebElement parent = null;
  private By dropDownLink = By.id("dropdownMenuLink");
  private By editLink = WebElementUtils.get().getByUsingContainsTextMatch(ANCHOR, "Edit");
  private By renameLink = WebElementUtils.get().getByUsingContainsTextMatch(ANCHOR, "Rename");
  private By deleteLink = By.cssSelector("a.link-hover img[src*=\"delete\"]");

  public ColumnEntry(WebElement parent) {
    this.parent = parent;
  }

  public void deleteEntry() {
    WebElementUtils.get().click(WebElementUtils.get().getChildElement(parent, dropDownLink));
    WebElementUtils.get().click(WebElementUtils.get().getElement(deleteLink));
  }

}
