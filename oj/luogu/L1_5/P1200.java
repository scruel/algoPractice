package algsPractice.oj.luogu.L1_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1200 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String s1 = in.nextString();
    int a = 1;
    int b = 1;
    for (int i = 0; i < s.length(); i++) {
      int v = s.charAt(i) - 'A' + 1;
      a = (a * v) % 47;
    }
    for (int i = 0; i < s1.length(); i++) {
      int v = s1.charAt(i) - 'A' + 1;
      b = (b * v) % 47;
    }
    if (a == b) out.println("GO");
    else out.println("STAY");
  }
}
