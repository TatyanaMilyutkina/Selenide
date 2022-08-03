//package ru.netology.rest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.WebDriverRunner;
//import org.junit.jupiter.api.Test;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.*;
//import static com.codeborne.selenide.Selenide.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//
//
//public class SelenideTest {
//
//
//    public String generateDate(int days) {
//        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
//    String data = generateDate(3);
//
//
//    @Test
//    void test1(){
//
//        Configuration.holdBrowserOpen = true;
//        open("http://localhost:9999");
//        $x("//input[@placeholder='Город']").val("Самара");
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
//        $("[data-test-id='date'] input").val(data);
//        $x("//input[@name='name']").val("Иванов Федор");
//        $x("//input[@name='phone']").val("+79375286987");
//        $x("//span[@class='checkbox__box']").click();
//        $x("//span[@class='button__text']").click();
//        $x("//*[contains(text(), 'Забронировать')]").shouldBe(visible, Duration.ofSeconds(15));
//        $(byText("Успешно"));
//        $(byText("Встреча успешно забронирована на "+ data));
//
//    }
//}
