package org.steam;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.Utilities;

public class GamePage {
    private final WebDriver driver;

    @FindBy(className = "apphub_AppName")
    private WebElement gameName;

    public GamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateGamePage(){
        String gamePageUrl = "https://store.steampowered.com/app/620/Portal_2/";
        String title = "Portal 2";

        if((gamePageUrl.contains(Constants.STEAM_URL)) && (gameName.getText().contentEquals(title))){
            Utilities.printMessage("Title: " + gameName.getText());
            Utilities.printMessage("URL: " + gamePageUrl);
        }
    }
}
