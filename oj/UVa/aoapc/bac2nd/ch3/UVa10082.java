package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa10082 {
  String s = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (; ; ) {
      int t = in.read();
      if (t == -1) break;
      char c = (char) t;
      int i = s.indexOf(c);
      if (i != -1) {
        out.print(
            s.charAt((i - 1 + s.length()) % s.length())
        );
      }
      else {
        out.print(c);
      }
    }
  }
}
