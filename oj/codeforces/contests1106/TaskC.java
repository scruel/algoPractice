package algsPractice.oj.codeforces.contests1106;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class TaskC {
  int n;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    long res = 0;
    for (int i = 0; i < n / 2; i++) {
      res += Math.pow(a[i] + a[n - i - 1], 2);
    }
    out.println(res);
  }
}
