package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa272 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    boolean f = true;
    for (;;) {
      int t = in.read();
      if (t == -1) break;
      char c = (char) t;
      if (c == '\"') {
        if (f) out.print("``");
        else out.print("''");
        f = !f;
      }
      else {
        out.print(c);
      }
    }
  }
}
