import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.steam.GamePage;
import org.steam.GameSearchResult;
import org.steam.HomePage;
import org.steam.SearchPage;
import org.testng.annotations.*;

public class Main {

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
        System.out.println(title);

        HomePage homePage = new HomePage(driver);
        homePage.searchAGame("Portal");

        //This is just for the humans can see the result.
        Thread.sleep(5000);
    }

    @Test
    public void validateTheGameIsRedirectingToThePage(){
        HomePage homePage = new HomePage(driver);
        homePage.searchAGame("Portal");

        homePage.clickonSearchIcon();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickOnTheGame();

        GamePage gamePage = new GamePage(driver);
        gamePage.validateGamePage();
    }

    @Test() //  NO FIXED.
    public void clearSearchFieldAndSearchAnotherGame() throws InterruptedException {
        searchGameTest();

        HomePage homePage = new HomePage(driver);
        homePage.searchAGame("Age of Empires");

        homePage.clickonSearchIcon();
    }

    @AfterClass()
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
