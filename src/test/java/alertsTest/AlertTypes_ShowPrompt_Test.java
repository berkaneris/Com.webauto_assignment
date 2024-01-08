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
 * 5. click on the Show Prompt button
 * 6. verify that alert text is "Enter your name:"
 * 7. Enter "Inar" as a name to the text box
 * 8. confirm the alert
 * 9. Verify that alert text is "Hello, Inar!"
 * 10. confirm the alert
 * 11. click on the Show Prompt button
 * 12. cancel the alert
 */

public class AlertTypes_ShowPrompt_Test extends Hooks {

    @Test
    public void testShowPrompt(){

        //1. Land on home page
        //2. click on web automation link
        pages.getHomePage().clickOnWebAutomationLink();

        BrowserUtils.scrollDownWithPageDown();

        //3. click on the Alerts button
        pages.getWebAutomationPage().clickOnAlertsLink();

        BrowserUtils.scrollUpWithPageUp();

        //4. click on the Alert Types button
        //5. click on the Show Prompt button
        pages.getAlertTypesPage().clickOnShowPromptButton();

        BrowserUtils.wait(2);

        //6. verify that alert text is "Enter your name:"
        String expectedText = "Enter your name:";
        String actualText = pages.getAlertTypesPage().getTextOfTheAlert();
        Assertions.assertEquals(expectedText, actualText, "Wrong Text Prompted !");

        //7. Enter "Inar" as a name to the text box
        pages.getAlertTypesPage().enterInputIntoAlert("Inar");


        //8. confirm the alert
        pages.getAlertTypesPage().confirmTheAlert();

        BrowserUtils.wait(2);

        //9. Verify that alert text is "Hello, Inar!"
        String expectedText2 = "Hello, Inar!";
        String actualText2 = pages.getAlertTypesPage().getTextOfTheAlert();
        Assertions.assertEquals(expectedText, actualText, "Wrong Text Prompted !");

        //10. confirm the alert
        pages.getAlertTypesPage().confirmTheAlert();

        //11. click on the Show Prompt button
        pages.getAlertTypesPage().clickOnShowPromptButton();

        //12. cancel the alert
        pages.getAlertTypesPage().cancelTheAlert();


    }
}
