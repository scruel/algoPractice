package algsPractice.oj.luogu.trial.L2.L2_1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1067 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = n; i >= 0; i--) {
      int factor = in.nextInt();
      if (factor == 0) continue;
      if (i != n && factor > 0) out.print("+");
      if (factor != 1 && factor != -1) {
        out.print(factor);
      }
      else {
        if (i == 0) out.print(factor);
        else if (factor == -1) out.print("-");
      }
      if (i > 1) {
        out.printf("x^%d", i);
      }
      else if (i == 1) out.print("x");
    }
  }
}
