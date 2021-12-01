package algsPractice.oj.luogu.trial.L2.L2_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1031 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }

    int av = sum / n;

    int ans = 0;
    // 先处理掉左端超过平均值的情况.
    int i = 0;
    while (i < n) {
      if (a[i] > av) {
        ans++;
        a[i + 1] += a[i] - av;
        a[i] = av;
      }
      else if (a[i] < av) {
        ans++;
        a[i + 1] -= av - a[i];
        a[i] = av;
      }
      i++;
    }
    out.println(ans);
  }
}
