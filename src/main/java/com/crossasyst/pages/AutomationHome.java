package com.crossasyst.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationHome {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "login")
    private WebElement singInButton;

    @FindBy(xpath = "//li/*[@title='Women']")
    private WebElement womenItems;
    @FindBy(xpath = "//div[@id='block_top_menu']//li[1]//*[@title='T-shirts']")
    private WebElement womenTShirts;

    public AutomationHome(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void signIn(){
        singInButton.click();
    }

    public void selectTShirts() {
        Actions action = new Actions(driver);
        action.moveToElement(womenItems).perform();

    }

}
