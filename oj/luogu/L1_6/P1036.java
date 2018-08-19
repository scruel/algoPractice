package algsPractice.oj.luogu.L1_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1036 {
  int n, k;
  int[] a;
  boolean[] mk;
  int[] res;
  int ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    k = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < (1 << n); i++) {
      int cnt = 0;
      int v = 0;
      for (int j = 0; j < n; j++) {
        // 是否选取第 j 个数字
        if ((1 & (i >> j)) == 1) {
          cnt++;
          v += a[j];
        }
      }
      if (cnt == k && isPrime(v)) ans++;
    }
    out.println(ans);
  }

  public void solvex(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    a = new int[n];
    mk = new boolean[n];
    res = new int[k];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    f(0, 0, 0);
    out.println(ans);
  }

  private void f(int start, int d, int sum) {
    if (d == k) {
      if (isPrime(sum)) ans++;
      return;
    }
    for (int i = start; i < n; i++) {
      if (!mk[i]) {
        res[d] = a[i];
        mk[i] = true;
        f(i + 1, d + 1, sum + a[i]);
        mk[i] = false;
      }
    }
  }

  private boolean isPrime(int v) {
    int e = (int) (Math.sqrt(v) + 0.5);
    for (int i = 2; i <= e; i++) {
      if (v % i == 0) return false;
    }
    return true;
  }
}
