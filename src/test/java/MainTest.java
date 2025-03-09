import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;


public class MainTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/form-fields/");
    }

    @Test(description = "Тест на заполнение и отправку формы")
    public void testFormSubmission() {
        MainPage mainPage = page(MainPage.class);
        List<String> automationTools = Arrays.asList("Selenium",
                "Playwright",
                "Cypress",
                "Appium",
                "Katalon Studio");
        String longestTool = automationTools.stream().max(Comparator.comparingInt(String::length)).orElse("");

        mainPage.enterName("Test User")
                .enterPassword("password123")
                .selectDrinkByNumber(2)
                .selectDrinkByNumber(3)
                .selectFavoriteColor("Yellow")
                .selectAutomationPreference("Yes")
                .enterEmail("name@example.com")
                .enterMessage(automationTools.size() + " " + longestTool)
                .submitForm();
        mainPage.verifySuccessMessage();

        sleep(3000);
    }
}
