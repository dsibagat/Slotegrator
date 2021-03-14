package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Page should have title Serrala Wins TMI Award")
    void titlePageTest() {
        open("");

        $(".slick-active .huge-title").shouldHave(text("Serrala Wins TMI Award"));
    }

    @Test
    @DisplayName("Page blocks should be loaded")
    void baseBlocksLoadedTest() {
        open("");

        $("#paragrah--item--3").shouldBe(visible);
        $("#paragrah--item--4").shouldBe(visible);
        $("#paragrah--item--927").shouldBe(visible);
        $("#paragrah--item--6").shouldBe(visible);
        $("#paragrah--item--4402").shouldBe(visible);
        $("#serrala-footer").shouldBe(visible);
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        open("");

        $(".de").click();

        $(".slick-active .huge-title").shouldHave(text("Serrala bezieht SkyCampus"));
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