import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.steam.GamePage;
import org.steam.HomePage;
import org.steam.SearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SteamExecutionsTest {

    private WebDriver driver;
    private WebElement webElement;

    @BeforeClass()
    public void setup(){
        System.setProperty(Constants.VALUE_DRIVER_SET_PROPERTY, Constants.PATH_SET_PROPERTY);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(Constants.STEAM_URL);
    }

    @Test()
    public void searchGameTest() throws InterruptedException {
        String title = driver.getTitle();
        String gameName = "Portal";

        System.out.println(title);
        Assert.assertEquals(title, "Welcome to Steam");

        HomePage homePage = new HomePage(driver);
        homePage.searchGame(gameName);
        Assert.assertEquals(gameName, "Portal");

        //This is just for the humans can see the result.
        Thread.sleep(5000);
    }

    @Test
    public void validateTheGameIsRedirectingToThePage(){
        String gameName = "Portal";

        HomePage homePage = new HomePage(driver);
        homePage.searchGame(gameName);
        homePage.clickonSearchIcon();
        Assert.assertEquals(gameName, "Portal");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickOnTheGame();

        GamePage gamePage = new GamePage(driver);
        gamePage.compareGameTitle();
    }

    //FIXME
    @Test(enabled = false)
    public void clearSearchFieldAndSearchAnotherGame() throws InterruptedException {
        searchGameTest();

        HomePage homePage = new HomePage(driver);
        homePage.searchGame("Age of Empires");

        homePage.clickonSearchIcon();
    }

    @AfterClass()
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
