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
        credentials.put("customer_username", props.getProperty("customer_username"));
        credentials.put("customer_password", props.getProperty("customer_password"));
        credentials.put("customer_email", props.getProperty("customer_email"));
        credentials.put("customer_firstname", props.getProperty("customer_firstname"));
        credentials.put("customer_lastname", props.getProperty("customer_lastname"));
        credentials.put("manager_username", props.getProperty("manager_username"));
        credentials.put("manager_password", props.getProperty("manager_password"));
        credentials.put("manager_email", props.getProperty("manager_email"));
        credentials.put("manager_firstname", props.getProperty("manager_firstname"));
        credentials.put("manager_lastname", props.getProperty("manager_lastname"));
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
