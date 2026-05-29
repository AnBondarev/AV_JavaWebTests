package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithQRcodeTests extends BaseTest {

    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void checkQRcode() {
        loginPage.goToQRcode();
        //Проверка, что элемент виден и что он - картинка
        loginPage.getImgQRcode().shouldBe(visible).shouldBe(image);
    }
}
