package algsPractice.oj.nowcoder.course;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class L12_2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int n = in.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
    }

    out.println(countWaysX(a, m, n));
  }

  public int countWays(int[] penny, int n, int aim) {
    int[] f = new int[1000];
    f[0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = penny[i]; j <= aim; j++) {
        f[j] += f[j - penny[i]];
      }
    }
    return f[aim];
  }

  public int countWaysX(int[] penny, int n, int aim) {
    // write code here
    int[][] dp = new int[n][aim + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i <= aim; i++) {
      if (i % penny[0] == 0) dp[0][i] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= aim; j++) {
        dp[i][j] += dp[i - 1][j];
        if (j - penny[i] >= 0) {
          dp[i][j] += dp[i][j - penny[i]];
        }
        // for (int k = 0; k * penny[i] <= j; k++) {
        //  dp[i][j] += dp[i - 1][j - k * penny[i]];
        //}
      }
    }
    return dp[n - 1][aim];
  }
}
