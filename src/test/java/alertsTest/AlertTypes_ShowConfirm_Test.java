package alertsTest;

import BaseTest.Hooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.BrowserUtils;

/**
 * 1. Land on home page
 * 2. click on web automation link
 * 3. click on the Alerts button
 * 4. click on the Alert Types button
 * 5. click on the Show Confirm button
 * 6. verify that alert text is "Are you sure?"
 * 7. confirm the alert
 * 8. Verify that alert text is "Confirmed!"
 * 9. confirm the alert
 * 10. click on the Show Alert button
 * 11. cancel the alert
 */
public class AlertTypes_ShowConfirm_Test extends Hooks {

    @Test
    public void testShowConfirm(){
        //1. Land on home page
        //2. click on web automation link
        pages.getHomePage().clickOnWebAutomationLink();

        BrowserUtils.scrollDownWithPageDown();

        //3. click on the Alerts button
        pages.getWebAutomationPage().clickOnAlertsLink();

        BrowserUtils.scrollUpWithPageUp();

        //4. click on the Alert Types button
        //5. click on the Show Alert button
        pages.getAlertTypesPage().clickOnShowConfirmButton();

        BrowserUtils.wait(2);

        //6. verify that alert text is "Are you sure?"
        String expectedText = "Are you sure?";
        String actualText = pages.getAlertTypesPage().getTextOfTheAlert();
        Assertions.assertEquals(expectedText, actualText, "Wrong Text Prompted !");

        BrowserUtils.wait(2);

        //7. confirm the alert
        pages.getAlertTypesPage().confirmTheAlert();

        //8.Verify that alert text is "Confirmed!"
        String expectedText2 = "Confirmed!";
        String actualText2 = pages.getAlertTypesPage().getTextOfTheAlert();
        Assertions.assertEquals(expectedText2, actualText2, "Wrong Text Prompted !");

        //9. confirm the alert
        pages.getAlertTypesPage().confirmTheAlert();

        //10. click on the Show Alert button
        pages.getAlertTypesPage().clickOnShowConfirmButton();

        BrowserUtils.wait(2);

        //11. cancel the alert
        pages.getAlertTypesPage().cancelTheAlert();
    }
}
