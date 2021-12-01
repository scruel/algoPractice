package algsPractice.oj.luogu.trial.L1.L1_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1909 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < 3; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = n / a;
      if (n % a != 0) {
        c++;
      }
      c = c * b;
      min = c < min ? c : min;
    }
    out.println(min);
  }
}
