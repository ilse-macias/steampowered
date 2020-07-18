package org.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchBar;

    @FindBy(css = "#store_search_link > img")
    private WebElement searchIcon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchGame(String gameName) {
        searchBar.sendKeys((gameName));
        Utilities.printMessage(gameName);

        WebElement listGame = driver.findElement(By.id("searchterm_options"));
        //Utilities.waitWhenTheElementIsClickeable(listGame);
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
               // .frameToBeAvailableAndSwitchToIt(By.id("searchterm_options")));
                .visibilityOfElementLocated(By.id("searchterm_options")));
                //.visibilityOfAllElements(listGame));
    }

    public void clickonSearchIcon(){
        searchIcon.click();
        Utilities.printMessage("Button clicked.");
    }

    public void clearGame(String gameName){
        searchBar.clear();
        searchBar.sendKeys(gameName);
        Utilities.printMessage(gameName);
    }

    //This module maybe will be delete.
    public void listGame(){
        WebElement listDropDownList =
                driver.findElement(By.id("search_suggestion_contentssearch_suggestion_contents"));
        Utilities.printMessage("Fundiona");
        Utilities.waitWhenTheElementIsClickeable(listDropDownList);
        Utilities.printMessage("Fundiona");
    }
}
