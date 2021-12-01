package algsPractice.oj.luogu.trial.L2.L2_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class P1012 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = in.nextString();
    }

    Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    for (int i = 0; i < n; i++) {
      out.print(s[i]);
    }
  }
}
