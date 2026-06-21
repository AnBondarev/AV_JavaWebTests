package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.LoginMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredsMobTests extends MobileBaseTest {

    private static LoginMobPage loginMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void loginWrongCredsTest() {
        //Авторизация с некорректными кредами
        loginMobPage.login("user1234", "password1234");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(true, true), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginMobPage.getErrorMessageText(true, true);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginEmptyUsernameTest() {
        //Авторизация с некорректными кредами
        loginMobPage.login(null, "password1234");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(false, true), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginMobPage.getErrorMessageText(false, true);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginEmptyPasswordTest() {
        //Авторизация с некорректными кредами
        loginMobPage.login("user1234", null);

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(true, false), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginMobPage.getErrorMessageText(true, false);
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }
}
