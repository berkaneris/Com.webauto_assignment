package pages.slider;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.JSUtils;

public class SnapToIncrements_Page extends BasePage {

    @FindBy(id = "amount-snap-to-increments")
    private WebElement inputBox;

    @FindBy(css = "#slider-snap-to-increments span")
    private WebElement sliderHandle;

    public void moveSliderHandle(int quantity){
//        JSUtils.executeJavaScript("document.querySelector('#slider-snap-to-increments span').setAttribute('style', 'left: "
//                + quantity + "%');");
        actions.dragAndDropBy(sliderHandle , quantity , 0).perform();
    }

    public Point getHandleLocation(){
       return sliderHandle.getLocation();
    }
    public int getDonationQuantity(){
        return Integer.parseInt(inputBox.getAttribute("value").substring(1));
    }
}
