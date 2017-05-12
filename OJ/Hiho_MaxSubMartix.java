package algsPractice.OJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2017/4/9.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 题目2 : 最大子矩阵
 * 时间限制:10000ms
 * 单点时限:1000ms
 * 内存限制:256MB
 * 描述
 * 给定一个NxM的矩阵A和一个整数K，小Hi希望你能求出其中最大（元素数目最多）的子矩阵，并且该子矩阵中所有元素的和不超过K。
 * <p>
 * 输入
 * 第一行包含三个整数N、M和K。
 * <p>
 * 以下N行每行包含M个整数，表示A。
 * <p>
 * 对于40%的数据，1 <= N, M <= 10
 * <p>
 * 对于100%的数据，1 <= N, M <= 250 1 <= K <= 2147483647 1 <= Aij <= 10000
 * <p>
 * 输出
 * 满足条件最大的子矩阵所包含的元素数目。如果没有子矩阵满足条件，输出-1。
 * <p>
 * 样例输入
 * 3 3 9
 * 1 2 3
 * 2 3 4
 * 3 4 5
 * 样例输出
 * 4
 * <p>
 * <p>
 * #unsolve TLE
 */
public class Hiho_MaxSubMartix {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer stk;

        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int n, m, k;
        static int[][] martix;
        static int remain;

        static int nextInt() throws IOException {
                while (remain == 0) {
                        stk = new StringTokenizer(bfr.readLine());
                        remain = stk.countTokens();
                }
                remain--;
                return new Integer(stk.nextToken());
        }

        public static void main(String[] args) throws IOException {

                n = new Integer(nextInt());
                m = new Integer(nextInt());
                k = new Integer(nextInt());

                martix = new int[n + 1][m + 1];
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                martix[i][j] = new Integer(nextInt());
                        }
                }
                System.out.println(dfs(n, m));
                bfw.close();
                bfr.close();
        }


        static int dfs(int newN, int newM) {
                if (newN <= 0 || newM <= 0) return -1;
                int max = -1;
                int sum = 0;
                for (int i = 0; i + newN <= n; i++) {
                        for (int j = 0; j + newM <= m; j++) {
                                sum = 0;
                                for (int sumI = i; sumI < newN + i; sumI++) {
                                        for (int sumJ = j; sumJ < newM + j; sumJ++) {
                                                sum += martix[sumI][sumJ];
                                                if (sum > k) break;
                                        }
                                }
                                if (sum <= k) break;
                        }
                        if (sum <= k) {
                                max = newN * newM;
                                break;
                                //某一层找到了就不需要再减少往下找了
                        }
                }
                if (max == -1)
                        return Math.max(dfs(newN - 1, newM), dfs(newN, newM - 1));
                else
                        return max;
        }
}
