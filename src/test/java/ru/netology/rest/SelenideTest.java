package ru.netology.rest;

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
    public void setUp(){
        open("http://localhost:9999");
    }


    @Test
    void test1() {

        //Configuration.holdBrowserOpen = true;
        //open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$x("//input[@placeholder='Город']").val("Самара");
        form.$("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        form.$("[data-test-id='date'] input").val(data);
        form.$x("//input[@name='name']").val("Иванов Федор");
        form.$x("//input[@name='phone']").val("+79375286987");
        form.$x("//span[@class='checkbox__box']").click();
        form.$x("//span[@class='button__text']").click();
        form.$x("//*[contains(text(), 'Забронировать')]").shouldBe(visible, Duration.ofSeconds(15));
        form.$(byText("Успешно"));
        form.$(byText("Встреча успешно забронирована на " + data));

    }
}
