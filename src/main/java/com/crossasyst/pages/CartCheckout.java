package com.crossasyst.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartCheckout {
    @FindBy(xpath = "//p/*[@title='Proceed to checkout']")
    private WebElement proceedToCheckout;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "passwd")
    private WebElement passwordFeild;
    @FindBy(id = "SubmitLogin")
    private WebElement signinField;
}
