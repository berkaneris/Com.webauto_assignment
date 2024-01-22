package pages.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ModalForm_Page extends BasePage {

    @FindBy(css = ".frame-container div tbody tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#dialog-container-modalForm-sbt button")
    private List<WebElement> buttons;

    @FindBy(css = ".mb-2 input")
    private List<WebElement> inputTexts;

    @FindBy(css = "#dialog-container-modalForm-sbt div[role='dialog']")
    private WebElement dialogBox;

    public enum Button{
        CREATE_ACCOUNT , SUBMIT , CROSS
    }

    public enum Input{
        NAME , SURNAME , EMAIL
    }

    public void clickOnButton(Button button){
        switch (button){
            case CREATE_ACCOUNT: buttons.get(0).click();break;
            case CROSS: buttons.get(1).click();break;
            case SUBMIT: buttons.get(2).click();break;
        }
    }

    public void writeInInput(Input input , String text){
        switch (input){
            case NAME: inputTexts.get(0).sendKeys(text);break;
            case SURNAME: inputTexts.get(1).sendKeys(text);break;
            case EMAIL: inputTexts.get(2).sendKeys(text);break;
        }
    }

    public void clearInInput(Input input){
        switch (input){
            case NAME: inputTexts.get(0).clear();break;
            case SURNAME: inputTexts.get(1).clear();break;
            case EMAIL: inputTexts.get(2).clear();break;
        }
    }
    public String getInfoFromLastCreatedAccountInTable(Input input){
        switch (input){
            case NAME: return tableRows.get(tableRows.size() - 1).findElement(By.cssSelector("td:nth-child(1)")).getText();
            case SURNAME: return tableRows.get(tableRows.size() - 1).findElement(By.cssSelector("td:nth-child(2)")).getText();
            case EMAIL: return tableRows.get(tableRows.size() - 1).findElement(By.cssSelector("td:nth-child(3)")).getText();
            default: return "";
        }
    }

    public boolean isDialogBoxDisplayed(){
        return dialogBox.isDisplayed();
    }
}
