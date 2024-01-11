package menuTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 1-Open the url and navigate to Icons link
 * 2-Hover on "Zoom Out" element
 * 3-Verify that there is no menu for the element
 * 4-Hover on "Playback" element
 * 5-Verify that there is a menu for the element
 */

public class Icons_Test extends Hooks {

    @Test
    public void testIconsLink(){

        //Open the url and navigate to Icons link
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnMenuLink();
        pages.getWebAutomationPage().clickOnIconLink();

        //Hover on "Zoom Out" element
        List<String> menuForElement = pages.getIconsPage().getSubMenu(3);

        //Verify that there is no menu for the element
        Assertions.assertTrue(menuForElement.size() == 0 , "There is no menu for the element");

        //Hover on "Playback" element
        menuForElement = pages.getIconsPage().getSubMenu(5);

        //Verify that there is a menu for the element
        Assertions.assertTrue(menuForElement.size() > 0 , "There is a menu for the element");


    }
}
