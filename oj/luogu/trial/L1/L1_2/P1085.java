package algsPractice.oj.luogu.trial.L1.L1_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1085 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = 0;
    int d = 0;
    for (int i = 1; i <= 7; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int s = a + b;
      if (s > 8 && s > m) {
        m = s;
        d = i;
      }
    }
    out.println(d);
  }
}
