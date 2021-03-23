package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("All providers page content")
@Tag("web")
public class AllProvidersPageTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        step("Open main page", () ->
                open(""));

        step("Open All providers page", () -> {
            $(byText("Games")).hover();
            $(byText("All providers")).click();
            $(byText("Casino gaming companies")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        step("Open All providers page", () ->
                open("/game_developers/"));

        step("Check that All providers page is shown", () ->
                $(byText("Casino gaming companies")).shouldBe(visible));
    }

    @Test
    @DisplayName("Check that additional data is shown")
    void searchAutomationPosition() {
        step("Open All providers page", () ->
                open("/game_developers/"));

        step("Hover on Microgaming tile", () -> {
            $("[id=w0] [data-key='2648']").hover();
        });

        step("Check that additional data is shown", () ->
                $("[id=w0] [data-key='2648'] .info").shouldBe(not(visible)));
    }
}
