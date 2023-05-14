package openbrowser;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Exercise {
    public static void main(String[] args) {
        String month1 = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        int dayOfMonth1 = LocalDate.now().getDayOfMonth();

        String month2 = LocalDate.now().plusDays(30).getMonth().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        int dayOfMonth2 = LocalDate.now().plusDays(10).getDayOfMonth();

        String output1= String.format("%s %s - %s",month1,dayOfMonth1,dayOfMonth2) ;
        System.out.println(output1);

        String output2= String.format("%s %s - %s %s",month1,dayOfMonth1,month2,dayOfMonth2) ;
        System.out.println(output2);








        /*LocalDate today = LocalDate.now();
        System.out.println("\nCurrent Date: " + today);
        System.out.println("10 days before today will be " + today.plusDays(-10));
        System.out.println("10 days after today will be " + today.plusDays(10) + "\n");
        LocalDate plus = today.plusDays(-10);
        // Convert dates to strings
        String todayString = today.toString();
        String tenDaysAfterTodayString = plus.toString();*/
    }


    //td[@aria-label='2, Tuesday, May 2023, Today. Available. Select as check-in date. ']
    //td[@aria-label='2, Tuesday, May 2023. Available. Select as checkout date. ']
    //td[@aria-label='1, Monday, May 2023, Today. Selected check-in date. ']

}