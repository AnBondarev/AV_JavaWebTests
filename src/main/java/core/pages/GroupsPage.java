package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage {

    //Кнопка Группы
    private SelenideElement groupsButton = $("[data-l='t,userAltGroup']");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов страницы")
    private void verifyPageElements() {
        groupsButton.shouldBe(visible);
    }

    @Step("Получить элемент Группы")
    public SelenideElement getGroupsButton(){
        return groupsButton.shouldBe(visible);
    }
}
