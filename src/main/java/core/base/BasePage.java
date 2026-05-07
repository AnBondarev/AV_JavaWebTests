package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    //Общие элементы на странице авторизации ok.ru
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk']");
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");

    //Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    //Клик по vk services
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    //Клик на логотип OK
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

}
