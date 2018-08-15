package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa455 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      in.readLine();
      char[] s = in.readLine().toCharArray();
      int res = 0;
      int n = s.length;
      // 枚举是几的周期串
      for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
          // 检查周期情况是否符合
          if (check(s, i)){
            res = i;
            break;
          }
        }
      }
      out.printf("%d\n", res);
      if (t != 0) out.println();
    }
  }

  private boolean check(char[] s, int i) {
    for (int k = 0; k < s.length - i; k++) {
      if (s[k] != s[k + i]) {
        return false;
      }
    }
    return true;
  }
}
