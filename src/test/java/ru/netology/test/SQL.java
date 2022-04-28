package ru.netology.test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import ru.netology.datum.DBHelper;
import ru.netology.datum.DataHelper;
import ru.netology.page.DashboardPage;
import static com.codeborne.selenide.Selenide.open;

public class SQL {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @SneakyThrows
    @Test
    public void approvedTest(){
        var login = open("http://localhost:8080", DashboardPage.class);
        var authInfo = DataHelper.getApprovedFields();
        var start = login.goToDebitPayment();
        start.fillValidForm(authInfo);
        Thread.sleep(15000);
        String actual = DBHelper.getStatus().getStatus();
        String expected = "APPROVED";
        Assertions.assertEquals(actual, expected);
    }

    @SneakyThrows
    @Test
    public void declinedTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var authInfo = DataHelper.getDeclinedFields();
        var start = login.goToDebitPayment();
        start.fillInvalidForm(authInfo);
        Thread.sleep(15000);
        String actual = DBHelper.getStatus().getStatus();
        String expected = "DECLINED";
        Assertions.assertEquals(actual, expected);
    }
}

