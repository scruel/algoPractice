package algsPractice.OJ;

/**
 * Created by Scruel on 2017/4/9.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #dfs 点线面分割
 */
public class LQSS2017_BQ4Divide {
        static int count = 0;
        static int N = 6;

        //R
        static int[] directedX = {0, -1, 0, 1};
        static int[] directedY = {1, 0, -1, 0};
        static int[][][] border = {{{0, 1}, {1, 1}}, {{0, 0}, {0, 1}}, {{0, 0}, {1, 0}}, {{1, 0}, {1, 1}}};
        static boolean[][] marked = new boolean[N + 1][N + 1];
        static int[][] puzzle;
        static boolean[][] markedPz = new boolean[N][N];

        public static void main(String[] args) {
//                for (int i = 0; i < 4; i++) {
                marked[N / 2][N / 2] = true;
                //外层不需要，因为进入到dfs中就是遍历4个方向
                dfs(N / 2, N / 2);
//                }
                //这里需要/4，因为题目要求对称旋转都是相同分法
                System.out.println(count / 4);
        }

        static void createPuz(int x, int y) {
//                for (int m = 0; m < N; m++) {
//                        for (int n = 0; n < N; n++) {
//                                boolean flag = false;
//                                boolean flag2 = false;
//                                //右边
//                                for (int i = n; i < N; i++) {
//                                        if (marked[m][i + 1] && marked[m + 1][i + 1])
//                                                flag = true;
//                                }
//                                //下边
//                                for (int j = m; j < N; j++) {
//                                        if (marked[j + 1][n] && marked[j + 1][n + 1])
//                                                flag2 = true;
//                                }
//                                if (flag && flag2)
//                                        puzzle[m][n] = 1;
//                        }
//                }


                puzzle[x][y] = 1;
                //marked[x][y] && marked[x][y + 1] ||
                //  marked[x][y] && marked[x + 1][y] ||
//                if (
//                        marked[x][y + 1] && marked[x + 1][y + 1] ||
//
//                        marked[x + 1][y] && marked[x + 1][y + 1]) {
//                        return;
//                }


                //右上左下
                for (int i = 0; i < 4; i++) {
                        int tx = x + directedX[i];
                        int ty = y + directedY[i];
                        if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
                                if (!markedPz[tx][ty]) {
                                        if (!(marked[x + border[i][0][0]][y + border[i][0][1]] && marked[x + border[i][1][0]][y + border[i][1][1]])) {
                                                markedPz[tx][ty] = true;
                                                createPuz(tx, ty);
                                                markedPz[tx][ty] = false;
                                        }
                                }
                        }

                }
//                tx = x;
//                ty = y - 1;
//                //  marked[x][y] && marked[x + 1][y] ||
//                if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
//                        if (!markedPz[tx][ty]) {
//                                if (!marked[x][y] || !marked[x + 1][y]) {
//                                        markedPz[tx][ty] = true;
//                                        createPuz(tx, ty);
//                                        markedPz[tx][ty] = false;
//                                }
//                        }
//                }
//
//                tx = x + 1;
//                ty = y;
//                if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
//                        if (!markedPz[tx][ty]) {
//                                if (!marked[x + 1][y] || !marked[x + 1][y + 1]) {
//                                        markedPz[tx][ty] = true;
//                                        createPuz(tx, ty);
//                                        markedPz[tx][ty] = false;
//                                }
//                        }
//                }
//
//
//                tx = x - 1;
//                ty = y;
//                //marked[x][y] && marked[x][y + 1] ||
//                if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
//                        if (!markedPz[tx][ty]) {
//                                if (!marked[x][y] || !marked[x][y + 1]) {
//                                        markedPz[tx][ty] = true;
//                                        createPuz(tx, ty);
//                                        markedPz[tx][ty] = false;
//                                }
//                        }
//                }


//                for (int i = 0; i < 4; i++) {
//
//                        if (tx >=0 && ty >=0 && tx < N && ty < N) {
//                                if (!markedPz[tx][ty]){
//                                        if (! marked[tx][ty + 1] && marked[tx + 1][ty + 1] &&
//                                                        !marked[tx + 1][ty] && marked[tx + 1][ty + 1]) {
//                                                markedPz[tx][ty] = true;
//                                                createPuz(tx, ty);
//                                                markedPz[tx][ty] = false;
//                                        }
//                                }
//                        }
//                }
        }

        static void dfs(int x, int y) {
                if (x == 0 || x == N || y == 0 || y == N) {
                        count++;
                        puzzle = new int[6][6];
                        createPuz(0, 0);
                        System.out.println(count);
                        for (int i = 0; i < N; i++) {
                                for (int j = 0; j < N; j++) {
                                        //使用三元运算符，在判断失效的情况下会导致短路，所以不要在输出语句等后面包含必须执行的语句的语句中使用。
                                        System.out.print(puzzle[i][j]);
//                                        System.out.print(puzzle[i][j] == 0 ? 1 : 0 );
                                        System.out.print(" ");
                                }
                                System.out.println();
                        }
                        System.out.println();
                        return;
                }
                for (int i = 0; i < 4; i++) {
                        int tx = x + directedX[i];
                        int ty = y + directedY[i];
                        if (!marked[tx][ty]) {
                                //当前方向走过标记
                                marked[tx][ty] = true;
                                //对称方向走过标记
                                marked[N - tx][N - ty] = true;
                                dfs(tx, ty);
                                marked[tx][ty] = false;
                                marked[N - tx][N - ty] = false;
                        }
                }
        }
}
