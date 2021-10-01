package com.qlearly.automation.uielements.pages;

import com.qlearly.automation.userdefinedobjects.Column;
import com.qlearly.automation.userdefinedobjects.ColumnEntry;
import com.qlearly.automation.utils.WebDriverUtils;
import com.qlearly.automation.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BoardDetailsPage {

  private String primaryBoardName = "Primary Board";

  private String guestModeMessage = "Guest Mode: Login or create an account to make sure your boards are backed up.";

  private By guestModeMessageCss = By.cssSelector(".open-signup.pointer");

  private By columnsCss = By.cssSelector("#column_container [id*=\"column\"]");

  private By searchBox = By.id("top_search");

  private By firstListerValueInSearchBox = By.cssSelector("#ui-id-1 span a p");

  private By message = By.id("message");

  private By boardNameHeader = By.id("selected_board_name");

  private Column bookmarkColumn;

  private By settingsLink = By.id("setting-dropdown");

  private By deleteBoardLink = By.id("delete_board");

  public void addBookmark(String title, String url) {
    bookmarkColumn = new Column(columnsCss, 0);
    bookmarkColumn.add(title, url);
  }

  public void searchBookMark(String title) {
    WebElementUtils.get().click(searchBox);
    WebElementUtils.get().type(searchBox, title);
    WebDriverUtils.get().wait(2);
    WebDriverUtils.get().assertElementText(firstListerValueInSearchBox, title);
  }

  public void deleteBookMark(String title) {
    bookmarkColumn = new Column(columnsCss, 0);
    ColumnEntry bookmark = new ColumnEntry(bookmarkColumn.getFirstListedEntry());
    bookmark.deleteEntry();
    WebDriverUtils.get().assertElementText(message, "Remove Complete.    UNDO");
    WebElementUtils.get().verifyAbsenceOfElement(bookmark.getParent());
  }

  public void deleteBoard() {
    WebElementUtils.get().click(settingsLink);
    WebElementUtils.get().click(deleteBoardLink);
    WebDriverUtils.get().acceptAlert();
    verifyBoardName(primaryBoardName);
  }

  public void clickOnSkip() {
    WebElementUtils.get().click(WebElementUtils.get().getElementUsingContainsText("a", "Skip"));
  }

  public void verifyGuestMessage() {
    Assert.assertTrue(
        WebElementUtils.get().getElementText(guestModeMessageCss).contentEquals(guestModeMessage));
  }

  public void verifyBoardName(String boardName) {
    WebDriverUtils.get().assertElementValue(boardNameHeader, boardName);
  }

  public void openFourSocialLinks() {
    String currentWindow = WebDriverUtils.get().getWindowHandle();
    Column socialColumn = new Column(columnsCss, 1);
    int counter = 0;
    for (WebElement element : socialColumn.getColumnEntriesList()) {
      WebElementUtils.get().click(element);
      WebDriverUtils.get().switchTo(currentWindow);
      counter++;
      if (counter == 4) {
        break;
      }
    }
    WebDriverUtils.get().wait(5);
  }


}
