package org.steam;

import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(GamePage.class);

    @FindBy(className = "apphub_AppName")
    private WebElement gameName;

    public GamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void compareGameTitle(){
        String gamePageUrl = "https://store.steampowered.com/app/620/Portal_2/";
        String title = "Portal 2";

        logger.debug("Debug test");
        System.out.println("Title: " + gameName.getText());
        System.out.println("URL: " + gamePageUrl);

        assert gamePageUrl.contains(Constants.STEAM_URL);
    }
}
