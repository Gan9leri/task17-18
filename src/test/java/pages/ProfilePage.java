package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    /*
    *$("#delete-record-undefined").click();
    $("#closeSmallModal-ok").click();
    $("#closeSmallModal-ok").click();
    $(".rt-noData").shouldHave(text("No rows found"));*/
    SelenideElement deleteButton = $("#delete-record-undefined"),
                    okButton = $("#closeSmallModal-ok"),
                    emptyList = $(".rt-noData");

    @Step("Открытие профиля")
    public ProfilePage openPage(){
        open("/profile");
        return this;
    }

    @Step("Удаление книги из списка")
    public ProfilePage deleteBook(){
        deleteButton.click();
        okButton.click();
        return this;
    }

    @Step("Подтверждение удаления книги")
    public ProfilePage isEmptylist(){
        emptyList.shouldHave(text("No rows found"));
        return this;
    }

}
