package algsPractice.others;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class E1_PerfectCube {

  static void solve(int N) {
    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= N; j++) {
        for (int m = j + 1; m <= N; m++) {
          for (int n = m + 1; n <= N; n++) {
            if (i * i * i == j * j * j + m * m * m + n * n * n) {
              System.out.println("Cube=" + i + ",Triple=(" + j + "," + m + "," + n + ")");
            }
          }
        }
      }
    }
  }


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    solve(input.nextInt());
  }

}
