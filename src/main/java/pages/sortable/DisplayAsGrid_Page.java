package pages.sortable;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class DisplayAsGrid_Page extends BasePage {

    @FindBy(css = "#sortable-disp-as-grid > li")
    private List<WebElement> sortableElements;

    public void moveSortableElement(String text1, int xOffset , int yOffset){

        actions.moveToElement(getElement(text1)).clickAndHold().moveByOffset(xOffset , yOffset).release().perform();



    }

    private WebElement getElement(String text){
        for(int i = 0; i < sortableElements.size(); i++){
            if(sortableElements.get(i).getText().equals(text)){
                return sortableElements.get(i);
            }
        }
        return null;
    }

    public Point getLocationOfElement(String text){
       return getElement(text).getLocation();
    }

}
