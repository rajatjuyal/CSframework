package com.mystore.testcases;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.myaccount;
import com.mystore.pageobject.registeredUserAccount;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MAccountPageTest extends BaseClass{

    @Test(enabled = false)
    public void verifyRegistrationandLogin(){
        //launch browser from the baseclass @beforeclass method automatically
        //open url
          logger.debug("debug");
//        logger.error("error");
//        logger.warn("warn");
//        logger.info("info");
//        logger.trace("trace");
//        logger.fatal("fatal");


        IndexPage pg = new IndexPage(driver);
        pg.clickonSignin();
        myaccount acc = new myaccount(driver);
        acc.enterCreateEmailAddress("something@gmail.com");
        acc.clickSubmitCreate();
        logger.info("clicked on create an account button");

        accountCreationDetails accCreationPg = new accountCreationDetails(driver);


        accCreationPg.selectTitleMrs();
        accCreationPg.enterCustomerFirstName("Rajat");
        accCreationPg.enterCustomerLastName("Sharma");
        accCreationPg.enterPassword("cs923");
        accCreationPg.clickOnRegister();
        accCreationPg.setAddmyfirstaddressClick();
        accCreationPg.enterAddressFirstName("Rajat");
        accCreationPg.enterAddressLastName("Sharma");
        accCreationPg.enterAddress("18/8 worli road");

        accCreationPg.enterCity("Mumbai");
        accCreationPg.selectState("Alabama");

        accCreationPg.enterPostcode("00000");
        accCreationPg.selectCountry("United States");
        accCreationPg.enterMobilePhone("9891778192");
        accCreationPg.enterAlias("Home");

        logger.info("entered user details on account creation page.");


        logger.info("clicked on Register button");

        registeredUserAccount regUser = new registeredUserAccount(driver);
        String userName = regUser.getUserName();

        Assert.assertEquals("Rajat Sharma", userName);

        logger.info("***************TestCase Verify Registration and Login ends*****************");


    }

    @Test
    public void VerifyLogin() throws IOException, IOException {

        logger.info("***************TestCase Verify Login starts*****************");

        IndexPage pg = new IndexPage(driver);

        pg.clickonSignin();
        logger.info("Clicked on sign in link");

        myaccount myAcpg = new myaccount(driver);

        myAcpg.enterEmailAddress("cs923@gmail.com");
        logger.info("Entered email address");

        myAcpg.enterPassword("cs923");
        logger.info("Entered password");

        myAcpg.clickSignIn();
        logger.info("Clicked on sign in link..");


        registeredUserAccount regUser = new registeredUserAccount(driver);
        String userName = regUser.getUserName();


        if(userName.equals("Prachi Gupta"))
        {
            logger.info("VerifyLogin - Passed");
            regUser.clickOnSignOut();
            Assert.assertTrue(true);
        }
        else
        {
            logger.info("VerifyLogin - Failed");
            captureScreenshot(driver,"VerifyLogin");
            Assert.assertTrue(false);

        }

        logger.info("***************TestCase Verify Login ends*****************");


    }
}
