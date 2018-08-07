package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa340 {
  int n;
  int[] a;
  int[] b;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = 1;
    while ((n = in.nextInt()) != 0) {
      a = new int[n];
      b = new int[n];

      out.printf("Game %d:\n", k++);
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
      }
      for (; ; ) {
        int A = 0;
        int B = 0;
        for (int i = 0; i < n; i++) {
          b[i] = in.nextInt();
          if (a[i] == b[i]) A++;
        }
        if (b[0] == 0) break;
        for (int d = 1; d <= 9; d++) {
          int c1 = 0, c2 = 0; //统计数字d在答案序列和猜测序列中各出现多少次
          for (int i = 0; i < n; i++) {
            if (a[i] == d) c1++;
            if (b[i] == d) c2++;
          }
          if (c1 < c2) B += c1;
          else B += c2;
        }
        out.printf("%4s(%d,%d)\n", "", A, B - A);
      }
    }
  }
}
