package algsPractice.oj.nowcoder.contest327;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class TaskG {
  String a, b;
  boolean res = false;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    a = in.nextString();
    b = in.nextString();
    if (a.equals(b)){
      out.println("YES");
      return;
    }
    dfs(0, 0, 0);
    out.println(res ? "YES" : "NO");
  }

  private void dfs(int i, int j, int cnt) {
    if (cnt > 2) return;
    if (res) return;
    if (i >= a.length()) {
      cnt += b.length() - j;
      if (cnt == 2)
        res = true;
      return;
    }
    if (j >= b.length()) {
      cnt += a.length() - i;
      if (cnt == 2)
        res = true;
      return;
    }
    if (a.charAt(i) == b.charAt(j)) {
      dfs(i + 1, j + 1, cnt);
      return;
    }
    // 1.       将任意一个小写字母替换成另外一个小写字母
    dfs(i + 1, j + 1, cnt + 1);
    // 2.       在任意位置添加一个小写字母
    dfs(i + 1, j, cnt + 1);
    // 3.       删除任意一个字母
    dfs(i, j + 1, cnt + 1);
  }
}
