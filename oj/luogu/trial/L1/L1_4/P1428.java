package algsPractice.oj.luogu.trial.L1.L1_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1428 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      int cnt = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i]) {
          cnt++;
        }
      }
      if (i != 0) out.print(" ");
      out.print(cnt);
    }
  }
}
