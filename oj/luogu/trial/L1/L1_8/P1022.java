package algsPractice.oj.luogu.trial.L1.L1_8;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1022 {
  int x = 0;
  int sum = 0;
  char param;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = 0;
    boolean right = false; // 标识在等号的左边或者右边
    boolean f = false; // 负数标记
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int v = c - '0';
        n *= 10;
        if (f ^ right) n -= v;
        else n += v;
      }
      else {
        if (Character.isAlphabetic(c)) {
          if (n == 0) x++;
          x += n;
          param = c;
        }
        else {
          sum += n;
        }
        if (c == '=') right = true;
        n = 0;
        f = c == '-';
      }
    }
    sum += n;
    double res = (double) sum / -x;
    out.printf("%c=%.3f\n", param, sum == 0 ? Math.abs(res) : res);
  }
}
