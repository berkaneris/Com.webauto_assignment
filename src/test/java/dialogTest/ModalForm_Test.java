package dialogTest;

import BaseTest.Hooks;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pages.dialog.ModalForm_Page;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1-Open the url and navigate to page
 * 2-Click on create account button
 * 3-Verify that dialog box is displayed
 * 4-Write inputs to the input boxes
 * 5-Click on Submit button
 * 6-Verify that if dialog box is closed
 * 7-Verify that created account information from table
 */
public class ModalForm_Test extends Hooks {
    private List<String> inputs = new ArrayList<>(Arrays.asList("Chris", "Bosh", "chrisBosh@gmail.com"));
    @Test
    public void testModalFormLink(){

        //Open the url and navigate to page
        pages.getHomePage().clickOnWebAutomationLink();
        pages.getWebAutomationPage().clickOnDialogLink();
        pages.getWebAutomationPage().clickOnModalFormLink();

        //Click on create account button
        pages.getModalFormPage().clickOnButton(ModalForm_Page.Button.CREATE_ACCOUNT);

        SoftAssertions softAssertions = new SoftAssertions();
        //Verify that dialog box is displayed
        softAssertions.assertThat(pages.getModalFormPage().isDialogBoxDisplayed()).isTrue();

        //Write inputs to the input boxes
        pages.getModalFormPage().writeInInput(ModalForm_Page.Input.NAME , inputs.get(0));
        pages.getModalFormPage().writeInInput(ModalForm_Page.Input.SURNAME , inputs.get(1));
        pages.getModalFormPage().writeInInput(ModalForm_Page.Input.EMAIL , inputs.get(2));

        //Click on Submit button
        pages.getModalFormPage().clickOnButton(ModalForm_Page.Button.SUBMIT);

        //Verify that if dialog box is closed
        softAssertions.assertThat(pages.getModalFormPage().isDialogBoxDisplayed()).isFalse();

        //Verify that created account information from table
        softAssertions.assertThat(pages.getModalFormPage().getInfoFromLastCreatedAccountInTable(ModalForm_Page.Input.NAME)).isEqualTo(inputs.get(0));
        softAssertions.assertThat(pages.getModalFormPage().getInfoFromLastCreatedAccountInTable(ModalForm_Page.Input.SURNAME)).isEqualTo(inputs.get(1));
        softAssertions.assertThat(pages.getModalFormPage().getInfoFromLastCreatedAccountInTable(ModalForm_Page.Input.EMAIL)).isEqualTo(inputs.get(2));

        softAssertions.assertAll();
    }
}
