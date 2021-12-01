package algsPractice.oj.codeforces.contests1106;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class TaskA {
  int n;
  char[][] c;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    c = new char[n][n];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        c[i][j] = (char) in.read();
      }
      in.read();
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (M(i, j) && M(i - 1, j - 1)
            && M(i - 1, j + 1) && M(i + 1, j - 1)
            && M(i + 1, j + 1)) {
          res++;
        }
      }
    }
    out.print(res);
  }

  boolean M(int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= n) return false;
    return c[i][j] == 'X';
  }
}
