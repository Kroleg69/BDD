package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage2 {
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private final SelenideElement title = $(byText("Пополнение карты"));
    private final SelenideElement amountField = $("[data-test-id=amount] input");
    private final SelenideElement fromField = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private final SelenideElement errorMessage = $("[data-test-id='error-message']");

    public LoginPage2() {
        heading.shouldBe(visible);
        title.shouldHave(text("Пополнение карты"));
    }
    public DashboardPage transferValidMany(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        transferMany(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void transferMany(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountField.setValue(amountToTransfer);
        fromField.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }
    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}