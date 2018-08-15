package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa133 {
  int N;
  int[] arr;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (; ; ) {
      N = in.nextInt();
      if (N == 0) break;
      int k = in.nextInt();
      int m = in.nextInt();
      arr = new int[N + 5];
      for (int i = 1; i <= N; i++) {
        arr[i] = i;
      }
      int left = N;
      int ap = N;
      int bp = 1;
      while (left > 0) {
        ap = go(ap, 1, k);
        bp = go(bp, -1, m);
        out.printf("%3d", ap);
        left--;
        if (ap != bp) {
          out.printf("%3d", bp);
          left--;
        }
        arr[ap] = arr[bp] = 0;
        if (left > 0) out.print(",");
      }
      out.println();
    }
  }

  private int go(int p, int d, int t) {
    while (t-- != 0) {
      do {
        p = (p + d + N - 1) % N + 1;
      } while (arr[p] == 0);
    }
    return p;
  }
}
