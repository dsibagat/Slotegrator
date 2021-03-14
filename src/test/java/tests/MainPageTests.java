package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
    @DisplayName("Submenu \"Resources\" should be shown")
    void submenuResourcesIsShownTest() {
        open("");

        $(".menu-icon-292").hover();

        $(".open").shouldHave(
                text("Articles"),
                text("Blog"),
                text("Product Sheets"),
                text("Videos"),
                text("Whitepapers"));
    }
}