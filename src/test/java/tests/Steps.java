package tests;
import Authorization.Authorization;
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

        String userID = Authorization.extactValueFromCookies("userID");
        String token = Authorization.extactValueFromCookies("token");
        AddBookRequestBodyModel bookData = new AddBookRequestBodyModel();
        bookData.userId = userID;
        bookData.setIsbn(data.isbn);

        given(RequestSpec)
                .header("Authorization", "Bearer " + token)
                .body(bookData)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(ResponseSpec201);
    }

    @Step("Удаление книги из списка")
    public void deleteBookUI(){

        profile.openPage()
                .deleteBook()
                .isEmptylist();
    }
}