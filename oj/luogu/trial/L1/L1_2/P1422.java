package algsPractice.oj.luogu.trial.L1.L1_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1422 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    double res = 0;
    if (n > 400) {
      int t = n - 400;
      n -= t;
      res += t * 0.5663;
    }
    if (n > 150) {
      int t = n - 150;
      n -= t;
      res += t * 0.4663;
    }
    res += n * 0.4463;
    out.printf("%.1f\n", res);
  }
}
