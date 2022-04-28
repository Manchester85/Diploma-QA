package ru.netology.test;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.datum.DataHelper;
import ru.netology.page.DashboardPage;
import static com.codeborne.selenide.Selenide.open;

public class CreditPageTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void approvedTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var requiredFields = DataHelper.getApprovedFields();
        var start = login.goToDebitPayment();
        start.fillValidForm(requiredFields);
        start.getValidInfo();
    }

    @Test
    public void declinedTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var requiredFields = DataHelper.getDeclinedFields();
        var start = login.goToDebitPayment();
        start.fillInvalidForm(requiredFields);
        start.getInvalidInfo();
    }

    @Test
    public void rusTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var requiredFields = DataHelper.getRussianName();
        var start = login.goToDebitPayment();
        start.fillRusForm(requiredFields);
        start.getInvalidInfo();
    }

    @Test
    public void invalidCardNumberTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var requiredFields = DataHelper.getInvalidCardNumber();
        var start = login.goToCreditPayment();
        start.fillInvalidForm(requiredFields);
        start.getInvalidInfo();
    }

    @Test
    public void creditTest() {
        var login = open("http://localhost:8080", DashboardPage.class);
        var requiredFields = DataHelper.getApprovedFields();
        var start = login.goToCreditPayment();
        start.fillValidForm(requiredFields);
        start.getValidInfo();
    }
}
