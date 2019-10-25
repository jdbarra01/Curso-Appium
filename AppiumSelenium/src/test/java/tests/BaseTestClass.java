package tests;


import io.appium.java_client.AppiumDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomeApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTestClass {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    protected AppiumDriver driver = null;


    private String nombre = "Nadia";

    @Before
    public void setUp() throws MalformedURLException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app/Android");
        File app = new File(appDir, "Contacts.apk");

        capabilities.setCapability("deviceName", "Pixel 2 API 29");
        capabilities.setCapability("udid", "emulator-5554");

        //capabilities.setCapability("deviceName", "Galaxy S9");
        //capabilities.setCapability("udid", "3336574f59563398");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        capabilities.setCapability("appPackage", "com.jayway.contacts");
        capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }


    @Test
    public void test() {
        HomeApp homeApp = new HomeApp(driver);

        homeApp.buscar(nombre);
        homeApp.resultadoBusqueda("Nadia Patten");
    }


    @Test
    public void testNueva() {
        HomeApp homeApp = new HomeApp(driver);

        homeApp.buscar(nombre);
        homeApp.resultadoBusqueda("Nadia Patten");
    }



    @Test
    public void testTres() {
        HomeApp homeApp = new HomeApp(driver);

        homeApp.buscar(nombre);
        homeApp.resultadoBusqueda("Nadia Patten");
    }



    @After
    public void tearDown() {
        // driver.quit();
    }


}
