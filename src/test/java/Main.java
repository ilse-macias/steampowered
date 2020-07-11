import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.steam.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

    private WebDriver driver;
    private WebElement webElement;

    @BeforeTest()
    public void Setup(){
        System.setProperty(Constants.VALUE_DRIVER_SET_PROPERTY, Constants.PATH_SET_PROPERTY);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(Constants.PRACTICE_SELENIUM_URL);
    }

    @Test()
    public void SearchGameTest(){
        String title = driver.getTitle();
        System.out.println(title);

        HomePage homePage = new HomePage(driver);
        homePage.SearchAGame("Portal 2");

    }

    @AfterTest()
    public void TearDown(){
        driver.close();
        driver.quit();
    }

}
