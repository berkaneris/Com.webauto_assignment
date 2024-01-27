package pages.accordion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CollapseContent_Page extends BasePage {

    @FindBy(css = "#accordion-2-cc h3")
    private List<WebElement> accordionElements;

    @FindBy(css = "#accordion-2-cc div")
    private List<WebElement> elementsContents;

    public void clickOnAccordionElement(int index){
        accordionElements.get(index - 1).click();
    }
    public boolean isContentDisplayed(int index){
        return elementsContents.get(index - 1).isDisplayed();
    }

}
