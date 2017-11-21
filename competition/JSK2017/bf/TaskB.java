package algsPractice.competition.JSK2017.bf;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskB {
  static final double EPS = 1e-10;
  int MAXM = 250 + 10;
  int MAXN = 80000 + 10;
  int n, m;
  int[][] piexls = new int[MAXM][MAXM];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    in.nextInt();
    int kase = 0;
    while (++kase <= n) {
      int xa = in.nextInt();
      int ya = in.nextInt();
      int xb = in.nextInt();
      int yb = in.nextInt();
      piexls[xa][ya] = kase;
      piexls[xb][yb] = kase;
      if (xa == xb) {
        for (int i = ya + 1; i < yb; i++) {
          piexls[xa][i] = kase;
        }
      }
      else if (ya == yb) {
        for (int i = xa + 1; i < xb; i++) {
          piexls[i][ya] = kase;
        }
      }
      else {
        if (xa > xb) {
          int xt = xa;
          xa = xb;
          xb = xt;
          int yt = ya;
          ya = yb;
          yb = yt;
        }
        for (int i = xa + 1; i < xb; i++) {
          double ty = ya + (double) (yb - ya) * (double) (i - xa) / (double) (xb - xa);
          if (Math.abs(Math.floor(ty) - ty) < EPS) {
            piexls[i][(int) ty] = kase;
          }
        }
        //y = y1+(y2-y1)(x-x1)/(x2-x1)
        //x = x1+(x2-x1)(y-y1)/(y2-y1)
      }

    }
    m = in.nextInt();
    while (m-- > 0) {
      out.write(piexls[in.nextInt()][in.nextInt()] + "\n");
    }
  }
}
