package tests;

import helpers.WithLogin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
@DisplayName("Тесты для demoqa")
@Tag("form")
public class DemoQATests extends TestBase{

    @DisplayName("Тест удаления книги из профиля")
    @Test
    @WithLogin
    void RemovingAProductFromTheList(){

        Steps step = new Steps();
        step.addBookAPI();
        step.deleteBookUI();

    }
}
