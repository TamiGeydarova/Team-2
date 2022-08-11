package testRunners;

import com.cucumber.listener.Reporter;
import core.config.YamlConfig;
import core.config.YamlFileManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.awt.color.ICC_Profile;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Here some tags can be set, for example, tags = {"@Example", "~@ignore"},
        tags = {"@smokeTest"},
    //    plugin = {"html:target/cucumber", "json:target/cucumber.json"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber/index.html"},
        features = {"src/test/resources/features/shoppingcart_v.feature"},
        glue = {"stepDefinitions"}
)



public class UniversalRunner {
    private static YamlConfig config = YamlFileManager.getProjectConfigurations();
    private static String configPath = config.getConfiguration("reporting.reportConfigPath");
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(configPath));
    }
}
