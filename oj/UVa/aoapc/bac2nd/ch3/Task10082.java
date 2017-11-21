package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task10082 {
  String s = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int h;
    while ((h = in.read()) != -1) {
      char ch = (char) h;
      if (ch == '\n') {
        out.write(('\n'));
      }
      else if (ch == ' ') {
        out.write(' ');
      }
      else {
        out.write(s.charAt(s.indexOf(ch) - 1));
      }
    }
  }
}
