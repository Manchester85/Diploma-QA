package ru.netology.datum;
import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataHelper {

    @Value
    public static class RequiredFields {
        String card;
        String month;
        String year;
        String name;
        String cvv;
    }

    private DataHelper() {
    }
    private static String getCardNumber(String card) {
        switch (card.toLowerCase()) {
            case ("approved"):
                return "4444 4444 4444 4441";
            case ("declined"):
                return "4444 4444 4444 4442";
            default:
                return "4444 4444 4444 4444";
        }
    }

    private static String getName() {
        return new Faker().name().firstName().toUpperCase() + " " + new Faker().name().firstName().toUpperCase();
    }

    private static String getCvv() {
        Random dgt = new Random();
        return String.valueOf(dgt.nextInt(10)) + dgt.nextInt(10) + dgt.nextInt(10);
    }

    public static RequiredFields getApprovedFields() {
        return new RequiredFields(getCardNumber("APPROVED"), generateMonth(), generateYear(), getName(), getCvv());
    }

    public static RequiredFields getDeclinedFields() {
        return new RequiredFields(getCardNumber("DECLINED"), generateMonth(), generateYear(), getName(), getCvv());
    }

    public static RequiredFields getRussianName() {
        return new RequiredFields(getCardNumber("APPROVED"), generateMonth(), generateYear(), "Петя Пупкин", getCvv());
    }

    public static RequiredFields getInvalidCardNumber() {
        return new RequiredFields(getCardNumber("INVALID"), generateMonth(), generateYear(), getName(), getCvv());
    }

    public static RequiredFields getIncompleteCard() {
        return new RequiredFields(getCardNumber("INVALID"), "**", "**", getName(), getCvv());
    }

    @Value
    public static class StatusPayment {
        String status;
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateMonth(){
        String month = generateDate(60).substring(3,5);
        return month;
    }

    public static String generateYear(){
        String year = generateDate(60).substring(8);
        return year;
    }
}