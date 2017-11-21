package algsPractice.competition.JSK2017.round4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    boolean[][] nm = new boolean[n][m];
    for (int i = 0; i < k; i++) {
      int d = in.nextInt();
      int c = in.nextInt() - 1;
      if (d == 0) {
        for (int j = 0; j < m; j++)
          nm[c][j] = true;
      }
      else {

        for (int j = 0; j < n; j++)
          nm[j][c] = true;
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j < m - 1) {
          if (!nm[i][j] && !nm[i][j + 1]) {
            nm[i][j] = true;
            nm[i][j + 1] = true;
            res++;
          }
        }

        if (i < n - 1) {
          if (!nm[i][j] && !nm[i + 1][j]) {
            nm[i][j] = true;
            nm[i + 1][j] = true;
            res++;
          }
        }
      }
    }
    out.write(res);
  }
}
