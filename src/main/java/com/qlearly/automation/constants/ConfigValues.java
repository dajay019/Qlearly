package com.qlearly.automation.constants;

import com.qlearly.automation.config.ConfigReader;

public class ConfigValues {

  public final static String CRX_PATH = ConfigReader.get().getCrxPath();
  public final static String BROWSER = ConfigReader.get().getBrowser();

}
