package algsPractice.oj.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task37626 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 0;
    while (T-- > 0) {
      String s = in.nextString();
      int n = in.nextInt();
      char ch = s.charAt(0);
      if (ch == 'b') {
        dx = -dx;
        dy = -dy;
      }
      else if (ch == 'l') {
        if (dx == 1) {
          dx = 0;
          dy = 1;
        }
        else if (dx == -1) {
          dx = 0;
          dy = -1;
        }
        else {
          if (dy == -1) {
            dx = 1;
            dy = 0;
          }
          else {
            dx = -1;
            dy = 0;
          }
        }

      }
      else if (ch == 'r') {
        if (dx == 1) {
          dx = 0;
          dy = -1;
        }
        else if (dx == -1) {
          dx = 0;
          dy = 1;
        }
        else {
          if (dy == -1) {
            dx = -1;
            dy = 0;
          }
          else {
            dx = 1;
            dy = 0;
          }
        }

      }
      x += dx * n;
      y += dy * n;
    }
    out.writeln(x + " " + y);

  }
}
