package algsPractice.competition.nowCoder;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskA {
  int n;
  int[] nums;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = (in.nextInt());
    Arrays.sort(nums);
    int ans = 0;
    for (int i = 2; i < n; i++)
      ans = Math.max(ans, nums[i] - nums[i - 2]);
    out.writeln(ans);
  }
}
