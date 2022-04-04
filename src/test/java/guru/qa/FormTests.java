package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1600x900";

    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivan Ivanov");
        $("#userEmail").setValue("Ivan@ya.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").setValue("10 Apr 1990");
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("m");
        $(byText("Maths")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("smth");
       //executeJavaScript("window.scrollBy(0,500)"); works too
        $(byText("Select State")).scrollTo();
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#submit").click();

        //Asserts
        $(".table-responsive").shouldHave(text("Ivan Ivan Ivanov"), text("Ivan@ya.ru"), text("Other"), text("10 April,1990"), text("Music"), text("file.png"),text("smth"), text("NCR Delhi"));





    }

}
