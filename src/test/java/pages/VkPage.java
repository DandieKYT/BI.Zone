package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class VkPage {
    private SelenideElement
            getExpectedTitleVk = $x("//h1[normalize-space()='BI.ZONE']");

    public VkPage vkGroup() {
        step("Открыть группу VK", () -> {
            vkGroup.click();
        });
        return this;
    }
    public VkPage getExpectedTitleVk() {
        step("Проверить содержимое страницы группы", () -> {
            getExpectedTitleVk.shouldBe(text("BI.ZONE"));
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }
}
