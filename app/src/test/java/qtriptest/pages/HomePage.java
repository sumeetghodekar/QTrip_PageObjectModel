package qtriptest.pages;

import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
    RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(xpath = "//div[text()='Logout']")
    WebElement logoutBtn;

    @FindBy(xpath = "//input[@class='hero-input']")
    WebElement searchtextBox;

    @FindBy(xpath = "//ul[@id='results']/h5")
    WebElement noresult;

    @FindBy(xpath = "//ul[@id='results']/a")
    List<WebElement> cityResults;

    @FindBy(xpath = "//a[text()='Login Here']")
    WebElement loginbtn;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerbtn;



    public boolean isRegitserVisible() throws InterruptedException
    {
        Thread.sleep(3000);
        return registerbtn.isDisplayed() && registerbtn.isEnabled();
    }

    public void navigatetoRegister()
    {
        System.out.println("Navigating to Register page");
        Actions action=new Actions(driver);
        action.moveToElement(registerbtn).click().build().perform();
    }

    public boolean navBarOption(String option) throws InterruptedException
    {
        Thread.sleep(3000);
        boolean flag=false;
        Actions action=new Actions(driver);
        action.moveToElement(this.logoutBtn).build().perform();

        if(option.equalsIgnoreCase("Logout"))
        {
            flag=logoutBtn.isDisplayed();
        }
        if(option.equalsIgnoreCase("Home"))
        {
            flag=true;
        }
        if(option.equalsIgnoreCase("Reservation"))
        {
            flag=true;
        }
        return flag;
    }

    public void performLogout() {
        System.out.println("Performing Logout");
        Actions action = new Actions(driver);
        action.moveToElement(logoutBtn).click().build().perform();
    }
}