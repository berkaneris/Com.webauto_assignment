package controlgroupTest;

import BaseTest.Hooks;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pages.controlgroup.Toolbar_Page;
import utils.BrowserUtils;

/**
 * 1-Open the browser and navigate to the page
 * 2-Select "%75" for zoom
 * 3-Verify that if the selected zoom is displayed on the dropdown menu
 * 4-Verify that if the selected zoom is active on page
 * 5-Select "Green" for background color
 * 6-Verify that if the selected background color is displayed on the dropdown menu
 * 7-Verify that if the selected background color is active on page
 * 8-Select "Orange" for text color
 * 9-Verify that if the selected color is displayed on the dropdown menu
 * 10-Verify that if the selected color is active on page
 * 11-Click on bold button
 * 12-Verify that if bold text is active on page
 * 13-Click on italic button
 * 14-Verify that if italic text is active on page
 * 15-Click on underline button
 * 16-Verify that if underline text is active on page
 */
public class Toolbar_Test extends Hooks {

   @Test
   public void testToolbarLink(){
       //Open the browser and navigate to the page
       pages.getHomePage().clickOnWebAutomationLink();
       pages.getWebAutomationPage().clickOnControlGroupLink();
       BrowserUtils.scrollDownWithPageDown();
       pages.getWebAutomationPage().clickOnToolbarLink();

       //Select "%75" for zoom
       pages.getToolbarPage().selectZoomQuantity(2);

       SoftAssertions softAssertions = new SoftAssertions();

       //Verify that if the selected zoom is displayed on the dropdown menu
       softAssertions.assertThat(pages.getToolbarPage().getSelectedOptionFromDropDown(1)).isEqualTo("75%");
       //Verify that if the selected zoom is active on page
       softAssertions.assertThat(pages.getToolbarPage().isDropDownActiveOnTextArea(Toolbar_Page.DropDown.ZOOM)).isTrue();

       //Select "Green" for background color
       pages.getToolbarPage().selectBackgroundColor("Green");

       //Verify that if the selected background color is displayed on the dropdown menu
       softAssertions.assertThat(pages.getToolbarPage().getSelectedOptionFromDropDown(2)).isEqualTo("Green");
       //Verify that if the selected background color is active on page
       softAssertions.assertThat(pages.getToolbarPage().isDropDownActiveOnTextArea(Toolbar_Page.DropDown.BACKGROUND_COLOR)).isTrue();

       //Select "Orange" for text color
       pages.getToolbarPage().selectTextColor("Orange");

       //Verify that if the selected color is displayed on the dropdown menu
       softAssertions.assertThat(pages.getToolbarPage().getSelectedOptionFromDropDown(3)).isEqualTo("Orange");
       //Verify that if the selected color is active on page
       softAssertions.assertThat(pages.getToolbarPage().isDropDownActiveOnTextArea(Toolbar_Page.DropDown.TEXT_COLOR)).isTrue();

       //Click on bold button
       pages.getToolbarPage().clickButton(1);

       //Verify that if bold text is active on page
       softAssertions.assertThat(pages.getToolbarPage().isButtonActiveOnTextArea(Toolbar_Page.Button.BOLD)).isTrue();

       //Click on italic button
       pages.getToolbarPage().clickButton(2);

       //Verify that if italic text is active on page
       softAssertions.assertThat(pages.getToolbarPage().isButtonActiveOnTextArea(Toolbar_Page.Button.ITALIC)).isTrue();

       //Click on underline button
       pages.getToolbarPage().clickButton(3);

       //Verify that if underline text is active on page
       softAssertions.assertThat(pages.getToolbarPage().isButtonActiveOnTextArea(Toolbar_Page.Button.UNDERLINE)).isTrue();
       softAssertions.assertAll();
   }
}
