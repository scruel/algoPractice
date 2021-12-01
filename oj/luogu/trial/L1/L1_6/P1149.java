package algsPractice.oj.luogu.trial.L1.L1_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1149 {
  int[] a = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt() - 4;
    int cnt = 0;
    for (int i = 0; i < 999; i++) {
      for (int j = 0; j < 999; j++) {
        int k = i + j;
        if (l(i) + l(j) + l(k) == n) {
          // out.printf("%d %d %d\n", i, j, k);
          cnt++;
        }
      }
    }
    out.println(cnt);
  }

  private int l(int n) {
    if (n == 0) return 6;
    int cnt = 0;
    while (n > 0) {
      cnt += a[n % 10];
      n /= 10;
    }
    return cnt;
  }
}
