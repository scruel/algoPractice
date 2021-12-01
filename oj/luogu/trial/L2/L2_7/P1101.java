package algsPractice.oj.luogu.trial.L2.L2_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1101 {
  int n;
  int maxn = 100 + 5;
  char[][] chars = new char[maxn][maxn];
  boolean[][] mk = new boolean[maxn][maxn];
  int[] di = {0, 0, -1, 1, 1, -1, -1, 1};
  int[] dj = {1, -1, 0, 0, 1, -1, 1, -1};
  String m1 = "yizhong";

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    chars = new char[n][n];
    for (int i = 0; i < n; i++) {
      chars[i] = in.readLine().toCharArray();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (chars[i][j] == 'y') {
          for (int k = 0; k < 8; k++) {
            dfs(i, j, di[k], dj[k], 0);
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (mk[i][j]) out.print(chars[i][j]);
        else out.print('*');
      }
      out.println();
    }
  }

  private boolean dfs(int i, int j, int di, int dj, int deep) {
    if (deep == m1.length()) return true;
    if (i >= n || i < 0 || j >= n || j < 0) return false;
    if (chars[i][j] != m1.charAt(deep)) return false;
    if (dfs(i + di, j + dj, di, dj, deep + 1)) {
      mk[i][j] = true;
      return true;
    }
    return false;
  }
}
