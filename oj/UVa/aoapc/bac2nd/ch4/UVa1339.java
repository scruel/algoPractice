package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class UVa1339 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (;;) {
      String t = in.readLine();
      if (t == null) break;
      char[] a = t.toCharArray();
      char[] b = in.readLine().toCharArray();
      char[] c = new char[256];
      char[] d = new char[256];
      int n = a.length;
      for (int i = 0; i < n; i++) {
        c[a[i]]++;
        d[b[i]]++;
      }
      Arrays.sort(c);
      Arrays.sort(d);
      boolean f = true;
      for (int i = 0; i < 256; i++) {
        if (c[i] != d[i]) {
          f = false;
          break;
        }
      }
      if (f) out.println("YES");
      else out.println("NO");
    }
  }
}
