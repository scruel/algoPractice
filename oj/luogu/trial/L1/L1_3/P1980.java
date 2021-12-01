package algsPractice.oj.luogu.trial.L1.L1_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1980 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      int k = i;
      while (k > 0) {
        if (x == k %10) cnt++;
        k /= 10;
      }
    }
    out.println(cnt);
  }
}
