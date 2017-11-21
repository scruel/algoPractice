package algsPractice.others;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class E2_SLZQ {
  static void solve(int p, int e, int i, int d) {
    for (int m = d + 1; m < 21253; m++) {
      if ((m - p) % 23 == 0) {
        if ((m - e) % 28 == 0) {
          if ((m - i) % 33 == 0) {
            System.out.println("the nextString in ... " + (m - d) + " days");
            break;
          }
        }
      }

    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
      int p = input.nextInt();//23
      int e = input.nextInt();//28
      int i = input.nextInt();//33
      int d = input.nextInt();
      if (p == -1 || e == -1 || i == -1 || d == -1) {
        return;
      }
      solve(p, e, i, d);
    }

  }
}
