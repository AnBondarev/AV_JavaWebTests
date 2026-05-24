package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPhoneLinkPage extends BasePage {

    //Поле ввода телефона
    private SelenideElement phoneInputField = $("[name='st.r.phone']");
    //Кнопка выбора страны
    private SelenideElement countryDropdown = $x("//div[@data-l='t,country']");
    //Кнопка Получить код
    private SelenideElement getCodeButton = $("[data-l='t,submit']");
    //Ошибка Неправильный номер телефона
    private SelenideElement errorIncorrectPhoneNumber = $("[class='input-e js-ph-vl-hint']");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов страницы")
    private void verifyPageElements() {
        phoneInputField.shouldBe(visible);
        countryDropdown.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Выбрать код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        //Открыть список стран
        countryDropdown.click();
        //Найти нужную строку по названию
        SelenideElement coutryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        //Скролл до нужной строки
        coutryItem.scrollTo();
        //Получить код страны и записать в переменную
        String countryCode = coutryItem.find(".country-select_code").text();
        coutryItem.click();
        return countryCode;
    }

    @Step("Нажать на кнопку Получить код")
    public void getCodeButtonClick() {
        getCodeButton.shouldBe(visible).click();
    }

    @Step("Получить текст сообщения о неправильном номере телефона")
    public String getErrorIncorrectPhoneNumber() {
        return errorIncorrectPhoneNumber.shouldBe(visible).getText();
    }

    @Step("Проверка видимости сообщения о неправильном номере телефона")
    public boolean isErrorIncorrectPhoneNumber() {
        return errorIncorrectPhoneNumber.shouldBe(visible).exists();
    }
}
