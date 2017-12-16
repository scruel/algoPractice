package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * Scanline fill
 */
public class Task572 {
  int MAXN = 100;
  int MAXM = 100;
  int n, m;
  //    int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
  //    int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
  char[][] chars = new char[MAXN + 5][MAXM + 5];
  int res = 0;

  void dfs(int x, int y) {
    chars[x][y] = '*';
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        if (dx != 0 || dy != 0) {
          int tx = x + dx;
          int ty = y + dy;
          if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
            if (chars[tx][ty] == '@') {
              dfs(tx, ty);
            }
          }
        }
      }
    }
    //        for (int i = 0; i < 8; i++) {
    //            int tx = v + dx[i];
    //            int ty = v + dy[i];
    //            if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
    //                if (chars[tx][ty] == '@') dfsWhite(tx, ty);
    //            }
    //        }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      res = 0;
      n = in.nextInt();
      m = in.nextInt();
      if (n == 0 && m == 0) {
        return;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          chars[i][j] = in.nextChar();
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (chars[i][j] == '@') {
            res++;
            dfs(i, j);
          }
        }
      }

      out.writeln(res);
    }
  }
}
