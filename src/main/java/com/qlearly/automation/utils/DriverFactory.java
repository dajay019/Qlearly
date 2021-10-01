package com.qlearly.automation.utils;

import static com.qlearly.automation.constants.ConfigValues.BROWSER;
import static com.qlearly.automation.constants.ConfigValues.CRX_PATH;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

  public WebDriver createNewDriver() {
    WebDriver driver = null;
    switch (BROWSER) {
      case "chrome":
      default:
        driver = openChromeBrowser();
        break;
      case "firefox":
        driver = openFirefoxBrowser();
        break;
    }
    driver.manage().window().maximize();
    return driver;
  }

  private WebDriver openChromeBrowser() {
    WebDriver driver = null;
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addExtensions(new File(CRX_PATH));
    WebDriverManager.chromedriver().clearResolutionCache().clearDriverCache().setup();
    driver = new ChromeDriver(chromeOptions);
    return driver;
  }

  private WebDriver openFirefoxBrowser() {
    return null;
  }

}
