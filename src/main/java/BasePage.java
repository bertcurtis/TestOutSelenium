
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


// This is the Base class for all of the DOM elements. All pages would inherit from this one, or a sub base class from this one. The only logic
//contained here would be the logic that's universal across all of the child pages.
public abstract class BasePage
{
    public BasePage()
    {

    }
    public BasePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public Driver driver;
    @FindBy(how = How.ID, using = "bDone.Grid.Border.NormalElement.Border")
    private WebElement doneButton;

    public void ClickDone()
    {
        doneButton.click();
    }

}
