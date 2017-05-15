package algsPractice.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Scruel on 2017/4/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #dp 泛化背包
 */
public class Hiho_1091 {
        static int[] damage;
        static int[] cost;
        static int[][] dp;
        static int n;
        static int m;
//        static int[] level;


        public static void main(String[] args) throws IOException {
                System.out.println(1 << 16);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                String[] rts = bfr.readLine().split("\\s+");
                n = Integer.parseInt(rts[0]);
                m = Integer.parseInt(rts[1]);
                damage = new int[n];
                cost = new int[n];
                for (int i = 0; i < n; i++) {
                        rts = bfr.readLine().split("\\s+");
                        damage[i] = Integer.parseInt(rts[0]);
                        cost[i] = Integer.parseInt(rts[1]);
                }

                System.out.print(solve());
        }

        static int solve() {
                dp = new int[n + 1][m + 1];
                //dp[i][j]代表在j价值下英雄0...i-1可造成伤害的最大值
                for (int i = 0; i < n; i++) {
                        int total = cost[i];
                        for (int j = 0; j < m + 1; j++) {
                                //不升级该英雄（damage = 0）
                                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                                int nlCost = cost[i];
                                int lastCost = nlCost;
                                for (int level = 1; ; level++) {
                                        //升级英雄
                                        if (j >= nlCost) {
                                                dp[i + 1][j] = Math.max((dp[i][j - nlCost]) + damage[i] * level, dp[i + 1][j]);
                                        }
                                        if (nlCost > m) break;
                                        lastCost = (int) (1.07 * lastCost);
                                        nlCost += lastCost;
                                }
                        }
                }
                return dp[n][m];
        }
}
