package algsPractice.oj.luogu.L1_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1008 {
  OutputWriter out;
  boolean[] mk = new boolean[10];
  int[] res = new int[10];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.out = out;
    dfs(1);
  }


  private void dfs(int d) {
    if (d == 10) {
      check();
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (!mk[i]) {
        res[d] = i;
        mk[i] = true;
        dfs(d + 1);
        mk[i] = false;
      }
    }
  }

  private boolean check() {
    int a = res[1] * 100 + res[2] * 10 + res[3];
    int b = res[4] * 100 + res[5] * 10 + res[6];
    int c = res[7] * 100 + res[8] * 10 + res[9];
    if (a * 3 == c && a * 2 == b) {
      out.printf("%d %d %d\n", a, b, c);
      return true;
    }
    return false;
  }
}
