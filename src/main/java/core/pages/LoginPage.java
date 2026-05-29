package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    //Основные элементы
    private SelenideElement usernameField = $("[id='field_email']");
    private SelenideElement passwordField = $("[id='field_password']");
    private SelenideElement loginButton = $("[label='Войти']");
    private SelenideElement forgotPasswordLink = $("[aria-label='Не получается войти?']");
    private SelenideElement registrationButton = $x("//button[.//span[normalize-space()='Зарегистрироваться']]");
    private SelenideElement tabQRcode = $("[data-l='t,qr_tab']");
    private SelenideElement imgQRcode = $("[class='qr_code_image']");

    //Кнопка восстановления аккаунта
    private SelenideElement goToRecoveryButton = $x("//span[normalize-space()='Восстановить']");

    //Кнопки соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailruButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");

    //Элементы с сообщением об ошибке
    private SelenideElement errorMessage = $x("//span[normalize-space()='Неправильно указан логин и/или пароль']");
    private SelenideElement errorMessagePassword = $x("//span[normalize-space()='Введите пароль']");
    private SelenideElement errorMessageUsername = $x("//span[normalize-space()='Введите логин']");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        tabQRcode.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailruButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Проверка видимости сообщения об ошибке входа: логин-{username} и пароль-{password}")
    public boolean isErrorMessageVisible(boolean isUsername, boolean isPassword) {
        if (!isUsername && isPassword) {
            return errorMessageUsername.shouldBe(visible).exists();
        }
        if (isUsername && !isPassword) {
            return errorMessagePassword.shouldBe(visible).exists();
        }
        if (isUsername && isPassword) {
            return errorMessage.shouldBe(visible).exists();
        }

        //Если ничего не ввести
        return errorMessageUsername.shouldBe(visible).exists();
    }

    @Step("Получить текст сообщения об ошибке входа")
    public String getErrorMessageText(boolean isUsername, boolean isPassword) {
        if (!isUsername && isPassword) {
            return errorMessageUsername.shouldBe(visible).getText();
        }
        if (isUsername && !isPassword) {
            return errorMessagePassword.shouldBe(visible).getText();
        }
        if (isUsername && isPassword) {
            return errorMessage.shouldBe(visible).getText();
        }

        //Если ничего не ввести
        return errorMessageUsername.shouldBe(visible).getText();
    }

    @Step("Авторизация на сайте: логин-{username} и пароль-{password}")
    public void login(String username, String password) {
        if (username != null) {
            usernameField.shouldBe(visible).click();
            usernameField.shouldBe(visible).setValue(username);
        }
        if (password != null) {
            passwordField.shouldBe(visible).click();
            passwordField.shouldBe(visible).setValue(password);
        }
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажать кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Авторизация на сайте с логином {username} и пустым паролем")
    public void loginWithUsername(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Авторизация на сайте с пустым логином и паролем {password}")
    public void loginWithPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Перейти на вкладку QR-код для авторизации")
    public void goToQRcode() {
        tabQRcode.shouldBe(visible).click();
    }

    @Step("Получить QR-код")
    public SelenideElement getImgQRcode() {
        return imgQRcode;
    }

    @Step("Восстановить аккаунт")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Переход на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переход на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Авторизация через ВК")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Авторизация через Mail")
    public void loginWithMail() {
        mailruButton.shouldBe(visible).click();
    }

    @Step("Авторизация через YandexID")
    public void loginWithYandexID() {
        yandexButton.shouldBe(visible).click();
    }
}
