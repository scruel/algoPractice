package algsPractice.oj.luogu.trial.L2.L2_1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1003 {
  class Cmd {
    int x, y, lx, ly;

    public Cmd(int x, int y, int lx, int ly) {
      this.x = x;
      this.y = y;
      this.lx = lx;
      this.ly = ly;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Cmd[] cmds = new Cmd[n];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      int lx = in.nextInt();
      int ly = in.nextInt();
      cmds[i] = new Cmd(x, y, lx, ly);

    }
    int qx = in.nextInt();
    int qy = in.nextInt();
    int res = -1;
    for (int i = 0; i < n; i++) {
      int x = cmds[i].x;
      int y = cmds[i].y;
      int lx = cmds[i].lx;
      int ly = cmds[i].ly;
      if (x <= qx && qx <= lx + x && y <= qy && qy <= y + ly) {
        res = i + 1;
      }
    }
    out.println(res);
  }
}
