package droppableTest;

import BaseTest.Hooks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;


import static org.junit.jupiter.api.Assertions.assertFalse;
/**
 * 1. Open the browser and navigate to the page
 * 2. click on the droppable button
 * 3. click on the default functionality button
 * 4. Drag the first draggable element and drop it to the accept droppable element
 * 5. Verify that the first draggable element has not been dropped to the accept droppable element
 * 6. Drag the second draggable element and drop it to the accept droppable element
 * 7. Verify that the first draggable element has been dropped to the accept droppable element
 */

public class Accept_Test extends Hooks {


    @Test
    public void testAcceptLink(){

        //Open the browser and navigate to the page
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnDroppableLink();
        pages.getWebAutomationPage().clickOnAcceptLink();

        //Drag the first draggable element and drop it to the accept droppable element
        //Verify that the first draggable element has not been dropped to the accept droppable element
        pages.getAcceptPage().moveFirstDraggableToAcceptDroppable();
        assertFalse(pages.getAcceptPage().isAcceptDroppableHighLighted());

        //Drag the second draggable element and drop it to the accept droppable element
        pages.getAcceptPage().moveSecondDraggableToAcceptDroppable();
        Point topLeftSecondDraggable = pages.getAcceptPage().getSecondDraggableElementLeftTop();
        Point rightBelowSecondDraggable = pages.getAcceptPage().getSecondDraggableElementRightBelow();
        Point topLeftAcceptDroppable = pages.getAcceptPage().getDroppableElementLeftTop();
        Point rightBelowAcceptDroppable = pages.getAcceptPage().getDroppableElementRightBelow();

        //Verify that the first draggable element has been dropped to the accept droppable element
        Assertions.assertThat(topLeftSecondDraggable.getX()).isBetween(topLeftAcceptDroppable.getX() , rightBelowAcceptDroppable.getX());
        Assertions.assertThat(topLeftSecondDraggable.getY()).isBetween(topLeftAcceptDroppable.getY() , rightBelowAcceptDroppable.getY());
        Assertions.assertThat(rightBelowSecondDraggable.getX()).isBetween(topLeftAcceptDroppable.getX() , rightBelowAcceptDroppable.getX());
        Assertions.assertThat(rightBelowSecondDraggable.getY()).isBetween(topLeftAcceptDroppable.getY() , rightBelowAcceptDroppable.getY());

        Assertions.assertThat(pages.getAcceptPage().getAcceptDroppableText()).isEqualTo("Dropped!");




    }
}
