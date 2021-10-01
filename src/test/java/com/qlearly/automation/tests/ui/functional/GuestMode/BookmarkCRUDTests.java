package com.qlearly.automation.tests.ui.functional.GuestMode;

import com.qlearly.automation.uielements.pages.BoardDetailsPage;
import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookmarkCRUDTests {

  private String title = "test" + new Random().nextInt(1000);
  private String url = "https://google.com";
  private BoardDetailsPage boardDetailsPage;

  @BeforeMethod(alwaysRun = true)
  public void bookmarkSetup() {
    boardDetailsPage = new BoardDetailsPage();
  }

  @Test
  public void addBookmark() {
    boardDetailsPage.addBookmark(title, url);
  }

  @Test(dependsOnMethods = "addBookmark")
  public void searchBookmark() {
    boardDetailsPage.searchBookMark(title);
  }

  @Test(dependsOnMethods = "searchBookmark")
  public void deleteBookmark() {
    boardDetailsPage.deleteBookMark(title);
  }
}
