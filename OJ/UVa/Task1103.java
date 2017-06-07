package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task1103 {
    int n, m, cnt;
    int[][] pixels;
    String ress = "";
    char[] rc = {'W', 'A', 'K', 'J', 'S', 'D'};
    int[][] num = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 1, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}, {1, 1, 0, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}};
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    //    1: A
//    3: J
//    5: D
//    4: S
//    0: W
//    2: K

    void dfsBlack(int x, int y) {
        pixels[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (out(tx, ty)) {
                if (pixels[tx][ty] == 1) {
                    dfsBlack(tx, ty);
                } else if (pixels[tx][ty] == 0) {
                    cnt++;
                    dfsWhite(tx, ty);
                }
            }
        }
    }

    void dfsWhite(int x, int y) {
        pixels[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (out(tx, ty) && pixels[tx][ty] == 0) {
                dfsWhite(tx, ty);
            }
        }
    }


    boolean out(int x, int y) {
        return (x >= 0 && x <= n + 1 && y >= 0 && y <= m * 4 + 1);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int kase = 0;

        while (true) {
            ress = "";
            n = in.nextInt();
            m = in.nextInt();
            if (n == 0 && m == 0) return;
            pixels = new int[n + 2][m * 4 + 2];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    char ch = in.nextChar();
                    int[] tmp;
                    if (Character.isDigit(ch)) tmp = num[ch - 48];
                    else tmp = num[ch - 87];
//                String tmp = Integer.toBinaryString(Integer.parseInt(ch, 16));
                    System.arraycopy(tmp, 0, pixels[i], j * 4 + 1, 4);
                }
            }
            //去除包裹的白色像素点
            dfsWhite(0, 0);

            //检测黑色联通块
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m * 4 + 1; j++) {
                    if (pixels[i][j] == 1) {
                        cnt = 0;
                        dfsBlack(i, j);
                        ress += rc[cnt];
                    }

                }
            }
            char[] resc = ress.toCharArray();
            Arrays.sort(resc);
            out.writeln("Case ", ++kase, ": ", String.valueOf(resc));
        }

    }
}
