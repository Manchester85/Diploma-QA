package ru.netology.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.datum.DataHelper;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private SelenideElement card = $("[placeholder=\"0000 0000 0000 0000\"]");
    private SelenideElement month = $("[placeholder=\"08\"]");
    private SelenideElement year = $("[placeholder=\"22\"]");
    private SelenideElement name = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvv = $("[placeholder=\"999\"]");
    private SelenideElement button = $(withText("Продолжить"));
    private SelenideElement goodPay = $(withText("Операция одобрена"));
    private SelenideElement errorPay = $(withText("Ошибка"));

    public void fillValidForm(DataHelper.RequiredFields getApprovedFields) {
        card.setValue(getApprovedFields.getCard());
        month.setValue(getApprovedFields.getMonth());
        year.setValue(getApprovedFields.getYear());
        name.setValue(getApprovedFields.getName());
        cvv.setValue(getApprovedFields.getCvv());
        button.click();
    }

     public void fillInvalidForm (DataHelper.RequiredFields getDeclinedFields) {
        card.setValue(getDeclinedFields.getCard());
        month.setValue(getDeclinedFields.getMonth());
        year.setValue(getDeclinedFields.getYear());
        name.setValue(getDeclinedFields.getName());
        cvv.setValue(getDeclinedFields.getCvv());
        button.click();
    }

    public void fillRusForm (DataHelper.RequiredFields getRussianName) {
        card.setValue(getRussianName.getCard());
        month.setValue(getRussianName.getMonth());
        year.setValue(getRussianName.getYear());
        name.setValue(getRussianName.getName());
        cvv.setValue(getRussianName.getCvv());
        button.click();
    }

    public void fillIncompleteCard (DataHelper.RequiredFields getIncompleteCard) {
        card.setValue(getIncompleteCard.getCard());
        month.setValue(getIncompleteCard.getMonth());
        year.setValue(getIncompleteCard.getYear());
        name.setValue(getIncompleteCard.getName());
        cvv.setValue(getIncompleteCard.getCvv());
        button.click();
    }

    public void getValidInfo () {
        goodPay.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getInvalidInfo () {
        errorPay.shouldBe(visible, Duration.ofSeconds(15));
    }
}



