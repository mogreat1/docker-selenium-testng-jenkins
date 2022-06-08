package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxStandAlone3Test {

    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @Test
    public void test2() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
