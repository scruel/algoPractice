package algsPractice.competition.nod51.mls24;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/30.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskC {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    for (int i = 0; i < n; i++) {
      Random rm = new Random();
      if ((rm.nextInt() & 3) == 0) {
        System.out.println("Yes");
      }
      else {
        System.out.println("No");
      }
    }
  }
}
