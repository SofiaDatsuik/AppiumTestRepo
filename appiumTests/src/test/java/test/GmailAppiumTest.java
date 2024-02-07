package test;

import common.listener.CustomListener;
import common.pom.LoginPage;
import common.util.JSONReader;
import common.util.UserData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Listeners(CustomListener.class)
public class GmailAppiumTest {
    private static AndroidDriver<MobileElement> driver;
    private JSONReader jsonReader = new JSONReader();


    @Ignore
    @Test(dataProvider = "user")
    public static void writeGmailMessage(UserData userData) throws MalformedURLException {
        LoginPage loginPage = new LoginPage();
        loginPage.goToGmailAccount();
        loginPage.addNewGmailAccount(userData.getUserEmail(), userData.getPassword());
        Assert.assertTrue(loginPage.verifyCorrectData(), "User add new correct account");
        loginPage.clickAcceptButton();

    }

    @Test
    public static void selectForgotPasswordButton() throws MalformedURLException {
        LoginPage loginPage = null;
        try {
            loginPage = new LoginPage();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        loginPage.goToGmailAccount();
        loginPage.clickForgotEmailButton();
    }

    @DataProvider(parallel = true)
    public Object[] user() throws FileNotFoundException {
        return jsonReader.getData();
    }

}
