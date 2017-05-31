package algsPractice.dpExercise;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * https://www.nowcoder.com/questionTerminal/b8bc8459f0d34aaa8c1af1328cab2432
 */
public class CreateNewWorld {

    static int x;
    static int n;//0
    static int m;//1
    static int[] item0;
    static int[] item1;

    static int solve2Dim() {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < x; i++) {
            for (int j = n; j >= item0[i]; j--) {
                for (int k = m; k >= item1[i]; k--) {
                    if (dp[j][k] < dp[j - item0[i]][k - item1[i]] + 1) {
                        dp[j][k] = dp[j - item0[i]][k - item1[i]] + 1;
                    }
                }
            }
        }
        return dp[n][m];
    }

    static int solve3Dim() {
        int[][][] dp = new int[x + 1][m + 1][n + 1];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    //ok
                    if (item1[i] <= j && item0[i] <= k)
                        dp[i + 1][j][k] = Math.max(dp[i][j][k], dp[i][j - item1[i]][k - item0[i]] + 1);
                    else dp[i + 1][j][k] = dp[i][j][k];

                }
            }
        }
        return dp[x][m][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        n = input.nextInt();
        m = input.nextInt();
        item0 = new int[x];
        item1 = new int[x];

        input.nextLine();
        for (int i = 0; i < x; i++) {
            String s = input.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') item0[i]++;
                else item1[i]++;
            }
        }
        System.out.println(solve3Dim());
        System.out.println(solve2Dim());
    }
}
