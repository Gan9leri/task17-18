package authorization;

import com.codeborne.selenide.WebDriverRunner;
import data.TestData;
import io.qameta.allure.Step;
import models.AuthRequestBodyModel;
import models.AuthResponseBodyModel;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.DemoQASpecs.RequestSpec;
import static specs.DemoQASpecs.ResponseSpec200;

public class Authorization {

    @Step("Получение данных для авторизации")
    public static AuthResponseBodyModel getCookie() {
        TestData acc = new TestData();
        AuthRequestBodyModel authData = new AuthRequestBodyModel();
        authData.setUserName(acc.login);
        authData.setPassword(acc.password);

        return given(RequestSpec)
                .body(authData)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(ResponseSpec200)
                .extract().as(AuthResponseBodyModel.class);
    }

    @Step("Авторизация пользователя")
    public static void setCookiesInBrowser(AuthResponseBodyModel authResponse) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.getToken()));
        open("");
    }

    public static String extactValueFromCookies(String str) {
        String cookieValue = String.valueOf(WebDriverRunner.getWebDriver().manage().getCookieNamed(str));
        return cookieValue.substring(cookieValue.indexOf("=") + 1, cookieValue.indexOf(";"));
    }
}