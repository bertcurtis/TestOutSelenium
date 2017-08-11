
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//This class contains all of the logic to be used in the actual test. I prefer page factory as it initialises all of the elements on instantiation
public class PhishingEmailRecognitionPage extends BasePage
{
    public PhishingEmailRecognitionPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_1;
    @FindBy(how = How.ID, using = "cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_2;
    @FindBy(how = How.ID, using = "cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_3;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem2.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_4;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem3.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_5;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem4.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_6;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem5.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_7;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem6.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_8;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem7.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_9;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem8.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_10;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem9.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_11;
    @FindBy(how = How.ID, using = "InnerElement.ItemsPresenter.StackPanel.ListBoxItem10.Grid.cContentControl.cpContentPresenter.MailItem.Grid.cbCheckBox.Grid.Grid.Border")
    private WebElement email_12;
    @FindBy(how = How.XPATH, using = "//span[.='Delete']")
    private WebElement deletebutton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'clsBoxText2') and text()='Your Score: 8 of 8 (100%)']")
    public WebElement confirm;

    public By header = new By.ById("gHeader");

    public By page = new By.ById("MailItem.Grid.cbCheckBox.Grid.Grid.Border");

    public By modal = new By.ById("svResults");


    public void ClickEmailCheckboxesAndDelete()
    {
        WebElement[] emailsToDelete = {email_1, email_3, email_4, email_5, email_6, email_7, email_8, email_10};
        for (int i = 0; i <emailsToDelete.length; i++) {
            emailsToDelete[i].click();
        }
        deletebutton.click();
    }
    public boolean ConfirmStringArray()
    {
        return new String(confirm.getText().split("\\n+")[0]).equals("Your Score: 8 of 8 (100%)");
    }





}
