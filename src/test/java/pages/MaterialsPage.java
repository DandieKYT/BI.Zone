package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaterialsPage {
    private SelenideElement
            bookPageOpen = $("#materials-7390 .research__title"),
            findBook = $x("//*[contains(@class, 'catalog__input')]"),
            file = $x("//a[@href='/upload/for_download/bi_zone_the_fundamentals_of_business_continuity_management_ru.pdf']");
    public MaterialsPage checkoutPDF() throws IOException {
        File download = file.download();
        PDF pdf = new PDF(download);
        assertThat(pdf, containsText("Путь к цифровому"));
        return this;
    }

    public MaterialsPage closeAfterPDF() {
        step("Закрытие окон после проверки PDF", () -> {
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }
    public MaterialsPage bookPageOpen() {
        step("Открытие страницы с книгой", () -> {
            bookPageOpen.click();
            switchTo().window(1);
        });
        return this;
    }
    public MaterialsPage findBook() {
        step("Поиск книги через поиск", () -> {
            findBook.setValue("Путь к цифровому лидерству. Основы управления непрерывностью бизнеса").pressEnter();
        });
        return this;
    }
}
