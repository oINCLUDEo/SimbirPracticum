package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    @FindBy(xpath = "//*[@id='name-input']")
    private SelenideElement nameField;
    @FindBy(xpath = "//*[@id='feedbackForm']/label[2]/input")
    private SelenideElement passwordField;
    private final SelenideElement automationPreference = $("#automation");
    @FindBy(xpath = "//*[@id='email']")
    private SelenideElement emailField;
    @FindBy(xpath = "//*[@id='message']")
    private SelenideElement messageField;
    @FindBy(xpath = "//*[@id='submit-btn']")
    private SelenideElement submitButton;

    @Step("Вводим имя: {name}")
    public MainPage enterName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Вводим пароль")
    public MainPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Выбираем любимые напитки: {drinks}")
    public MainPage selectDrinkByNumber(int drinkNumber) {
        $x("//*[@id='drink" + drinkNumber + "']").setSelected(true);
        return this;
    }

    @Step("Выбираем любимый цвет: {color}")
    public MainPage selectFavoriteColor(String colorName) {
        $x("//input[@name='fav_color'][@value='" + colorName + "']").click();
        return this;
    }

    @Step("Выбираем вариант в 'Do you like automation?': {option}")
    public MainPage selectAutomationPreference(String option) {
        automationPreference.selectOption(option);
        return this;
    }

    @Step("Вводим Email: {email}")
    public MainPage enterEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Вводим сообщение: {message}")
    public MainPage enterMessage(String message) {
        messageField.setValue(message);
        return this;
    }

    @Step("Отправляем форму")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Проверяем, что появилось сообщение о получении формы")
    public void verifySuccessMessage() {
        Alert alert = switchTo().alert();
        String alertText = alert.getText();

        assert alertText.equals("Message received!") : "Текст Алерта отличается от 'Message received!'";

        alert.accept();
    }

}
