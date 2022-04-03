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
        $("[id=userEmail]").setValue("Ivan Ivanov");
        $(byText("Other")).click();
        $("[id=userNumber]").setValue("1234567891");
        $("[id=dateOfBirthInput]").setValue("10 Apr 1990");
        $("[id=subjectsInput]").setValue("smth");
        $(byText("Music")).click();

        $("[id=uploadPicture]").uploadFromClasspath("/resources/file.png");


    }

}
