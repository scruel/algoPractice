package algsPractice.dpExercise;

import algs4.MyTools;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/27.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #unsolve
 */
public class LeiDiceMy {
    static final int MOD = 1000000007;
    // others
    // 用ok数组，代替了我使用map存储的想法！
    static boolean[][] ok = new boolean[6][6];
    static Scanner in = new Scanner(System.in);
    static PrintStream out = System.out;

    public static void print_r(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[0].length; k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
    }

    static long solve(int n, int top) {
        if (n == 1) {
            return 4L;
        }
        long res = 0L;
        //计算对面数
        int op = top < 3 ? top + 3 : top - 3;
        for (int i = 0; i < 6; ++i) {
            if (ok[op][i]) {
                res = (res + solve(n - 1, i)) % MOD;
            }
        }
        return res * 4L % MOD;
    }

    public static long solve(int n) {
        long[][] dp = new long[6][n];
        for (int i = 0; i < 6; i++) {
            dp[i][0] = 4;
        }

        //dp[i][j]代表在第j层的顶面为i的方案数
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 6; k++) {
                    //op表示当前顶面的对面数字，k是上一层的顶面数字
                    int op = i < 3 ? i + 3 : i - 3;
                    if (ok[k][op]) dp[i][j] += (dp[k][j - 1] * 4) % MOD;
                }
            }
        }
        long res = 0;

        MyTools.print_r(dp);

        for (int i = 0; i < 6; i++) {
            res = (res + dp[i][n - 1]) % MOD;
        }
        return res;
    }

    public static long solve_Roll(int n) {
        long[][] dp = new long[6][2];
        for (int i = 0; i < 6; i++) {
            dp[i][0] = 4;
        }

        //dp[i][j]代表在第j层的顶面为i的方案数
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 6; i++) {
                dp[i][j & 1] = 0;
                for (int k = 0; k < 6; k++) {
                    //op表示当前顶面的对面数字，k是上一层的顶面数字
                    int op = i < 3 ? i + 3 : i - 3;
                    if (ok[k][op])
//                                                dp[i][j % 2] += (dp[k][(j - 1) % 2] * 4) % MOD;
                        dp[i][j & 1] += (dp[k][(j - 1) & 1] * 4) % MOD;
                }
            }
        }
        long res = 0;

        MyTools.print_r(dp);

        for (int i = 0; i < 6; i++) {
            res = (res + dp[i][(n - 1) % 2]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                ok[i][j] = true;
            }
        }
        for (int i = 0; i < m; ++i) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            ok[a][b] = ok[b][a] = false;
        }
        long res = 0L;
        for (int i = 0; i < 6; ++i) {
            res = (res + solve(n, i)) % MOD;
        }
        out.println(res);
        System.out.println(solve(n));
        System.out.println(solve_Roll(n));
    }
}
