package datepickerTest;

import BaseTest.Hooks;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


/**
 *1-Open the url and navigate to page
 *2-Click date box and select "03/05/2025" as a date
 *3-Verify from date box that if the written date is "03/05/2025"
 *4-Verify that if the selected day is "03/05/2025"
 *5-Clear the date box
 *6-Enter "03/04/2024" as date
 *7-Verify that if the selected day is "03/04/2024"
 */
public class DisplayMultipleMonths_Test extends Hooks {

   @Test
   public void testDisplayMultipleMonthsLink(){
       //Open the url and navigate to page
       pages.getHomePage().clickOnWebAutomationLink();
       pages.getWebAutomationPage().clickOnDatePickerLink();
       pages.getWebAutomationPage().clickOnDisplayMultipleMonthsLink();

       //Click date box and select "03/05/2025" as a date
       pages.getDisplayMultipleMonthsPage().clickDateBox();
       for(int i = 0; i < 12; i++){
           pages.getDisplayMultipleMonthsPage().clickNextMarker();
       }
       pages.getDisplayMultipleMonthsPage().selectDay(3 , 5 , 2025);

       SoftAssertions softAssertions = new SoftAssertions();
       //Verify from date box that if the written date is "03/05/2025"
       softAssertions.assertThat(pages.getDisplayMultipleMonthsPage().getDateFromBox()).as("The date is not equal to selected date").isEqualTo("03/05/2025");

       //Verify that if the selected day is true
       pages.getDisplayMultipleMonthsPage().clickDateBox();
       softAssertions.assertThat(pages.getDisplayMultipleMonthsPage().getSelectedDate()).as("The date is not equal to selected date").isEqualTo("03/05/2025");

       //Clear the date box
       pages.getDisplayMultipleMonthsPage().clearDateBox();

       //Enter "03/04/2024" as date
       pages.getDisplayMultipleMonthsPage().writeDateToBox("03" , "04" , "2024");

       //Verify that if the selected day is "03/04/2024"
       softAssertions.assertThat(pages.getDisplayMultipleMonthsPage().getSelectedDate()).as("The date is not equal to selected date").isEqualTo("03/04/2024");

       softAssertions.assertAll();
   }
}
