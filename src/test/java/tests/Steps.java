package tests;
import authorization.Authorization;
import data.TestData;
import io.qameta.allure.Step;
import models.AddBookRequestBodyModel;
import pages.ProfilePage;
import static io.restassured.RestAssured.given;
import static specs.DemoQASpecs.RequestSpec;
import static specs.DemoQASpecs.ResponseSpec201;

public class Steps {

    ProfilePage profile = new ProfilePage();
    TestData data = new TestData();

    @Step("Добавление книг в профиль")
    public void addBookAPI(){

        String userID = Authorization.extactValueFromCookieString("userID");
        String token = Authorization.extactValueFromCookieString("token");
        AddBookRequestBodyModel bookData = new AddBookRequestBodyModel();
        bookData.userId = userID;
        bookData.setIsbn(data.isbn);

        given(RequestSpec)
                .header("authorization", "Bearer " + token)
                .body(bookData)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(ResponseSpec201);
    }

    @Step("Удаление книги из списка")
    public void deleteBookUI(){

        profile.openPage()
                .deleteBook();
    }

    @Step("Проверка, что книга удалена")
    public void CheckThatBookHasBeenDeletedUI(){
        profile.checkThatListIsEmpty();
    }




}