package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] nums = new long[n];
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextLong();
    }
    long res = 0;
    long en = 0;
    for (int i = 0; i < n; i++) {
      en += nums[i];
      if (en < 0) {
        res += (-en);
        en = 0;
      }
    }
    out.writeln(res);
  }
}
