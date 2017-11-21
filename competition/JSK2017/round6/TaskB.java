package algsPractice.competition.JSK2017.round6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskB {
  int n, k;
  int[] hs;
  int[][] hm;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    hs = new int[n];
    for (int i = 0; i < n; i++)
      hs[i] = in.nextInt();
    int m = in.nextInt();
    hm = new int[m][2];
    for (int i = 0; i < m; i++) {
      hm[i][0] = in.nextInt();
      hm[i][1] = in.nextInt();
    }
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = i + 1; j < m; j++) {
        int r;
        if (hm[i][0] <= 0 || hm[i][0] > n) {
          continue;
        }
        if (hm[j][0] <= 0 || hm[j][0] > n) {
          continue;
        }
        if (hm[i][1] <= 0 || hm[i][1] > hs[hm[i][0] - 1]) {
          continue;
        }
        if (hm[j][1] <= 0 || hm[j][1] > hs[hm[j][0] - 1]) {
          continue;
        }
        int l1 = hm[i][0];
        int l2 = hm[j][0];
        if (l1 > l2) {
          int tmp = l1;
          l1 = l2;
          l2 = tmp;
        }
        if (l1 == l2) {
          r = Math.abs(hm[i][1] - hm[j][1]);
        }
        else {
          int min = hm[i][1] < hm[j][1] ? hm[i][1] : hm[j][1];
          for (int k = l1; k <= l2 - 1; k++) {
            if (hs[k] < min) {
              min = hs[k];
            }
          }
          r = l2 - l1 + Math.abs(hm[i][1] - min + hm[j][1] - min);
        }
        if (r <= k) {
          res++;
        }
      }
    }
    out.writeln(res);
  }
}
