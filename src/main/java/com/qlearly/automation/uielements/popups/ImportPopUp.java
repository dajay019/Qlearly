package com.qlearly.automation.uielements.popups;

import com.qlearly.automation.utils.WebElementUtils;
import org.openqa.selenium.By;

public class ImportPopUp {

  private By importBookmarkHeader = By.cssSelector("h4");
  private By addManuallyRadioBtn = By.cssSelector("input[value=\"manually\"]");
  private By nextButton = By.id("choose_bn_next");
  private By addBookmarkPopUp = By.id("add_bookmark");

  public void verifyImportPopUpElements() {
    WebElementUtils.get().verifyChildElementPresence(addBookmarkPopUp, importBookmarkHeader);
  }

  public void selectManualBookmarkAndClickOnNext() {
    verifyImportPopUpElements();
    WebElementUtils.get().click(addManuallyRadioBtn);
    WebElementUtils.get().click(nextButton);
  }

}
