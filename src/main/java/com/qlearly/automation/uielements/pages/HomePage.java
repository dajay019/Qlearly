package com.qlearly.automation.uielements.pages;

import static com.qlearly.automation.constants.HTMLElements.ANCHOR;
import static com.qlearly.automation.constants.HTMLElements.BUTTON;

import com.qlearly.automation.utils.WebDriverUtils;
import com.qlearly.automation.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

  private By homeIcon = By.cssSelector("a[href*=\"index.html\"]");
  private By firstFolder = By.cssSelector(".board-row");
  private By addBoardBtn = WebElementUtils.get()
      .getByUsingContainsTextMatch("div", " Create Board");
  private By boardNameInput = By.name("boardname");
  private By boardElement;
  private By createBoardBtn = WebElementUtils.get().getByUsingContainsTextMatch(BUTTON, "Create");

  public void navigateToHomePage() {
    WebElementUtils.get().performJSClick(homeIcon);
  }

  public void addBoard(String boardName) {
    WebElementUtils.get().click(WebElementUtils.get().getChildElement(firstFolder, addBoardBtn));
    WebElementUtils.get().type(firstFolder, boardNameInput, boardName);
    WebElementUtils.get().click(firstFolder, createBoardBtn);
    WebElementUtils.get().verifyChildElementPresence(firstFolder,
        WebElementUtils.get().getByUsingContainsTextMatch(ANCHOR, boardName));
    WebDriverUtils.get().wait(2);
  }

  public void openBoard(String boardName) {
    WebElementUtils.get()
        .click(getBoardWebElement(firstFolder, boardName));
  }

  private WebElement getBoardWebElement(By parent, String boardName) {
    boardElement = By.xpath("//a[contains(text(),\"" + boardName
        + "\")]//ancestor::div[contains(@class,\"q-board-block\")]");
    return WebElementUtils.get().getChildElement(parent, boardElement);
  }

}
