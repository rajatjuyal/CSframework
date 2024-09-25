package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    WebDriver ldriver;
    public IndexPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    //Identify webelement
    @FindBy(linkText = "Sign in")
    WebElement signinLink;

    //action on webelement
    public void clickonSignin(){
        signinLink.click();
    }

}
