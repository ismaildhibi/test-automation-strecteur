package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static void lunchBrowser() throws IOException {
       // --------- Local-----------//
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        //--------- Jenkins-----------//
//        ChromeOptions capabilities = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL(System.getenv("API")), capabilities);
//        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

        //---- Jenkins + Local-------//
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
