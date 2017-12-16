package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskD {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = in.nextInt();
    Arrays.sort(nums);
    int cnt = 0;
    int i = 0;
    int j = n - 1;
    while (i <= j) {
      int mm = nums[i] + nums[j];
      if (mm > m) {
        j--;
      }
      else {
        i++;
        j--;
      }
      cnt++;
    }
    out.writeln(cnt);
  }
}
