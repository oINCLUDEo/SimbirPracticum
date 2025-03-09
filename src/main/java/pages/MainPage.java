package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    @FindBy(xpath = "//*[@id='name-input']")
    private SelenideElement nameField;
    @FindBy(xpath = "//*[@id='feedbackForm']/label[2]/input")
    private SelenideElement passwordField;
    @FindBy(xpath = "//input[@id='drink' + ]")
    private SelenideElement milkFavDrink;
    @FindBy(xpath = "//input[@id='drink']")
    private SelenideElement coffeeFavDrink;
    private SelenideElement favoriteColor;
    @FindBy(xpath = "//*[@id='feedbackForm']/label[2]/input")
    private SelenideElement automationPreference = $("#automation");
    @FindBy(xpath = "//*[@id='email']")
    private SelenideElement emailField;
    @FindBy(xpath = "//*[@id='message']")
    private SelenideElement messageField = $("#message");
    @FindBy(xpath = "//*[@id='submit-btn']")
    private SelenideElement submitButton = $("#submit");

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
    public MainPage selectFavoriteDrinks(String... drinks) {
        for (String drink : drinks) {
            favoriteDrinks.selectOption(drink);
        }
        return this;
    }

    @Step("Выбираем любимый цвет: {color}")
    public MainPage selectFavoriteColor(String color) {
        favoriteColor.selectOption(color);
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
}