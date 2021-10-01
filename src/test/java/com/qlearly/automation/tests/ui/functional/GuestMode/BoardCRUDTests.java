package com.qlearly.automation.tests.ui.functional.GuestMode;

import com.qlearly.automation.uielements.pages.BoardDetailsPage;
import com.qlearly.automation.uielements.pages.HomePage;
import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCRUDTests {

  private String boardName = "Board" + new Random().nextInt(1000);

  HomePage homePage;
  BoardDetailsPage boardDetailsPage;

  @BeforeMethod(alwaysRun = true)
  public void boardSetup() {
    homePage = new HomePage();
  }

  @Test
  public void addBoard() {
    homePage.navigateToHomePage();
    homePage.addBoard(boardName);
  }

  @Test(dependsOnMethods = "addBoard")
  public void verifyBoard() {
    homePage.openBoard(boardName);
    boardDetailsPage = new BoardDetailsPage();
    boardDetailsPage.verifyBoardName(boardName);
  }

  @Test(dependsOnMethods = "verifyBoard")
  public void deleteBoard() {
    boardDetailsPage.deleteBoard();
  }

}
