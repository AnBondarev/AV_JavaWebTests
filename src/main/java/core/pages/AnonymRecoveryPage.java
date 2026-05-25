package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[data-l='t,support']");

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
}
