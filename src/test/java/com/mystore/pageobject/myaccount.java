package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaccount {

    WebDriver ldriver;
    public myaccount(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    //Identify webelement
    @FindBy(id = "email_create")
    WebElement createEmailId;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;

    //Already registered users
    @FindBy(id = "email")
    WebElement registeredUsersEmail;

    @FindBy(id = "passwd")
    WebElement registeredUsersPwd;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;



    //action on webelement
    public void enterCreateEmailAddress(String emailId){
        createEmailId.sendKeys(emailId);
    }

    public void clickSubmitCreate(){
        submitCreate.click();
    }

    //ACTIONS METHODS FOR ALREADY REGISTERED USERS

    public void enterEmailAddress(String emailAdd)
    {
        registeredUsersEmail.sendKeys(emailAdd);
    }

    public void enterPassword(String pwd)
    {
        registeredUsersPwd.sendKeys(pwd);
    }


    public void clickSignIn()
    {
        submitLogin.click();
    }


}
