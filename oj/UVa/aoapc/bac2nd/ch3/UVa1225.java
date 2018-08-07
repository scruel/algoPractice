package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;
import static java.lang.Math.*;

/**
 * @author Scruel Tao
 */
public class UVa1225 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      int n = in.nextInt();
      int[] arr = new int[10];
      for (int i = 1; i <= n; i++) {
        int nn = i;
        while (nn != 0) {
          arr[nn % 10]++;
          nn /= 10;
        }
      }
      for (int i = 0; i < 10; i++) {
        if (i != 0) out.print(' ');
        out.print(arr[i]);
      }
      out.println();
    }
  }
}
