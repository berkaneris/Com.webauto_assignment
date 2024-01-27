package checkboxRadioTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductSelector_Test extends Hooks {

    @Test
    public void testProductSelectorLink(){
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnCheckboxRadioLink();
        pages.getWebAutomationPage().clickOnProductSelectorLink();

        pages.getProductSelectorPage().clickOnBrand(2);
        pages.getProductSelectorPage().clickOnBrand(3);
        Assertions.assertFalse(pages.getProductSelectorPage().isBrandSelected(2));
        Assertions.assertEquals("Brand 3",pages.getProductSelectorPage().getBrandName());

        pages.getProductSelectorPage().clickOnShape(1);
        pages.getProductSelectorPage().clickOnShape(4);
        Assertions.assertFalse(pages.getProductSelectorPage().isShapeSelected(1));
        Assertions.assertEquals("pill",pages.getProductSelectorPage().getShapeName());

        pages.getProductSelectorPage().clickOnStyle(1);
        pages.getProductSelectorPage().clickOnStyle(2);
        pages.getProductSelectorPage().clickOnStyle(3);
        Assertions.assertTrue(pages.getProductSelectorPage().isContainsStyle("border"));
        Assertions.assertEquals("blue" , pages.getProductSelectorPage().getBackgroundColor());
        Assertions.assertFalse(pages.getProductSelectorPage().isContainsStyle("shadow"));


    }
}
