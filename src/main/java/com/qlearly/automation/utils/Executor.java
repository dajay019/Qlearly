package com.qlearly.automation.utils;

import org.openqa.selenium.WebDriver;

public class Executor {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      driver = new DriverFactory().createNewDriver();
    }
    return driver;
  }
}
