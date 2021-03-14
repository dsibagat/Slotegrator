package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("EMEA Positions page content")
@Tag("web")
public class EmeaOpenPositionsTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        open("");

        $(".menu-icon-132").hover();

        $(".open").$(byText("Open Positions")).click();

        $("#paragrah--item--12592").click();
    }

    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        open("/about-serrala/we-are-serrala/open-positions/emea-open-positions");

        $(".page-title").shouldHave(text("EMEA Open Positions"));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/about-serrala/we-are-serrala");



        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }

    @Test
    @DisplayName("Search \"automation\" positions")
    void searchAutomationPosition() {
        open("/about-serrala/we-are-serrala/open-positions/emea-open-positions");

        $("#jobSearch").val("automation");

        $("#jobList").shouldHave(text("Automation"));

        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}
