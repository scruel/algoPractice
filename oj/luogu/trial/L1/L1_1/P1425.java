package algsPractice.oj.luogu.trial.L1.L1_1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1425 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    int m, n;
    if (d >= b) {
      m = c - a;
      n = d - b;
    }
    else {
      m = c - a - 1;
      n = 60 - b + d;
    }
    if (n == 60) {
      m++;
      n = 0;
    }
    out.printf("%d %d\n", m, n);
  }
}
