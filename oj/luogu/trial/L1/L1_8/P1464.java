package algsPractice.oj.luogu.trial.L1.L1_8;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1464 {
  long[][][] mem = new long[30][30][30];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    mem[0][0][0] = 1;
    for (; ; ) {
      long a = in.nextLong();
      long b = in.nextLong();
      long c = in.nextLong();
      if (a == -1 && b == -1 && c == -1) break;
      out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
    }
  }

  private long w(long aa, long bb, long cc) {
    if (aa <= 0 || bb <= 0 || cc <= 0) return mem[0][0][0];
    if (aa > 20 || bb > 20 || cc > 20) return w(20, 20, 20);
    int a = (int) aa;
    int b = (int) bb;
    int c = (int) cc;
    if (mem[a][b][c] != 0) return mem[a][b][c];

    if (a < b && b < c) {
      long w = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
      mem[a][b][c] = w;
      return w;
    }
    long w = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    mem[a][b][c] = w;
    return w;
  }
}
