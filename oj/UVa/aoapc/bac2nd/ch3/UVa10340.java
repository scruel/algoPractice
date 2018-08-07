package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa10340 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (!in.isExhausted()) {
      String s = in.nextString();
      String t = in.nextString();

      int i = 0;
      int j = 0;
      while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) {
          i++;
          j++;
        }
        else {
          j++;
        }
      }
      if (i == s.length()) {
        out.println("Yes");
      }
      else {
        out.println("No");
      }
    }
  }
}
