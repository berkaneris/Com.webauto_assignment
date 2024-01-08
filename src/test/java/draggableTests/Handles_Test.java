package draggableTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * 1-Open the url and navigate to handles link
 * 2-Drag the first draggable element to the right and below and drop
 * 3-Verify the element that move from handle
 * 4-Drag the second draggable element to the right and below and drop
 * 5-Verify the element that does not move from handle
 */

public class Handles_Test extends Hooks {


    @Test
    public void testHandles(){

        //Navigate to Handles link
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnDraggableLink();
        pages.getWebAutomationPage().clickOnDraggableHandlesLink();

        //Drag the first draggable element to the right and below and drop and verify
        Point initialPointFirstDrag = pages.getHandlesPage().getLocationOfFirstDraggable();
        pages.getHandlesPage().dragFirstDraggableFromHandle(40 , 40);
        Point finalPointFirstDrag = pages.getHandlesPage().getLocationOfFirstDraggable();
        assertNotEquals(initialPointFirstDrag , finalPointFirstDrag , "The element should move from handle");

        //Drag the second draggable element to the right and below and drop and verify
        Point initialPointSecondDrag = pages.getHandlesPage().getLocationOfSecondDraggable();
        pages.getHandlesPage().dragSecondDraggableFromHandle(40 , 40);
        Point finalPointSecondDrag = pages.getHandlesPage().getLocationOfSecondDraggable();
        assertEquals(initialPointSecondDrag , finalPointSecondDrag , "The element should not move from handle");

    }
}
