import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/form-fields/");
    }

    @Test(description = "Тест на заполнение и отправку формы")
    public void testFormSubmission() {
        List<String> automationTools = Arrays.asList("Selenium Webdriver", "CSS", "XPath", "ID", "TestNG", "JUnit", "PyTest", "Maven", "Gradle");
        String longestTool = automationTools.stream().max(Comparator.comparingInt(String::length)).orElse("");

        page(MainPage.class)
                .enterName("Test User")
                .enterPassword("password123")
                .selectFavoriteDrinks("Milk", "Coffee")
                .selectFavoriteColor("Yellow")
                .selectAutomationPreference("Yes")
                .enterEmail("name@example.com")
                .enterMessage(automationTools.size() + " " + longestTool)
                .submitForm();
    }
}
