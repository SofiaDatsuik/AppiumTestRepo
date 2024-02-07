package test;


import common.connector.DriverManager;
import common.listener.CustomListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners(CustomListener.class)
public class FunctionalTest {


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DriverManager.getDriver();
    }

    @AfterTest
    public static void tearDown() throws MalformedURLException {
        DriverManager.closeDriver();
    }

}
