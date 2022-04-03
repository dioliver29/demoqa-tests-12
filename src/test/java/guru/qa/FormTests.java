package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";

    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivan Ivanov");
        $("[id=userEmail]").setValue("Ivan@ya.ru");
        $(byText("Other")).click();
        $("[id=userNumber]").setValue("1234567891");
        $("[id=dateOfBirthInput]").setValue("10 Apr 1990");
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();
        $("[id=subjectsInput]").setValue("smth");
        $(byText("Music")).click();
        $("[id=currentAddress]").setValue("smth");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("[id=submit]").click();




    }

}
