package algsPractice.oj.luogu.trial.L2.L2_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1181 {
  int n, m;
  // int[] a = new int[100000 + 5];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    // a = new int[n];

    int cnt = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (sum + a <= m) {
        sum += a;
      }
      else {
        cnt++;
        sum = a;
      }
    }
    if (sum != 0) cnt++;
    out.println(cnt);
  }
}
