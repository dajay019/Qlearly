package com.qlearly.automation.uielements.popups;

import static com.qlearly.automation.constants.HTMLElements.BUTTON;

import com.qlearly.automation.utils.WebElementUtils;
import org.openqa.selenium.By;

public class CreateNewPopUp {

  private By titleInput = By.id("entry_title");
  private By urlInput = By.id("entry_website_url");
  private By createBtn = WebElementUtils.get()
      .getByUsingContainsTextMatch(BUTTON, "CREATE");

  public void createNewBookmark(String title, String url) {
    WebElementUtils.get().type(titleInput, title);
    WebElementUtils.get().type(urlInput, url);
    WebElementUtils.get().click(createBtn);
  }

}
