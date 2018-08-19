package algsPractice.oj.luogu.L1_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1028 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    a[0] = a[1] = 1;
    for (int i = 2; i <= n; i++) {
      if (i % 2 == 0) {
        a[i] = a[i - 1] + a[i / 2];
      }
      else {
        a[i] = a[i - 1];
      }
    }
    out.println(a[n]);
  }
}
