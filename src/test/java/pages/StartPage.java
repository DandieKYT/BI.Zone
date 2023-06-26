package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.IOException;


import static com.codeborne.pdftest.PDF.containsText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



public class StartPage {
    private SelenideElement
             expectedProducts = $(".cFiltered__length"),
             checkBoxHome = $x("//*[contains(@class, 'catalog__filterContent')]//div[text()='Реестр отечественного ПО']"),
             checkBoxLocal = $x( "//*[contains(@class, 'catalog__filterContent')]//div[text()='Локальное']"),
             buttonVacation = $x("//*[contains(@class, 'tmpl_hh_areas__reset--dt')]"),
             vacationsQa = $(byTagAndText("span", "Вакансии BI.ZONE")),
             bookPageOpen = $("#materials-7390 .research__title"),
             listVacations = $(".bloko-link__content"),

             checkoutVacationQa =  $(byTagAndText("span","Тестировщик")),
             getExpectedTitleVk = $x("//h1[normalize-space()='BI.ZONE']");




    public SelenideElement checkoutVacationQa(){return  checkoutVacationQa;}
    public SelenideElement listVacations(){return listVacations;}
    public SelenideElement buttonVacation(){return buttonVacation;}
    public SelenideElement vacationsQa(){return vacationsQa;}
    public SelenideElement getExpectedTitleVk(){return getExpectedTitleVk;}
    public SelenideElement bookPageOpen(){return bookPageOpen; }


    public StartPage checkoutPDF() throws IOException {
        File download = $x("//a[@href='/upload/for_download/bi_zone_the_fundamentals_of_business_continuity_management_ru.pdf']").download();
        PDF pdf = new PDF(download);
        assertThat(pdf, containsText("Путь к цифровому"));
        return this;
    }


    public SelenideElement searchByParam(String param){
        return $x(String.format("//span[text()='%s']", param));
    }

    public SelenideElement openTitle(String expectedText){
        return $(byTagAndText("a", (expectedText)));
    }
    public SelenideElement checkTile(String expectedText){
        return $x(String.format("//h1[text()='%s']", expectedText));
    }
    public SelenideElement expectedProducts(){return expectedProducts;}
    public SelenideElement checkBoxHome(){return checkBoxHome;}
    public SelenideElement checkBoxLocal(){ return checkBoxLocal;}
    public SelenideElement closeCookie(){ return  closeCookie;}
    public SelenideElement openProducts() {
        return openProducts;
    }
    public SelenideElement expertiseHover(){return  expertiseHover;}
}
