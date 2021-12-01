package algsPractice.oj.luogu.trial.L1.L1_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P2089 {
  int n;
  int[] a = new int[10];
  StringBuilder res = new StringBuilder();
  int ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    if (n > 30) {
      out.println(0);
      return;
    }
    dfs(0, 0);
    out.println(ans);
    out.print(res);
  }

  private void dfs(int d, int sum) {
    if (d == 10) {
      if (sum == n) {
        ans++;
        for (int i = 0; i < 10; i++) {
          // if (i != 0)
          res.append(a[i]);
          res.append(" ");
        }
        res.append("\n");
      }
      return;
    }
    if (sum >= n) return;
    for (int i = 1; i <= 3; i++) {
      a[d] = i;
      dfs(d + 1, sum + i);
    }
  }
}
