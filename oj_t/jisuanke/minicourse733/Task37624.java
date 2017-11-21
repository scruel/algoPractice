package algsPractice.oj_t.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37624 {
  char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int r = in.nextInt();
    boolean neg = n < 0;
    n = Math.abs(n);
    if (n == 0) {
      out.writeln(0);
    }

    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      char ch;
      if (n % r >= 10) {
        ch = chars[(n % r) - 10];
      }
      else {
        ch = (char) ((n % r) + 48);
      }
      sb.insert(0, ch);
      n /= r;
    }
    if (neg) {
      out.writeln("-" + sb.toString());
    }
    else {
      out.writeln(sb.toString());
    }
  }
}
