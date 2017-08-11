
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runners.model.FrameworkMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.notification.RunListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//This is the Test base, all tests would inherit from here. I struggled with knowing where I should put the 2 wait methods. I originally
// had them in the Base Page but ended up putting them here, so that all of the child classes could easily use the methods without having to instantiate amy objects


public abstract class TestBase extends BasePage {

    public TestBase(String url)
    {
        _URL = url;
    }
    public TestBase()
    {
        _URL = "www.google.com";
    }
    public static String _URL;
    JUnitCore junit = new JUnitCore();
    RunListener listener = new RunListener();


    @Before
    public void setup()
    {
        driver = new Driver();
        junit.addListener(listener);
        driver.Instance.get(_URL);
    }

    @After
    public void quitDriver()
    {
        takeScreenShot("screenshot");
        driver.Instance.quit();
    }

    public void waitForElementToBeVisible(By selector, int timeToWaitInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver.Instance, timeToWaitInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public void implicitWait(long seconds)
    {
        driver.Instance.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public void takeScreenShot(String fileName)
    {
        try {
            File scrFile = ((TakesScreenshot)driver.Instance).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Melanie\\TestOutSelenium\\" + fileName + ".jpg"));
        } catch (Exception e) {
            // No need to crash the tests if the screenshot fails
        }
    }


}
