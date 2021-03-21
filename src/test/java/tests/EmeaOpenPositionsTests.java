package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("EMEA Positions page content")
@Tag("web")
public class EmeaOpenPositionsTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        step("Open main page", () ->
                open(""));

        step("Open EMEA Positions page", () -> {
            $(".menu-icon-132").hover();
            $(".open").$(byText("Open Positions")).click();
            $("#paragrah--item--12592").click();
        });
    }

    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        step("Open EMEA Positions page", () ->
                open("/about-serrala/we-are-serrala/open-positions/emea-open-positions"));

        step("Check that EMEA Positions page is shown", () ->
                $(".page-title").shouldHave(text("EMEA Open Positions")));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open EMEA Positions page", () ->
                open("/about-serrala/we-are-serrala/open-positions/emea-open-positions"));

        step("Check that console log should not have any errors", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }

    @Test
    @DisplayName("Search \"automation\" positions")
    void searchAutomationPosition() {
        step("Open EMEA Positions page", () ->
                open("/about-serrala/we-are-serrala/open-positions/emea-open-positions"));

        step("Input \"automation\" in search field", () -> {
            switchTo().frame($("#psJobWidget iframe"));
            $("#jobSearch").val("automation");
        });

        step("Check that jobs contains \"automation\" word is shown", () ->
                $("#jobList").shouldHave(text("Automation")));
    }
}
