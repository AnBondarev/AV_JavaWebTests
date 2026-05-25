package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryPhoneLinkPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhoneTests extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static AnonymRecoveryPhoneLinkPage anonymRecoveryPhoneLinkPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        //Авторизация с некорректными кредами
        loginPage.login("incorrectUser", "incorrectPassword");
        //Цикл - нажать Войти 3 раза
        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }
        //Переход на страницу восстановления доступа по номеру телефона
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPhoneLinkPage = new AnonymRecoveryPhoneLinkPage();
        //Выбор страны
        String countryCode = anonymRecoveryPhoneLinkPage.selectCountryByName("Нидерланды (Голландия)");
        assertEquals("+31", countryCode, "Код страны не совпадает с ожидаемым");
        //Нажать Получить код и проверка сообщения об ошибке
        anonymRecoveryPhoneLinkPage.getCodeButtonClick();
        assertTrue(anonymRecoveryPhoneLinkPage.isErrorIncorrectPhoneNumber(), "Сообщение о неправильном номере телефона не отображается");
        String expectedErrorPhoneNumber = "Неправильный номер телефона.";
        String actualErrorPhoneNumber = anonymRecoveryPhoneLinkPage.getErrorIncorrectPhoneNumber();
        assertEquals(expectedErrorPhoneNumber, actualErrorPhoneNumber, "Текст сообщения о неправильном номере телефона не совпадает с ожидаемым");
    }
}
