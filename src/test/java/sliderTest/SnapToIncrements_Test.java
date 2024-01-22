package sliderTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import utils.BrowserUtils;


public class SnapToIncrements_Test extends Hooks {

    @Test
    public void testSnapToIncrementsLink(){
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnSliderLink();
        pages.getWebAutomationPage().clickOnSnapToIncrementsLink();

        int initialQuantity = pages.getSnapToIncrementsPage().getDonationQuantity();
        Point initialHandleLocation = pages.getSnapToIncrementsPage().getHandleLocation();

        pages.getSnapToIncrementsPage().moveSliderHandle(200);

        int finalQuantity = pages.getSnapToIncrementsPage().getDonationQuantity();
        Point finalHandleLocation = pages.getSnapToIncrementsPage().getHandleLocation();

        Assertions.assertEquals(150 , finalQuantity - initialQuantity);
        Assertions.assertTrue(finalHandleLocation.getX() > initialHandleLocation.getX());
    }
}
