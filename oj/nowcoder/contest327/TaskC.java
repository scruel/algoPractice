package algsPractice.oj.nowcoder.contest327;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = 1;
    int sum = 1;
    int res = 1;
    int max = 1;
    while (x < n) {
      max = x + max;
      sum += max;
      res++;
      x = sum + 1;
    }
    out.println(res);
  }
}
