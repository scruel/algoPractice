package algsPractice.oj.luogu.trial.L1.L1_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1567 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] arr = new int[n];
    int max = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      if (i != 0 && arr[i - 1] < arr[i]) {
        ans++;
        max = max > ans ? max : ans;
      }else {
        ans = 0;
      }
    }
    out.println(max + 1);
  }
}
