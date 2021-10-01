package com.qlearly.automation.tests.ui.functional.GuestMode;

import com.qlearly.automation.uielements.overlays.OpenedTabsOverlay;
import com.qlearly.automation.uielements.pages.BoardDetailsPage;
import org.testng.annotations.Test;

public class InvokeExtensionTests {

  @Test
  public void openFourDifferentURLS() {
    new BoardDetailsPage().openFourSocialLinks();
  }

  @Test(dependsOnMethods = "openFourDifferentURLS")
  public void switchToFourthTab() {
    new OpenedTabsOverlay().switchToFourthLinkInCurrentSession();
  }

}
