package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class Config extends TestData{
    // init Driver
    public static WebDriver driver;

    // Setup browser type
    public static WebDriver setupBrowser (String browser){
        if (browser.equalsIgnoreCase("Ch")){
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            ops.addArguments("--incognito");
            driver = new ChromeDriver(ops);
        } else if (browser.equalsIgnoreCase("ff")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}