package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCreds extends BaseTest {

    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void loginWrongCredsTest() {
        //Авторизация с некорректными кредами
        loginPage.login("user1234", "password1234");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(true, true), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginPage.getErrorMessageText(true, true);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginEmptyUsernameTest() {
        //Авторизация с некорректными кредами
        loginPage.login(null, "password1234");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(false, true), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getErrorMessageText(false, true);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginEmptyPasswordTest() {
        //Авторизация с некорректными кредами
        loginPage.login("user1234", null);

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(true, false), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPage.getErrorMessageText(true, false);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }
}
