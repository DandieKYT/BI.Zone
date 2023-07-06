package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class VkPage {
    private final SelenideElement
            vkGroup = $x("//div[normalize-space()='VK']");
    private final SelenideElement getExpectedTitleVk = $x("//h1[normalize-space()='BI.ZONE']");

    public VkPage getExpectedTitleVk() {
        step("Проверить содержимое страницы группы", () -> {
            getExpectedTitleVk.shouldBe(text("BI.ZONE"));
            Selenide.closeWindow();
            switchTo().window(0);
        });
        return this;
    }

    public VkPage vkGroup() {
        step("Открыть группу VK", () -> {
            vkGroup.click();
            switchTo().window(1);
        });
        return this;
    }
}
