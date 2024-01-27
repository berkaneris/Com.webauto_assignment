package sortable;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import utils.BrowserUtils;

public class DisplayAsGrid_Test extends Hooks {

    @Test
    public void testDisplayAsGridLink(){
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnSortableLink();
        pages.getWebAutomationPage().clickOnDisplayAsGridLink();
        BrowserUtils.scrollDownWithPageDown();

        Point locationOfOne = pages.getDisplayAsGridPage().getLocationOfElement("1");
        pages.getDisplayAsGridPage().moveSortableElement("1", 250 , 0);
        Point locationOfTwo = pages.getDisplayAsGridPage().getLocationOfElement("2");
        Assertions.assertEquals(locationOfTwo , locationOfOne , "These elements shoud be relocated");
    }
}
