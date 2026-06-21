package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoverySupportTests extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void goToSupportChatTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        anonymRecoveryPage.getSupportChat().shouldBe(visible);
        anonymRecoveryPage.closeSupportChat();
    }

}
