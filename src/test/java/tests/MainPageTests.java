package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Main page content")
@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have title WE ACCELERATE YOUR BUSINESS")
    void titlePageTest() {
        step("Open main page", () ->
                open(""));
        step("Check that WE ACCELERATE YOUR BUSINESS is shown", () ->
                $("h1.info").shouldHave(text("WE ACCELERATE YOUR BUSINESS")));
    }

    @Test
    @DisplayName("Page sections should be loaded")
    void baseBlocksLoadedTest() {
        step("Open main page", () ->
                open(""));

        step("Check that Page sections is shown", () -> {
            $(".products-list").shouldBe(visible);
            $(".unified-protocol").shouldBe(visible);
            $(".world-map").shouldBe(visible);
            $(".create-project").shouldBe(visible);
            $(".partners-list").shouldBe(visible);
            $(".reviews").shouldBe(visible);
            $(".news-list").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        step("Open main page", () ->
                open(""));

        step("Change language", () -> {
            $(".current").hover();
            $(".to-toggle").click();
        });

        step("Check that language is changed", () ->
                $("h1.info").shouldHave(text("МЫ - ДВИГАТЕЛЬ ВАШЕГО БИЗНЕСА")));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open main page", () ->
                open(""));

        step("Check that console log should not have any errors", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}