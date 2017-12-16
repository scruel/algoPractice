package algsPractice.oj.poj;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/5.  
 * Github : https://github.com/scruel
 */
public class Task3751 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine();
    for (int i = 0; i < n; i++) {
      char[] time = input.nextLine().toCharArray();
      String year = ("" + time[0] + time[1] + time[2] + time[3]);
      String month = ("" + time[5] + time[6]);
      String day = ("" + time[8] + time[9]);
      int hour = Integer.parseInt("" + time[11] + time[12]);
      String min = ("" + time[14] + time[15]);
      String sec = ("" + time[17] + time[18]);

      String ap = "am";
      if (hour >= 12) {
        ap = "pm";
      }
      hour = (hour + 11) % 12 + 1;

      System.out.println(month + "/" + day + "/" + year + "-" + String.format("%02d", hour) + ":" + min + ":" + sec + ap);
      //                        if (calendar.get(Calendar.AM_PM) == 1)
      //                                System.out.println(hour - 12 + "pm");
      //                        else
      //                                System.out.println(hour + "am");


    }

  }


}
