package algsPractice.oj_t.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #tree #binary-tree
 */
public class Task839 {
  InputReader in;

  boolean isB(int[] W) {
    int w1, d1, w2, d2;
    w1 = in.nextInt();
    d1 = in.nextInt();
    w2 = in.nextInt();
    d2 = in.nextInt();
    boolean b1, b2;
    b1 = b2 = true;
    if (w1 == 0) {
      int[] tmp = new int[1];
      b1 = isB(tmp);
      w1 = tmp[0];
    }

    if (w2 == 0) {
      int[] tmp = new int[1];
      b2 = isB(tmp);
      w2 = tmp[0];
    }
    W[0] = w1 + w2;
    return b1 && b2 && d1 * w1 == d2 * w2;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    int T = in.nextInt();
    while (T-- > 0) {
      if (isB(new int[1])) {
        out.writeln("YES");
      }
      else {
        out.writeln("NO");
      }
      if (T > 0) {
        out.writeln();
      }
    }
  }
}
