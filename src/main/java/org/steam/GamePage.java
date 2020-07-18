package org.steam;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.Utilities;

public class GamePage {
    private final WebDriver driver;

    @FindBy(className = "apphub_AppName")
    private WebElement gameName;

    public GamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void compareGameTitle(){
        String gamePageUrl = "https://store.steampowered.com/app/620/Portal_2/";
        String title = "Portal 2";

        Utilities.printMessage("Title: " + gameName.getText());
        Utilities.printMessage("URL: " + gamePageUrl);

        assert gamePageUrl.contains(Constants.STEAM_URL);
    }
}
