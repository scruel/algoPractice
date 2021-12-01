package algsPractice.oj.luogu.trial.L1.L1_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1089 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int remain = 0;
    int save = 0;
    for (int i = 1; i <= 12; i++) {
      int p = in.nextInt();
      remain += 300;
      if (p > remain) {
        out.println("-" + i);
        return;
      }
      int r = remain - p;
      int m = (r / 100) * 100;
      remain = r - m;
      save += m;
    }
    out.printf("%d\n", (int) (save * 1.2) + remain);
  }
}
