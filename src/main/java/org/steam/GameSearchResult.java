package org.steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//I'll delete this class, because it throws dynamic results.
public class GameSearchResult {
    private final WebDriver driver;
    @FindBy(id = "searchterm_options")
    //(className = "search_suggestion_contents")
    private WebElement gameResultDropDown;

    @FindBy(xpath = "//*[@id=search_suggestion_contents]/a[1]")
    private WebElement selectSpecificGame;

    public GameSearchResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //DON'T DELETE THIS, I NEED TO REPRODUCE THE TEST CASE, USER NEEDS TO CLICK ON AN ELEMENT FROM THE DDL.
    public void listResult() throws InterruptedException {
        //VERIFY THE RESULT ARE ADDED ON THE LIST.
        /*
        class = "match ds_collapse_flag  app_impression_tracked focus" <- ciclo para buscar element por element
        cssSelector = "#search_suggestion_contents > a:nth-child(1)" <- Specific element.
//*[@id="search_suggestion_contents"]/a[1]
        * */

       // Utilities.waitTime(gameResultDropDown);
        Assert.assertNotNull(gameResultDropDown);
        System.out.println("It's working!");

       // WebElement selectSpecificGame =
         //       driver.findElement(By.xpath("//*[@id=search_suggestion_contents]/a[1]"));

        //Here is not working... i don't know why!
        System.out.println(selectSpecificGame.getText());
        selectSpecificGame.click();
        Thread.sleep(5000);
        System.out.println("That works");
    }
}
