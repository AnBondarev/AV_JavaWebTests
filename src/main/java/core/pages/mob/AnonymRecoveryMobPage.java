package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryMobPage {

    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[data-l='t,support']");
    private SelenideElement supportChat = $("[data-l10n='accessibility.ui,anonym-support-chat']");
    private SelenideElement closeSupportChat = $("[title='Закрыть чат со службой поддержки']");
    private SelenideElement acceptYesButton = $x("//button[.//span[normalize-space()='Да']]");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов страницы")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажать - восстановить через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажать - восстановить через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Нажать - обратиться в службу поддержки")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Получить элемент - чат техподдержки")
    public SelenideElement getSupportChat() {
        return supportChat;
    }

    @Step("Закрыть чат с техподдержкой с подтверждением")
    public void closeSupportChat() {
        closeSupportChat.shouldBe(visible, Duration.ofSeconds(10)).click(); //Увеличил таймаут на ожидание загрузки
        acceptYesButton.shouldBe(visible).click();
    }
}
