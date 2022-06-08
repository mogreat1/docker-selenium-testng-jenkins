package tests;

import com.docker.StartDocker;
import com.docker.StopDocker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import com.testutils.TestUtils;

public class ChromerStandAlone2Test {

    @BeforeTest
    public void startDocker() throws IOException, InterruptedException {
        TestUtils testUtils = new TestUtils();
        testUtils.deleteOutputFile("output.txt");
        StartDocker startDocker = new StartDocker();
        startDocker.startHubAndScaleDockerNodes();
    }

    @AfterTest
    public void stopDockerAndDeleteOutputFile() throws IOException, InterruptedException {
        StopDocker stopDocker = new StopDocker();
        stopDocker.stopHubAndNodes();
    }

    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

        driver.get("https://www.gmail.com/");
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
