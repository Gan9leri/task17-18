package tests;

import helpers.WithLogin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для demoqa")
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
