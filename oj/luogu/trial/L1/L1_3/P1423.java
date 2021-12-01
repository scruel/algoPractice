package algsPractice.oj.luogu.trial.L1.L1_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1423 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    double n = in.nextDouble();
    double d = 2.0;
    double sum = 0;
    int i = 1;
    for (; ; i++) {
      sum += d;
      if (sum > n) break;
      d *= 0.98;
    }
    out.println(i);
  }
}
