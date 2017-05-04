package practice.algsoj;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/9.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * https://hihocoder.com/problemset/problem/1504
 * unsolved
 */
public class Hiho_HorseTravel {
        static int[][] cb = new int[8][8];
        static int N, R, C;
        static final int MOD = 1000000007;

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                N = input.nextInt();
                R = input.nextInt() - 1;
                C = input.nextInt() - 1;
                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                                cb[i][j] = countNum(i, j);
                        }
                }
                System.out.println(dfs(R, C, N));
        }

        static long dfs(int p, int q, int n) {
                if (n == 0)
                        return 1;
                int res = 0;
//                System.out.println("n:" + n + "loc:" + p + " " + q);
                for (int i = 0; i < 8; i++) {
                        if (ok(p + directI[i], q + directJ[i]))
                                res += dfs(p + directI[i], q + directJ[i], n - 1);
                }
//                System.out.println("next:" + resIndex + "   loc:" + p + " " + q);
                return res;
        }

        static boolean ok(int i, int j) {
                return i >= 0 && i < 8 && j >= 0 && j < 8;
        }

        static int[] directI = {-2, -1, -2, -1, +1, +2, +1, +2};
        static int[] directJ = {-1, -2, +1, +2, -2, -1, +2, +1};

        static int countNum(int p, int q) {
                int sum = 0;
                for (int i = 0; i < 8; i++) {
                        if (ok(p + directI[i], q + directJ[i]))
                                sum++;
                }
                return sum;
        }
}
