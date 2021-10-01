package com.qlearly.automation.tests.supportmodules;

import com.qlearly.automation.uielements.pages.BoardDetailsPage;
import com.qlearly.automation.uielements.popups.ImportPopUp;
import com.qlearly.automation.utils.WebDriverUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestFlowController {

  @BeforeSuite(alwaysRun = true)
  public void openBrowser() {
    WebDriverUtils.get().closeAndSwitchTab();
  }

  @BeforeTest
  public void beforeGuestSuite() {
    new ImportPopUp().selectManualBookmarkAndClickOnNext();
    BoardDetailsPage boardDetailsPage = new BoardDetailsPage();
    boardDetailsPage.clickOnSkip();
    boardDetailsPage.verifyGuestMessage();
  }

  @AfterSuite(alwaysRun = true)
  public void closeBrowser() {
    WebDriverUtils.get().closeBrowser();
  }

}
