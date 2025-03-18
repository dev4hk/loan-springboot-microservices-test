package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;
    private String rootUrl;

    public WebDriver initDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties props = new Properties();
        props.load(fis);
        this.rootUrl = props.getProperty("rootUrl");
        String browser_properties = props.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;

        fis.close();

        if (this.driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                this.driver = new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")) {
                this.driver = new FirefoxDriver();
            }
            if (browser.equalsIgnoreCase("edge")) {
                this.driver = new EdgeDriver();
            }
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            this.driver.get(this.rootUrl);
            this.driver.manage().window().maximize();
        }
        return this.driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getRootUrl() {
        return this.rootUrl;
    }
}
