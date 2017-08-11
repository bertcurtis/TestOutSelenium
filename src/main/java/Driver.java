import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

//Putting the driver in a separate class allows you more flexibility when choosing what driver to run the tests per the environment specs.
//It also makes it so if something breaks you only have to change it once.
public class Driver extends BasePage
{
    // This ideally would be taken from a Jenkins file or some sort of CI to tell the tests what browser to run on.
    public String globalVariableFromCI = "FireFox";


    //This will set the driver to whatever is received from the global variable or file, depending on how the tests are configured to run. I only have it
    // configured to use these 2 browsers but could easily add more
    public Driver()//(String url)
    {
        //_URL = url;
        if (globalVariableFromCI == "FireFox")
            FireFoxDriverConfigured();
        else if(globalVariableFromCI == "Chrome")
            ChromeDriverConfigured();

    }
    public WebDriver Instance;

    private void ChromeDriverConfigured()
    {
        String chromeDriverLocation = "C:/Users/Melanie/TestOutSelenium/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        Instance = new ChromeDriver(options);
    }
    private void FireFoxDriverConfigured()
    {
        Instance = new FirefoxDriver();
    }
}
