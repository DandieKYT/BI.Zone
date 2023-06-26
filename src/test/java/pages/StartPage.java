package pages;

import com.codeborne.selenide.SelenideElement;
import static org.hamcrest.MatcherAssert.assertThat;


import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;



public class StartPage {


    public SelenideElement searchByParam(String param){
        return $x(String.format("//span[text()='%s']", param));
    }

    public SelenideElement openTitle(String expectedText){
        return $(byTagAndText("a", (expectedText)));
    }
    public SelenideElement checkTitle(String expectedText){
        return $x(String.format("//h1[text()='%s']", expectedText));
    }


}
