package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobPage;
import core.pages.mob.LoginMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryByEmailMobTests extends MobileBaseTest {

    private static LoginMobPage loginMobPage;
    private static AnonymRecoveryMobPage anonymRecoveryMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void anonymRecoveryByEmailTest() {
        //Авторизация с некорректными кредами
        loginMobPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginMobPage.setPassword("1");
            loginMobPage.clickLogin();
        }

        loginMobPage.goToRecovery();
        anonymRecoveryMobPage = new AnonymRecoveryMobPage();
        anonymRecoveryMobPage.goToRecoveryByEmail();
    }
}
