package algsPractice.oj_t;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/9.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #details
 */
public class LQSS2017_BQ3CQ4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = 29;
    //                long[][] weight = new long[2][n + 1];
    double[][] weight = new double[2][n + 2];
    //                double[][] weight = new double[2][n + 1];

    //11 3 13
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < i + 2; j++) {
        double num = input.nextInt();
        weight[i & 1][j] = (num + (weight[(i + 1) & 1][j] + weight[(i + 1) & 1][j - 1]) / 2);
      }
    }
    for (int j = 1; j < 31; j++) {
      weight[n & 1][j] = (weight[(n + 1) & 1][j] + weight[(n + 1) & 1][j - 1]) / 2;
    }
    System.out.println();
    double min = Integer.MAX_VALUE;
    double max = -1;

    //最后的结果即为之前循环的最后一个数，即n-1
    for (int i = 1; i <= n + 1; i++) {
      if (weight[n & 1][i] < min) {
        min = weight[n & 1][i];
      }
      if (weight[n & 1][i] > max) {
        max = weight[n & 1][i];
      }
      System.out.print(weight[n & 1][i] + " ");
    }
    System.out.println();
    System.out.println(min);
    System.out.printf("%f\n", min);
    System.out.printf("%f\n", 2086458231.0 / min);
    System.out.printf("%f", (long) (2086458231.0 / min) * max);
  }


}
