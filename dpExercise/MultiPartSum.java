package algsPractice.dpExercise;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.  
 * Github : https://github.com/scruel
 */
public class MultiPartSum {

  static int[] a;
  static int[] m;
  static int n;
  static int K;

  public static boolean solve() {
    int[][] dp = new int[n + 1][K + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= K; j++) {
        dp[i][j] = -1000000;
      }
    }
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= K; j++) {
        if (j < a[i]) {
          dp[i + 1][j] = dp[i][j];
        }
        else {
          dp[i + 1][j] = Math.max(dp[i + 1][j - a[i]] + a[i], dp[i][j]);
        }
      }
    }

    return dp[n][K] > 0;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    a = new int[n];
    m = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    for (int i = 0; i < n; i++) {
      m[i] = input.nextInt();
    }
    K = input.nextInt();
    if (solve()) {
      System.out.println("Yes");
    }
    else {
      System.out.println("No");
    }
  }
}
