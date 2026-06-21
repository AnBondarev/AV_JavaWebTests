package tests.web;

import core.base.BaseTest;
import core.pages.web.GroupsPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends BaseTest {

    private static LoginPage loginPage;
    private static GroupsPage groupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void searchGroupsTest() {
        //Поиск по передаваемому значению и переход на страницу
        loginPage.goSearch("Angry Тестировщик");
        groupsPage = new GroupsPage();
        //Проверка, что кнопка Группы видна на странице и активна (нажата)
        groupsPage.getGroupsButton().shouldBe(visible).shouldHave(attribute("data-active", "true"));
    }
}
