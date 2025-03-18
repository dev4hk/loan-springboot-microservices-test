package utils;

import page_objects.PageObjectManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private TestBase testBase;

    private Map<String, String> credentials;

    public TestContext() throws IOException {
        this.testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(this.testBase.initDriver());
        this.credentials = new HashMap<>();
        this.setupCredentials();
    }

    private void setupCredentials() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties props = new Properties();
        props.load(fis);
        credentials.put("username", props.getProperty("username"));
        credentials.put("password", props.getProperty("password"));
        credentials.put("email", props.getProperty("email"));
        credentials.put("firstname", props.getProperty("firstname"));
        credentials.put("lastname", props.getProperty("lastname"));
        fis.close();
    }

    public Map<String, String> getCredentials() {
        return this.credentials;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public TestBase getTestBase() {
        return testBase;
    }

}
