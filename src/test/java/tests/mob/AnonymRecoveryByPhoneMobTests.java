package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobPage;
import core.pages.mob.AnonymRecoveryPhoneLinkMobPage;
import core.pages.mob.LoginMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhoneMobTests extends MobileBaseTest {

    private static LoginMobPage loginMobPage;
    private static AnonymRecoveryMobPage anonymRecoveryMobPage;
    private static AnonymRecoveryPhoneLinkMobPage anonymRecoveryPhoneLinkMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        //Авторизация с некорректными кредами
        loginMobPage.login("incorrectUser", "incorrectPassword");
        //Цикл - нажать Войти 3 раза
        for (int i = 0; i < 2; i++) {
            loginMobPage.setPassword("1");
            loginMobPage.clickLogin();
        }
        //Переход на страницу восстановления доступа по номеру телефона
        loginMobPage.goToRecovery();
        anonymRecoveryMobPage = new AnonymRecoveryMobPage();
        anonymRecoveryMobPage.goToRecoveryByPhone();
        anonymRecoveryPhoneLinkMobPage = new AnonymRecoveryPhoneLinkMobPage();
        //Выбор страны
        String countryCode = anonymRecoveryPhoneLinkMobPage.selectCountryByName("Нидерланды (Голландия)");
        assertEquals("+31", countryCode, "Код страны не совпадает с ожидаемым");
        //Нажать Получить код и проверка сообщения об ошибке
        anonymRecoveryPhoneLinkMobPage.getCodeButtonClick();
        assertTrue(anonymRecoveryPhoneLinkMobPage.isErrorIncorrectPhoneNumber(), "Сообщение о неправильном номере телефона не отображается");
        String expectedErrorPhoneNumber = "Неправильный номер телефона.";
        String actualErrorPhoneNumber = anonymRecoveryPhoneLinkMobPage.getErrorIncorrectPhoneNumber();
        assertEquals(expectedErrorPhoneNumber, actualErrorPhoneNumber, "Текст сообщения о неправильном номере телефона не совпадает с ожидаемым");
    }
}
