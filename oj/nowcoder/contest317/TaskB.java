package algsPractice.oj.nowcoder.contest317;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a[] = new int[n + 1];
    a[0] = 0;
    for (int i = 1; i < n + 1; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    int res = 0;
    for (int i = 0, j = n; i <= j; i++, j--) {
      if (i == j) {
        res += Math.pow(a[i] - a[j + 1], 2);
      }
      else {
        if (i != 0) {
          res += Math.pow(a[i] - a[j + 1], 2);
        }
        res += Math.pow(a[i] - a[j], 2);
      }
    }
    out.println(res);
  }
}
