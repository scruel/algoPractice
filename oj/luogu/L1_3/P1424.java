package algsPractice.oj.luogu.L1_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1424 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    long n = in.nextLong();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      if (x != 6 && x != 7) {
        sum += 250;
      }
      x = x % 7 + 1;
    }
    out.println(sum);
  }
}
