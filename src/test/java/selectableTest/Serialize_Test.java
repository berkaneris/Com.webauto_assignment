package selectableTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1. Open the browser and navigate to the URL
 * 2. Click on webautomation link
 * 3. Click on Selectable button
 * 4. Click on Serialize button
 * 5. Click on Item 5
 * 6. Verify that Item 5 is selected
 * 7. Verify that "You've selected: #5" is displayed
 * 8. Click on Item 6
 * 9. Verify that Item 6 is selected
 * 10. Verify that "You've selected: #6" is displayed
 * 11. Click on Item 1, Item 3 by holding down the Ctrl key
 * 12. Verify that Item 1, Item 3 are selected
 * 13. Verify that "You've selected: #1 #3 #6" is displayed(6 selected because Item 6 is still selected)
 * 14. Click on Item 1, Item2, Item 3 by holding mouse down and dragging
 * 15. Verify that Item 1, Item 2, Item 3 are selected
 * 16. Verify that "You've selected: #1 #2 #3" is displayed
 */

public class Serialize_Test extends Hooks {

    @Test
    public void testSerializeLink(){

        //Open the browser and navigate to the URL
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnSelectableLink();
        pages.getWebAutomationPage().clickOnSerializeLink();

        //Click on Item 5
        pages.getSerializePage().clickOnElementByIndex(5);

        //Verify that Item 5 is selected
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(5));

        //Verify that "You've selected: #5" is displayed
        String expectedMessage1 = "You've selected: #5.";
        Assertions.assertEquals(expectedMessage1 , pages.getSerializePage().getFeedBackMessage());

        //Click on Item 6
        pages.getSerializePage().clickOnElementByIndex(6);

        //Verify that Item 6 is selected
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(6));

        //Verify that "You've selected: #6" is displayed
        String expectedMessage2 = "You've selected: #6.";
        Assertions.assertEquals(expectedMessage2 , pages.getSerializePage().getFeedBackMessage());

        //Click on Item 1, Item 3 by holding down the Ctrl key
        pages.getSerializePage().clickOnElementsWithCtrl(1 , 3);

        //Verify that Item 1, Item 3 are selected
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(1));
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(3));

        //Verify that "You've selected: #1 #3 #6" is displayed(6 selected because Item 6 is still selected)
        String expectedMessage3 = "You've selected: #1 #3 #6.";
        Assertions.assertEquals(expectedMessage3 , pages.getSerializePage().getFeedBackMessage());

        //Click on Item 1, Item2, Item 3 by holding mouse down and dragging
        pages.getSerializePage().clickOnElementsWithDraggingMouse(1, 2, 3);

        //Verify that Item 1, Item 2, Item 3 are selected
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(1));
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(2));
        Assertions.assertTrue(pages.getSerializePage().isTheItemSelectedByIndex(3));

        //Verify that "You've selected: #1 #2 #3" is displayed
        String expectedMessage4 = "You've selected: #1 #2 #3.";
        Assertions.assertEquals(expectedMessage4 , pages.getSerializePage().getFeedBackMessage());
    }
}
