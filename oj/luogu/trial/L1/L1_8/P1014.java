package algsPractice.oj.luogu.trial.L1.L1_8;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1014 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    boolean f = false;
    int b = 2;
    int v = 1;
    int x = 2;
    while (v < n) {
      v += b++;
      f = !f;
      x++;
    }
    int n1 = v - n + 1;
    int n2 = x - n1;
    if (f) out.printf("%d/%d\n", n2, n1);
    else out.printf("%d/%d\n", n1, n2);
  }
}
