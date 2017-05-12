package algsPractice.OJ;

/**
 * Created by Scruel on 2017/4/1.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #unsolve 计蒜客模拟赛5第十题 守卫问题 hit:状态压缩dp 轮廓线dp
 */

import java.util.*;

public class JSK_guardProblem {
        static int n;
        static int m;
        static int[][] puzzle;
        static boolean[][] guard;
        static int[][] guarSum;
        static int res = 0;


        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                n = input.nextInt();
                m = input.nextInt();
                puzzle = new int[n][m];
                guard = new boolean[n][m];
                guarSum = new int[n][m];

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                puzzle[i][j] = input.nextInt();
                        }
                }

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                //是否可以放置守卫
                                if (puzzle[i][j] == 1)
                                        dfs(i, j);
                        }
                }
                System.out.println(res);
        }


        static boolean ok(int i, int j) {
                return i >= 0 && i < n && j >= 0 && j < m;
        }


        static void dfs(int i, int j) {
                //尝试在当前位置放置警卫
//                resIndex++;


                int RightRes = 1;
                int NoRes = 999999999;//非冗余情况要放
                //检测自己放了是否冗余，冗余的时候再次选择
                if (ok(i - 1, j) && ok(i, j - 1) && ok(i, j + 1)) {
                        if (guarSum[i - 1][j] > 0 && guarSum[i][j - 1] > 0 && guarSum[i][j + 1] > 0) {
                                if (guarSum[i][j] > 0) {
                                        NoRes = 0;
                                }
                        }
                }

                if (ok(i - 1, j) && ok(i, j - 1)) {
                        if (guarSum[i - 1][j] > 0 && guarSum[i][j - 1] > 0) {
                                if (guarSum[i][j] > 0) {
                                        NoRes = 0;
                                }
                        }
                }

                if (ok(i - 1, j) && ok(i, j + 1)) {
                        if (guarSum[i - 1][j] > 0 && guarSum[i][j + 1] > 0) {
                                if (guarSum[i][j] > 0) {
                                        NoRes = 0;
                                }
                        }
                }

                if (ok(i, j - 1) && ok(i, j + 1)) {
                        if (guarSum[i][j - 1] > 0 && guarSum[i][j + 1] > 0) {
                                if (guarSum[i][j] > 0) {
                                        NoRes = 0;
                                }
                        }
                }

                //判断三个方向的的警卫是否可以被替代，这里可以被优化
                // i-1, j
                if (ok(i - 1, j)) {
                        if (replaceable(i - 1, j)) {
                                RightRes--;
                        }
                }
                //i, j - 1
                if (ok(i, j - 1)) {
//                        if (puzzle[i][j - 1] == 0) {
//                                if (guarSum[i][j - 1] > 1) {
//                                        guarSum[i][j - 1]--;
//                                        RightRes--;
//                                        guard[i][j] = false;
//                                        guarSum[i][j]--;
//                                        return;
//                                }
//                        } else if (replaceable(i, j - 1)) {
                        if (replaceable(i, j - 1)) {
                                RightRes--;
                        }
                }
                //i, j + 1
                if (ok(i, j + 1)) {
//                        if (puzzle[i][j + 1] == 0) {
//                                if (guarSum[i][j + 1] > 1) {
//                                        guarSum[i][j + 1]--;
//                                        RightRes--;
//                                        guard[i][j] = false;
//                                        guarSum[i][j]--;
//                                        return;
//                                }
//                        } else if (replaceable(i, j + 1)) {
                        if (replaceable(i, j + 1)) {
                                RightRes--;
                        }
                }

                //是否放置
                if (RightRes < NoRes) {
                        guard[i][j] = true;
                        guarSum[i][j]++;
                        res += RightRes;
                        if (ok(i - 1, j))
                                guarSum[i - 1][j]++;
                        if (ok(i, j - 1))
                                guarSum[i][j - 1]++;
                        if (ok(i, j + 1))
                                guarSum[i][j + 1]++;
                } else {
                        res += NoRes;
                }

        }

        static boolean replaceable(int i, int j) {
                //当前的守卫是否可以被替换
                if (!guard[i][j]) return false;
                if (ok(i, j)) {
                        if (guarSum[i][j] - 1 < 0)
                                return false;
                }
                if (ok(i - 1, j)) {
                        if (guarSum[i - 1][j] - 1 < 0)
                                return false;
                }
                //i, j - 1
                if (ok(i, j - 1)) {
                        if (guarSum[i][j - 1] - 1 < 0)
                                return false;
                }
                //i, j + 1
                if (ok(i, j + 1)) {
                        if (guarSum[i][j + 1] - 1 < 0)
                                return false;
                }
                //当前位置的守卫被取消
                guard[i][j] = false;
                guarSum[i][j]--;
                if (ok(i - 1, j)) guarSum[i - 1][j]--;
                if (ok(i, j - 1)) guarSum[i][j - 1]--;
                if (ok(i, j + 1)) guarSum[i][j + 1]--;
                return true;
        }

}