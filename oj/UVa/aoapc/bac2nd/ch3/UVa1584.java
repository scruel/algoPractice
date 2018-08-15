package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1584 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      String s = in.readLine();
      int n = s.length();
      int index = 0;
      for (int i = 0; i < n; i++) {
        if (less(s, i, index)) {
          index = i;
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(s.charAt((index + i) % n));
      }
      out.println();
    }
  }

  // 字典序比较
  private boolean less(String s, int p, int q) {
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt((p + i) % n) != s.charAt((q + i) % n)) {
        return s.charAt((p + i) % n) < s.charAt((q + i) % n);
      }
    }
    return false;
  }
}
