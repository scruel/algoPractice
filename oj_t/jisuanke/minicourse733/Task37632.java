package algsPractice.oj_t.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #binary #enum
 */
public class Task37632 {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[][] nums = new int[n][k];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      for (int j = 0; j < x; j++)
        nums[i][j] = in.nextInt();
    }
    int res = 0;
    for (int i = 0; i < (1 << k); i++) {
      int cnt = 0;
      boolean[] is = new boolean[k];
      for (int j = 0; j < k; j++) {
        if (1 == (1 & (i >> j))) {
          is[j] = true;
          cnt++;
        }
      }
      int max = 0;
      if (cnt <= m) {
        for (int p = 0; p < n; p++) {
          boolean flag = true;
          for (int j = 0; j < k; j++) {
            if (nums[p][j] == 0) {
              break;
            }
            if (!is[nums[p][j] - 1]) {
              flag = false;
            }
          }
          if (flag) {
            max++;
          }

        }
      }
      if (max > res) {
        res = max;
      }

    }
    out.writeln(res);
  }
}
