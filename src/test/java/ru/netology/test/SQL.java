package ru.netology.test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import ru.netology.datum.DBHelper;
import ru.netology.datum.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class SQL {
    DashboardPage dashboardPage;
    PaymentPage paymentPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        dashboardPage = open("http://localhost:8080", DashboardPage.class);
        paymentPage = dashboardPage.goToDebitPayment();
    }

    @SneakyThrows
    @Test
    public void approvedTest(){
        var authInfo = DataHelper.getApprovedFields();
        var start = dashboardPage.goToDebitPayment();
        start.fillValidForm(authInfo);
        Thread.sleep(15000);
        String actual = DBHelper.getStatus().getStatus();
        String expected = "APPROVED";
        Assertions.assertEquals(actual, expected);
    }

    @SneakyThrows
    @Test
    public void declinedTest() {
        var authInfo = DataHelper.getDeclinedFields();
        var start = dashboardPage.goToDebitPayment();
        start.fillInvalidForm(authInfo);
        Thread.sleep(15000);
        String actual = DBHelper.getStatus().getStatus();
        String expected = "DECLINED";
        Assertions.assertEquals(actual, expected);
    }
}

