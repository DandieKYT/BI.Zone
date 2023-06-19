package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.pdftest.PDF;
import static com.codeborne.pdftest.PDF.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.File;
import java.io.IOException;


import static com.codeborne.pdftest.PDF.containsText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



public class BiZonePage {


    private SelenideElement materialsOpen =  $(byTagAndText("a", "Материалы"));

    private SelenideElement openСareer = $x("//a[@class='submenu__link'][contains(text(),'Карьера')]");
    private SelenideElement openProducts = $x("//a[text()='Продукты и услуги']");
    private SelenideElement expectedProducts = $(".cFiltered__length");
    private SelenideElement checkBoxHome = $x("//*[contains(@class, 'catalog__filterContent')]//div[text()='Реестр отечественного ПО']");
    private SelenideElement checkBoxLocal = $x( "//*[contains(@class, 'catalog__filterContent')]//div[text()='Локальное']");
    private SelenideElement closeCookie = $(".v-cookie__button > svg > path");
    private SelenideElement expertiseHover = $(byTagAndText("span","Экспертиза"));
    private SelenideElement companyHover = $(byTagAndText("span","Компания"));
    private SelenideElement buttonVacation = $x("//*[contains(@class, 'tmpl_hh_areas__reset--dt')]");
    private SelenideElement vacationsQa = $(byTagAndText("span", "Вакансии BI.ZONE"));
    private SelenideElement bookPageOpen = $("#materials-7390 .research__title");

    private SelenideElement listVacations = $(".bloko-link__content");
    private SelenideElement vkGroup= $x("//div[normalize-space()='VK']");

    private SelenideElement checkoutVacationQa =  $(byTagAndText("span","Тестировщик"));
    private SelenideElement getExpectedTitleVk = $x("//h1[normalize-space()='BI.ZONE']");

    public SelenideElement checkoutVacationQa(){return  checkoutVacationQa;}
    public SelenideElement listVacations(){return listVacations;}
    public SelenideElement buttonVacation(){return buttonVacation;}
    public SelenideElement vacationsQa(){return vacationsQa;}
    public SelenideElement openСareer(){return openСareer;}
    public SelenideElement companyHover(){return companyHover;}
    public SelenideElement getExpectedTitleVk(){return getExpectedTitleVk;}
    public SelenideElement getVkGroup() {return vkGroup;}
    public SelenideElement bookPageOpen(){return bookPageOpen; }
    public SelenideElement materialsOpen(){ return materialsOpen;}


    public BiZonePage checkoutPDF() throws IOException {
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
