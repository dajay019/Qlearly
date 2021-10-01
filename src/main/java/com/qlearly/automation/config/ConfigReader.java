package com.qlearly.automation.config;

import static com.qlearly.automation.constants.ConfigKeys.BROWSER_KEY;
import static com.qlearly.automation.constants.ConfigKeys.CRX_PATH_KEY;
import static com.qlearly.automation.constants.FilePaths.PROPERTIES_FILE_PATH;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ConfigReader {

  private static ConfigReader reader;
  private String crxPath = null;
  private String browser = null;

  private ConfigReader() {
    readProperties();
  }

  public static ConfigReader get() {
    if (reader == null) {
      reader = new ConfigReader();
    }
    return reader;
  }

  private void readProperties() {
    Properties properties = new Properties();
    try {
      Reader reader = new FileReader(
          new File(".").getCanonicalPath() + PROPERTIES_FILE_PATH);
      properties.load(reader);
      setCrxPath(properties.getProperty(CRX_PATH_KEY));
      setBrowser(properties.getProperty(BROWSER_KEY));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getCrxPath() {
    return crxPath;
  }

  public void setCrxPath(String crxPath) {
    this.crxPath = crxPath;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }
}
