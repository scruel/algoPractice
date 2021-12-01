package algsPractice.oj.luogu.trial.L1.L1_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class P2141 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    Arrays.sort(arr);
    int ans = 0;
    for (int i = 2; i < n; i++) {
      if (check(arr, i - 1, arr[i])) ans++;
    }
    out.println(ans);
  }

  private boolean check(int[] arr, int j, int k) {
    int i = 0;
    while (i < j) {
      if (arr[i] + arr[j] == k) { return true;}
      if (arr[i] + arr[j] > k) j--;
      else i++;
    }
    return false;
  }
}
