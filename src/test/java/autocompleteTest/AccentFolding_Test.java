package autocompleteTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.BrowserUtils;

import java.util.List;

/**
 * 1.Open the url and navigate to Accent Folding Link
 * 2.Enter the text box Jo
 * 3.Verify the name list "John" and "Jörn"
 * 4.Clear the box and enter Jö to the box
 * 5.Verify the name "Jörn"
 */

public class AccentFolding_Test extends Hooks {

    @Test
    public void testAccentFoldingLink(){
        //Open the url and navigate to Accent Folding Link
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnAutoCompleteLink();
        pages.getWebAutomationPage().clickOnAccentFoldingLink();

        //Enter the text box Jo
        pages.getAccentFoldingPage().writeText("Jo");
        List<String> names = pages.getAccentFoldingPage().getNameList();

        //Verify the name list "John" and "Jörn"
        Assertions.assertTrue(names.get(0).startsWith("Jörn"), "It should be start with Jörn");
        Assertions.assertTrue(names.get(1).startsWith("John"), "It should be start with John");

        //Clear the box and enter Jö to the box
        pages.getAccentFoldingPage().clearText();
        pages.getAccentFoldingPage().writeText("Jö");
        BrowserUtils.wait(1);
        names = pages.getAccentFoldingPage().getNameList();

        //Verify the name "Jörn"
        Assertions.assertEquals(1 , names.size() , "There should be only one name");
        Assertions.assertTrue(names.get(0).startsWith("Jörn"), "It should be start with Jörn");

    }

}
