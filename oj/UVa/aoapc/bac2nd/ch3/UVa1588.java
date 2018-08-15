package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * 旧有写法区分上木板在下木板的左右中三种情况 分开取最小 目前的写法更加优雅.
 * @author Scruel Tao
 */
public class UVa1588 {
  String m;
  String d;
  int mn;
  int dn;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (;;) {
      m = in.readLine();
      if (m == null) break;
      d = in.readLine();
      mn = m.length();
      dn = d.length();
      int all = mn + dn;
      int min = all;
      // 不断左移上木板尝试重合两块木板
      // i 表示上木板的相对位置
      // 下木板的相对位置永远在 0 处
      int i = mn - 1;
      while (i > -dn) {
        int cv = check(i);
        if (cv != -1) {
          int v = all - cv;
          min = v < min ? v : min;
        }
        i--;
      }
      out.println(min);
    }
  }

  private int check(int index) {
    int ans = 0;
    int i = index > 0 ? index : 0;
    int j = index > 0 ? 0 : -index;
    while (i < mn && j < dn) {
      if (m.charAt(i) == '2' && d.charAt(j) == '2') {
        return -1;
      }
      ans++;
      i++;
      j++;
    }
    return ans;
  }
}
