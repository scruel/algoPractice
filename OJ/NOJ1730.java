package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #dp
 */
public class NOJ1730 {
        static int[][] dp;
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {
                String s;
                while (null != (s = bfr.readLine()) && s.length() != 0) {
                        int n = Integer.parseInt(s);
                        dp = new int[2][1005];
                        for (int i = 0; i < n; i++) {
                                String[] rTs = bfr.readLine().split("\\s+");
                                for (int j = 0; j <= i; j++) {
                                        dp[(i + 1) & 1][j + 1] = Math.max(dp[i & 1][j], dp[i & 1][j + 1]) + Integer.parseInt(rTs[j]);
                                }
                        }
                        int res = 0;
                        for (int i = 1; i <= n; i++) {
                                res = Math.max(dp[n & 1][i], res);
                        }
                        System.out.println(res);
                }
        }
}
