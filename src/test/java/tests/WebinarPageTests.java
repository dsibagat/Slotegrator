package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Webinar page content")
@Tag("web")
public class WebinarPageTests extends TestBase {

    @Test
    @DisplayName("Fill the fields with invalid data")
    void invalidDataInput() {
        step("Open main page", () ->
                open("/webinar/automated-archiving-retain-your-data-but-trim-the-cost"));

        step("Input fields with invalid data", () -> {
            $("#First_Name_Mkt__c").val("test");
            $("#Last_Name_Mkt__c").val("test");
            $("#Email").val("test");
        });

        step("Click on submit button", () ->
                $(".mktoButton").scrollTo().click());

        step("Check error is shown", () ->
                $(".mktoErrorDetail").shouldHave(text("example@yourdomain.com")));
    }
}
