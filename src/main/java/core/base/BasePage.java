package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class BasePage {

    //Общие элементы на странице авторизации ok.ru
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk']");
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");

    @Step("Выполнить поиск по сайту с запросом: {query}")
    public void goSearch(String query) {
        searchField.shouldBe(visible).setValue(query);
        SelenideElement preResult = $$(".toolbar_search_suggest-item").findBy(text(query));
        preResult.shouldBe(visible).click();
    }

    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип OK")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

}
