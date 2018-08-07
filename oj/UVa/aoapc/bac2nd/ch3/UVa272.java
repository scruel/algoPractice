package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa272 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    boolean f = true;
    int c;
    while ((c = in.read()) != -1) {
      if (c == '\"') {
        if (f) out.print("``");
        else out.print("''");
        f = !f;
      }
      else {
        out.print((char)c);
      }
    }
  }
}
