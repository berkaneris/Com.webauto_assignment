package pages.controlgroup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class Toolbar_Page extends BasePage {

    /*
    The elements in the dropdown list:
    1-Zoom dropdown
    2-Background color dropdown
    3-Text color dropdown
     */
    @FindBy(css = ".toolbar > div > select")
    private List<WebElement> dropDowns;
    /*
    The elements in the button list:
    1-Bold button
    2-Italic button
    3-Underline button
    4-Print button
     */
    @FindBy(css = ".toolbar > div > button ")
    private List<WebElement> buttons;

    @FindBy(id = "page")
    private WebElement textArea;

    private Select select;

    public enum DropDown{
        ZOOM , BACKGROUND_COLOR , TEXT_COLOR
    }
    public enum Button{
        BOLD , ITALIC , UNDERLINE
    }




    public void selectZoomQuantity(int index){
        select = new Select(dropDowns.get(0));
        select.selectByIndex(index);
    }
    public void selectBackgroundColor(String color){
        select = new Select(dropDowns.get(1));
        select.selectByVisibleText(color);
    }
    public void selectTextColor(String color){
        select = new Select(dropDowns.get(2));
        select.selectByVisibleText(color);
    }
    public void clickButton(int index){
        if(0 < index && index < 5) {
            buttons.get(index - 1).click();
        }
    }
    public void clearTextArea(){
        textArea.clear();
    }
    public void writeTextArea(){
        textArea.sendKeys();
    }

    /**
     *
     * @param dropdown (ZOOM for zoom dropdown ,
     *                 BACKGROUND_COLOR for background color dropdown,
     *                 TEXT_COLOR for text color dropdown)
     *
     * @return boolean
     */
    public boolean isDropDownActiveOnTextArea(DropDown dropdown){
        switch (dropdown){
            case ZOOM: return textArea.getAttribute("style").contains("zoom: "  + getSelectedOptionFromDropDown(1).toLowerCase());
            case BACKGROUND_COLOR: return textArea.getAttribute("style").contains("background-color: " + getSelectedOptionFromDropDown(2).toLowerCase());
            case TEXT_COLOR: return textArea.getAttribute("style").contains("color: " + getSelectedOptionFromDropDown(3).toLowerCase());
            default: return false;
        }
    }

    /**
     *
     * @param index (1 for zoom dropdown,
     *               2 for background color dropdown,
     *               3 for text color dropdown)
     * @return String
     */
    public String getSelectedOptionFromDropDown(int index){
        String option = "";
        if(0 < index && index < 4){
            select = new Select(dropDowns.get(index - 1));
            option = select.getFirstSelectedOption().getText();
        }
        return option;
    }

    /**
     *
     * @param button (BOLD for bold button,
     *                 ITALIC for Italic button,
     *                 UNDERLINE for Underline button)
     *
     * @return boolean
     */
    public boolean isButtonActiveOnTextArea(Button button){
        switch (button){
            case BOLD: return textArea.getAttribute("style").contains("font-weight: bold");
            case ITALIC: return textArea.getAttribute("style").contains("font-style: italic");
            case UNDERLINE: return textArea.getAttribute("style").contains("text-decoration: underline");
            default: return false;
        }
    }
}
