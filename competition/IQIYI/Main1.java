package algsPractice.competition.IQIYI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Scruel on 2017/5/14.  
 * Github : https://github.com/scruel
 */
public class Main1 {
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static String[] rts;
  static int[] w;
  static int[] v;
  static int[] dp;
  //        static int[][] dp;
  static int wAll, n;


  public static void main(String[] args) throws IOException {
    rts = bfr.readLine().trim().split("\\s+");
    n = rts.length / 2;
    wAll = Integer.parseInt(rts[0]);
    w = new int[n];
    v = new int[n];
    int cnt = 0;
    dp = new int[wAll + 1];
    //                dp = new int[n + 1][wAll + 1];
    for (int i = 1; i < 2 * n; i += 2) {
      w[cnt] = Integer.parseInt(rts[i]);
      v[cnt++] = Integer.parseInt(rts[i + 1]);
    }
    long temp = wAll;
    for (int i = 0; i < n; i++) {
      temp -= w[i];
    }
    for (int i = 0; i < n; i++) {
      for (int j = wAll; j >= Math.max(w[i], temp); j--) {
        dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
      }
    }
    //                for (int i = 0; i < n; i++) {
    //                        for (int j = 0; j <= wAll; j++) {
    //                                if (j >= w[i]) {
    //                                        dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
    //                                } else {
    //                                        dp[i + 1][j] = dp[i][j];
    //                                }
    //                        }
    //                }
    bfw.write(String.format("%d", dp[wAll]));

    bfr.close();
    bfw.close();
  }
}
