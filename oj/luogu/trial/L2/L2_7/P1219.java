package algsPractice.oj.luogu.trial.L2.L2_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1219 {
  OutputWriter out;
  int n, cnt;
  // lines[i] 表示第 i 行的皇后放在第 lines[i] 列上.
  int[] lines = new int[13 + 5];
  boolean[] mk = new boolean[n + 1];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    cnt = 0;
    this.out = out;
    n = in.nextInt();
    dfs(1);
    out.println(cnt);
  }

  public void dfs(int i) {
    if (i == n + 1) {
      if (cnt < 3) {
        for (int j = 1; j <= n; j++) {
          if (j != 1) out.print(" ");
          out.print(lines[j]);
        }
        out.println();
      }
      cnt++;
      return;
    }

    // 筛选当前行可用的列
    for (int ii = 1; ii < i; ii++) {
      mk[lines[ii]] = true;
      int v = i - ii;
      if (lines[ii] - v > 0) {
        mk[lines[ii] - v] = true;
      }
      if (v + lines[ii] <= n) {
        mk[v + lines[ii]] = true;
      }
    }

    for (int j = 1; j <= n; j++) {
      if (!mk[j]) {
        mk[j] = true;
        lines[i] = j;
        dfs(i + 1);
        lines[i] = 0;
      }
    }
  }
}
