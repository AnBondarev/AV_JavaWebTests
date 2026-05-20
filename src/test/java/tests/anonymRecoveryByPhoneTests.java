package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.anonymRecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class anonymRecoveryByPhoneTests extends BaseTest {

    private static LoginPage loginPage;
    private static anonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        //Авторизация с некорректными кредами
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new anonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
    }
}
