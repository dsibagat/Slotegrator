package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Main page content")
@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have title Serrala Wins TMI Award")
    void titlePageTest() {
        step("Open main page", () ->
                open(""));
        step("Check that Serrala Wins TMI Award is shown", () ->
                $(".slick-active .huge-title").shouldHave(text("Serrala Wins TMI Award")));
    }

    @Test
    @DisplayName("Page blocks should be loaded")
    void baseBlocksLoadedTest() {
        step("Open main page", () ->
                open(""));

        step("Check that Page blocks is shown", () -> {
            $("#paragrah--item--3").shouldBe(visible);
            $("#paragrah--item--4").shouldBe(visible);
            $("#paragrah--item--927").shouldBe(visible);
            $("#paragrah--item--6").shouldBe(visible);
            $("#paragrah--item--4402").shouldBe(visible);
            $("#serrala-footer").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        step("Open main page", () ->
                open(""));

        step("Change language", () ->
                $(".de").click());

        step("Check that language is changed", () ->
                $(".slick-active .huge-title").shouldHave(text("Serrala bezieht SkyCampus")));
    }

    @Test
    @DisplayName("Check sub-items in submenu \"ABOUT US\"")
    void submenuAboutUsIsShownTest() {
        step("Open main page", () ->
                open(""));

        step("Open submenu \"ABOUT US\"", () ->
                $(".menu-icon-132").hover());

        step("Check that submenu is shown", () ->
                $(".open").shouldHave(
                        text("Management"),
                        text("Awards"),
                        text("Careers"),
                        text("News"),
                        text("Contact")));
    }
}