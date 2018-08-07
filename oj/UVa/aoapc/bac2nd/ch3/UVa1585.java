package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1585 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      char[] s = in.readLine().toCharArray();
      int sum = 0;
      int res = 0;
      for (int i = 0; i < s.length; i++) {
        if (s[i] == 'O') sum++;
        else sum = 0;
        res += sum;
      }
      out.printf("%d\n", res);
    }
  }
}
