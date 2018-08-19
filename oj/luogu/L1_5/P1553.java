package algsPractice.oj.luogu.L1_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1553 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readLine();
    int index = -1;
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        index = i;
      }
    }

    if (index != -1) {
      String s1 = s.substring(0, index);
      String s2 = s.substring(index + 1);
      out.printf("%s%c%s\n", reverse(s1), s.charAt(index), reverse(s2));
      return;
    }
    out.println(reverse(s));
  }

  public String reverse(String s) {
    if (s.equals("")) return "";
    int end = s.length() - 1;
    for (; end >= 0; end--) {
      if (s.charAt(end) != '0') break;
    }
    int start = 0;
    for (; start < s.length(); start++) {
      if (s.charAt(start) != '0') break;
    }
    if (end < 0 || start >= s.length()) return "0";
    s = s.substring(start, end + 1);
    StringBuilder sb = new StringBuilder(s);
    return sb.reverse().toString();
  }
}
