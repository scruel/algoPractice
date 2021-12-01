package algsPractice.oj.luogu.trial.L2.L2_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1042 {
  OutputWriter out;
  StringBuilder r21;
  int cnt, w11, l11, w21, l21;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.out = out;
    r21 = new StringBuilder();
    cnt = w11 = l11 = w21 = l21 = 0;

    for (; ; ) {
      String s = in.readLine();
      for (int i = 0; i < s.length(); i++) {
        cnt++;
        char c = s.charAt(i);
        if (c == 'E') {
          out.printf("%d:%d\n\n", w11, l11);
          out.print(r21);
          out.printf("%d:%d\n", w21, l21);
          return;
        }
        increaseR11(c);
        increaseR21(c);
      }
    }


    // out.printf("%d:%d\n", w, l);
  }

  private void increaseR21(char c) {
    if (c == 'W') w21++;
    else l21++;
    if ((w21 >= 21 || l21 >= 21) && Math.abs(w21 - l21) >= 2) {
      r21.append(String.format("%d:%d\n", w21, l21));
      w21 = l21 = 0;
    }
  }

  private void increaseR11(char c) {
    if (c == 'W') w11++;
    else l11++;
    if ((w11 >= 11 || l11 >= 11) && Math.abs(w11 - l11) >= 2) {
      out.printf("%d:%d\n", w11, l11);
      w11 = l11 = 0;
    }
  }
}
