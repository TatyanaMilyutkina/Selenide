package ru.netology.rest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SelenideTest {


    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    String data = generateDate(3);

    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
    }


    @Test
    void test1() {

        $x("//input[@placeholder='Город']").val("Самара");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(data);
        $x("//input[@name='name']").val("Иванов Федор");
        $x("//input[@name='phone']").val("+79375286987");
        $x("//span[@class='checkbox__box']").click();
        $x("//span[@class='button__text']").click();
        $x("//div[@class='notification__content']").shouldHave(Condition.text("Встреча успешно забронирована на " + data), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }
}
