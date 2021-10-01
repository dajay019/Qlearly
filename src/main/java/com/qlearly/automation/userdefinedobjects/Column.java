package com.qlearly.automation.userdefinedobjects;

import static com.qlearly.automation.constants.HTMLElements.BUTTON;

import com.qlearly.automation.uielements.popups.CreateNewPopUp;
import com.qlearly.automation.utils.WebDriverUtils;
import com.qlearly.automation.utils.WebElementUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Column {

  private WebElement parent = null;
  private By addBtnXpath = WebElementUtils.get()
      .getByUsingExactTextMatch(BUTTON, "Add");
  private By saveBtnXpath = WebElementUtils.get()
      .getByUsingExactTextMatch(BUTTON, "Save");
  private By openBtnXpath = WebElementUtils.get()
      .getByUsingExactTextMatch(BUTTON, "Open");
  private By firstListedTitleInColumn = By.cssSelector("li p");
  private By firstListedEntryInColumn = By.cssSelector("li");


  public Column(By parent, int index) {
    this.parent = WebElementUtils.get().getElementByIndexInList(parent, index);
  }

  public void add(String title, String url) {
    WebElementUtils.get().click(WebElementUtils.get().getChildElement(parent, addBtnXpath));
    new CreateNewPopUp().createNewBookmark(title, url);
    verifyAddedEntry(title);
  }

  public void verifyAddedEntry(String title) {
    WebDriverUtils.get()
        .assertElementText(WebElementUtils.get().getChildElement(parent, firstListedTitleInColumn),
            title);
  }

  public WebElement getFirstListedEntry() {
    return WebElementUtils.get().getChildElement(parent, firstListedEntryInColumn);
  }

  public List<WebElement> getColumnEntriesList() {
    return WebElementUtils.get().getChildElements(parent, firstListedEntryInColumn);
  }


}
