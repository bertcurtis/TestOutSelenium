import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

//The actual test script. One thing you'll notice is the URL being declared here. I think this is ideal as to allow for every test to have a different URL.
//This could easily be changed if needed
public class DeletePhishingEmailsTest extends TestBase
{
    public DeletePhishingEmailsTest()
    {
        super("http://testoutlivecontent.blob.core.windows.net/secpro2017v6-en-us/en-us/sims/windows/xsimengine.html?simpackage=windows&simfile=email_social_eng_secpro6.html&dev=true&automation=true");
    }
    @Test
    public void DeletePhishingEmails()
    {
        PhishingEmailRecognitionPage page = new PhishingEmailRecognitionPage(driver.Instance);

        waitForElementToBeVisible(page.header, 60);
        waitForElementToBeVisible(page.page, 20);
        page.ClickEmailCheckboxesAndDelete();
        page.ClickDone();
        waitForElementToBeVisible(page.modal, 10);
        Assert.assertTrue("Did not score 100%", page.ConfirmStringArray());
    }
}
