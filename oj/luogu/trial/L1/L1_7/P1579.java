package algsPractice.oj.luogu.trial.L1.L1_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1579 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 2; i <= n - 4; i++) {
      for (int j = 2; j <= n - 4; j++) {
        int k = n - (i + j);
        if (isPrime(i) && isPrime(j) && isPrime(k)) {
          out.printf("%d %d %d\n", i, j, k);
          return;
        }
      }
    }
  }

  private boolean isPrime(int v) {
    if (v < 2) {
      return false;
    }
    if (v == 2) {
      return true;
    }
    if (v % 2 == 0) return false;
    int e = (int) (Math.sqrt(v) + 0.5);
    for (int i = 2; i <= e; i++) {
      if (v % i == 0) return false;
    }
    return true;
  }
}
