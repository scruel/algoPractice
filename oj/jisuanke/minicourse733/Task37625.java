package algsPractice.oj.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * #easy
 */
public class Task37625 {
  boolean check(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    StringBuilder res = new StringBuilder();
    int cnt = 0;
    while (!check(s)) {
      res.append(s);
      res.append("--->");
      cnt++;
      int n = Integer.parseInt(s);
      StringBuilder sb = new StringBuilder(s);
      int rn = Integer.parseInt(sb.reverse().toString());
      s = String.valueOf(n + rn);

    }
    res.append(s);
    out.writeln(cnt);
    out.writeln(res.toString());
  }
}
