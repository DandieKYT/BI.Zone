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
             listVacations = $(".bloko-link__content"),
             getExpectedTitleVk = $x("//h1[normalize-space()='BI.ZONE']");




    public SelenideElement listVacations(){return listVacations;}

    public SelenideElement searchByParam(String param){
        return $x(String.format("//span[text()='%s']", param));
    }

    public SelenideElement openTitle(String expectedText){
        return $(byTagAndText("a", (expectedText)));
    }
    public SelenideElement checkTile(String expectedText){
        return $x(String.format("//h1[text()='%s']", expectedText));
    }


}
