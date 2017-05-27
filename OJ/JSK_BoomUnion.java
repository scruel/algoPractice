package algsPractice.OJ;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/1.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 计蒜客模拟赛5第9题
 * #union
 */
public class JSK_BoomUnion {

    static int n;
    static int m;
    static int[][] puzzle;
    static int[][] check;
    static int res;
    //保存连通情况
    static Point[][] uf;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean testKen = true;
        if (testKen) {
            n = 1000;
            m = 1000;
        } else {
            n = input.nextInt();
            m = input.nextInt();
            input.nextLine();
        }
        puzzle = new int[n][m];
        check = new int[n][m];
        uf = new Point[n][m];
//                resIndex = n * m;
        for (int i = 0; i < n; i++) {
            if (testKen) {
                for (int j = 0; j < m; j++) {
                    puzzle[i][j] = 1;
                }
            } else {
                char[] chars = input.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    puzzle[i][j] = chars[j] - 48;
//                                puzzle[i][j] = 1;
                }
            }
        }
        long time = System.currentTimeMillis();
        solveUF();
        System.out.println(System.currentTimeMillis() - time);

//                Point point = null;
//                for (int i = 0; i < n; i++) {
//                        for (int j = 0; j < m; j++) {
//                                if ()
//                        }
//                }
        System.out.println(res);

    }

    static void solveUF() {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (puzzle[i][j] == 1)
                    res++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                uf[i][j] = new Point(i, j);
            }
        }


        //连通每一行
        for (int i = 0; i < n; i++) {
            Point first = null;
            for (int j = 0; j < m; j++) {
                if (puzzle[i][j] == 1) {
                    if (first == null) {
                        first = uf[i][j];
                    } else {
                        union(first, uf[i][j]);
                    }
                }
            }
        }
        //连通每一列
        for (int j = 0; j < m; j++) {
            Point first = null;
            for (int i = 0; i < n; i++) {
                if (puzzle[i][j] == 1) {
                    if (first == null) {
                        first = uf[i][j];
                    } else {
                        union(first, uf[i][j]);
                    }
                }
            }
        }
    }

    static Point find(Point point) {
        //TODO 优化find
        while (point.father != null) {
            point = point.father;
        }

        //优化查找
//                Point temp = point;
//                //找到根节点
//                while (point.father != null) {
//                        point = point.father;
//                }
//                while (temp.father != null) {
//                        temp.father = point;
//                        temp = temp.father;
//                }

        return point;
    }

    static void union(Point i, Point j) {
        Point ri = find(i);
        Point rj = find(j);

        if (ri == rj)
            return;
        //一直连接，发现可以连接的对象
        res--;
        j.father = ri;
    }

    static void dfs(int i, int j) {
        puzzle[i][j] = -1;
        for (int p = 0; p < i; p++) {
            if (puzzle[p][j] == 1) {
                puzzle[p][j] = -1;
                dfs(p, j);
            }
        }

        for (int p = i + 1; p < n; p++) {
            if (puzzle[p][j] == 1) {
                puzzle[p][j] = -1;
                dfs(p, j);
            }
        }
        for (int q = 0; q < j; q++) {
            if (puzzle[i][q] == 1) {

                puzzle[i][q] = -1;
                dfs(i, q);
            }
        }
        for (int q = j + 1; q < m; q++) {
            if (puzzle[i][q] == 1) {
                puzzle[i][q] = -1;
                dfs(i, q);
            }
        }
//                puzzle[i][j] = 0;
//                for (int p = 0; p < n; p++) {
//                        if (puzzle[p][j] == 1)
//                                dfs(i, j);
//                }
//
//                for (int q = 0; q < m; q++) {
//                        if (puzzle[i][q] == 1)
//                                dfs(i, j);
//                }
    }

    static class Point {
        //这里的xy其实是冗余的，并没有用到
        int x, y;
        Point father = null;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
