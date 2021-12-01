package algsPractice.oj.luogu.trial.L1.L1_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1308 {
  String w, s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    w = in.nextString().toLowerCase();
    s = in.readLine().toLowerCase();
    int start = 0;
    int first = -1;
    int cnt = 0;
    for (; ; ) {
      start = s.indexOf(w, start);
      if (start == -1) break;
      if (check(start)) {
        if (first == -1) first = start;
        cnt++;
      }
      start++;
    }
    if (cnt > 0) out.print(cnt + " ");
    out.println(first);
  }

  public boolean check(int index) {
    int i = index - 1;
    int j = index + w.length();
    if (i >= 0 && s.charAt(i) != ' ') {
      return false;
    }
    if (j < s.length() && s.charAt(j) != ' ') {
      return false;
    }
    return true;
  }
}
