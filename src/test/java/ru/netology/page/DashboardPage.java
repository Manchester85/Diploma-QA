package ru.netology.page;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement start = $(withText("Купить"));
    private SelenideElement pay = $(byText("Оплата по карте"));
    private SelenideElement startcredit = $(byText("Купить в кредит"));
    private SelenideElement credit = $(byText("Кредит по данным карты"));

    public PaymentPage goToDebitPayment(){
        start.click();
        pay.shouldBe(visible);
        return new PaymentPage();
    }

    public PaymentPage goToCreditPayment(){
        startcredit.click();
        credit.shouldBe(visible);
        return new PaymentPage();
    }
}