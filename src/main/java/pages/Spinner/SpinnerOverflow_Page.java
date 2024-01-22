package pages.Spinner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SpinnerOverflow_Page extends BasePage {

    @FindBy(id = "spinner-overflow")
    private WebElement inputBox;

    @FindBy(css = "#spinner-overflow + a > span:nth-child(1)")
    private WebElement upSideHandle;

    @FindBy(css = "#spinner-overflow + a + a > span:nth-child(1) ")
    private WebElement downSideHandle;

    public String getValueFromInputBox(){
        return inputBox.getAttribute("aria-valuenow");
    }
    public void clickOnUpSideHandle(){
        upSideHandle.click();
    }
    public void clickOnDownSideHandle(){
        downSideHandle.click();
    }
}
