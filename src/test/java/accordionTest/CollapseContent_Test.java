package accordionTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.BrowserUtils;

public class CollapseContent_Test extends Hooks {

    @Test
    public void testCollapseContentLink(){
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnAccordionLink();
        pages.getWebAutomationPage().clickOnCollapseContentLink();

        Assertions.assertTrue(pages.getCollapseContentPage().isContentDisplayed(1));

        pages.getCollapseContentPage().clickOnAccordionElement(3);

        BrowserUtils.wait(1);

        Assertions.assertFalse(pages.getCollapseContentPage().isContentDisplayed(1));

        Assertions.assertTrue(pages.getCollapseContentPage().isContentDisplayed(3));

        pages.getCollapseContentPage().clickOnAccordionElement(3);

        BrowserUtils.wait(1);

        Assertions.assertFalse(pages.getCollapseContentPage().isContentDisplayed(3));
    }
}
