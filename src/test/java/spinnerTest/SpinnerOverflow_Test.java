package spinnerTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class SpinnerOverflow_Test extends Hooks {

    @Test
    public void testSpinnerOverflowLink(){
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnSpinnerLink();
        pages.getWebAutomationPage().clickOnSpinnerOverFlowLink();

        String initialValue = pages.getSpinnerOverflowPage().getValueFromInputBox();

        IntStream.range(0,6).forEach(i -> pages.getSpinnerOverflowPage().clickOnUpSideHandle());
        Assertions.assertEquals("-10" , pages.getSpinnerOverflowPage().getValueFromInputBox());

        IntStream.range(0,3).forEach(i -> pages.getSpinnerOverflowPage().clickOnDownSideHandle());
        Assertions.assertEquals("8" , pages.getSpinnerOverflowPage().getValueFromInputBox());
    }
}
