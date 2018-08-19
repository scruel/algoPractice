package algsPractice.oj.luogu.L1_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1035 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    double sum = 0;
    int n = 1;
    for (; ; n++) {
      sum += 1.0 / n;
      if (sum > k) break;
    }
    out.println(n);
  }
}
