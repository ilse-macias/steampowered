import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test() //done
    public void searchGameTest() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);

        HomePage homePage = new HomePage(driver);
        homePage.SearchAGame("Portal");

        //This is just for the humans can see the result.
        Thread.sleep(5000);
    }

    @Test //DONE
    public void validateTheGameIsRedirectingToThePage(){
        HomePage homePage = new HomePage(driver);
        homePage.SearchAGame("Portal");

        homePage.clickonSearchIcon();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickOnTheGame();
    }

    @Test()
    public void clearSearchFieldAndSearchAnotherGame() throws InterruptedException {
        searchGameTest();

        HomePage homePage = new HomePage(driver);
        homePage.clearGame("Age of Empires");
    }

    @Test()
    public void selectAGameOptionTest() throws InterruptedException {
       searchGameTest();
        GameSearchResult searchResult = new GameSearchResult(driver);
       // WebElement searchDropDownList = driver.findElement(By.id("searchterm_options"));
        searchResult.ListResult();
        System.out.println("Entro?");
    }

    @AfterClass()
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
