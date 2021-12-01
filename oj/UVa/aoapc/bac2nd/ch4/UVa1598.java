package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1598 {
  int t, bx, by;
  char[] cmd;
  int[][] cmdPos;
  int maxx = 10;
  int maxy = 9;
  int[] dx = {0, 1, 0, -1};
  int[] dy = {1, 0, -1, 0};
  int[] hdx = {1, -1, 2, 2, 1, -1, -2, -2};
  int[] hdy = {2, 2, 1, -1, -2, -2, 1, -1};
  boolean[][] chessboard = new boolean[15][15];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (; ; ) {
      t = in.nextInt();
      if (t == 0) break;
      cmd = new char[t];
      cmdPos = new int[t][2];
      chessboard = new boolean[15][15];
      bx = in.nextInt();
      by = in.nextInt();
      int rx = -1;
      int ry = -1;
      for (int i = 0; i < t; i++) {
        cmd[i] = (char) in.read();
        int x = in.nextInt();
        int y = in.nextInt();
        if (cmd[i] == 'G') {
          rx = x;
          ry = y;
        }
        cmdPos[i][0] = x;
        cmdPos[i][1] = y;
        chessboard[x][y] = true;
      }
      if (ry == by) {
        if (0 == countX(rx, bx, by)) {
          out.println("NO");
          continue;
        }
      }
      boolean checkmate = false;
      for (int i = 0; i < 4; i++) {
        int tx = bx + dx[i];
        int ty = by + dy[i];
        if (ty < 4 || ty > 6 || tx < 1 || tx > 3) continue;
        // 检查所有方案, 一旦死亡就结束
        checkmate = false;
        for (int j = 0; j < t; j++) {
          char c = cmd[j];
          int cx = cmdPos[j][0];
          int cy = cmdPos[j][1];
          // 被将军吃掉了
          if (cx == tx && cy == ty) continue;
          // 是否将军
          if (c == 'G') checkmate = G(tx, ty, cx, cy);
          else if (c == 'R') checkmate = R(tx, ty, cx, cy);
          else if (c == 'C') checkmate = C(tx, ty, cx, cy);
          else if (c == 'H') checkmate = H(tx, ty, cx, cy);
          // 被将死 这个方向走不了
          if (checkmate) break;
        }
        if (!checkmate) break;
      }
      if (checkmate) {
        out.println("YES");
      }
      else {
        out.println("NO");
      }
    }
  }

  private int countX(int x1, int x2, int y) {
    if (x1 > x2) {
      int t = x1;
      x1 = x2;
      x2 = t;
    }
    int cnt = 0;
    for (int i = x1 + 1; i < x2; i++) {
      if (chessboard[i][y]) cnt++;
    }
    return cnt;
  }

  private int countY(int x, int y1, int y2) {
    if (y1 > y2) {
      int t = y1;
      y1 = y2;
      y2 = t;
    }
    int cnt = 0;
    for (int i = y1 + 1; i < y2; i++) {
      if (chessboard[x][i]) cnt++;
    }
    return cnt;
  }

  private boolean G(int tx, int ty, int cx, int cy) {
    if (ty == cy) {
      return 0 == countX(tx, cx, ty);
    }
    return false;
  }

  private boolean R(int tx, int ty, int cx, int cy) {
    if (ty == cy) {
      return 0 == countX(tx, cx, ty);
    }
    if (tx == cx) {
      return 0 == countY(ty, cy, tx);
    }
    return false;
  }

  private boolean C(int tx, int ty, int cx, int cy) {
    if (ty == cy) {
      return 1 == countX(tx, cx, ty);
    }
    if (tx == cx) {
      return 1 == countY(ty, cy, tx);
    }
    return false;
  }

  private boolean H(int tx, int ty, int cx, int cy) {
    for (int i = 0; i < 4; i++) {
      int bx = cx + dx[i];
      int by = cy + dy[i];
      if (out(bx, by)) continue;
      // 蹩马脚
      if (chessboard[bx][by]) continue;
      for (int j = i * 2; j <= i * 2 + 1; j++) {
        int hx = cx + hdx[j];
        int hy = cy + hdy[j];
        if (out(hx, hy)) continue;
        if (hx == tx && hy == ty) return true;
      }
    }
    return false;
  }

  public boolean out(int x, int y) {
    if (x <= 0 || x > maxx) return true;
    if (y <= 0 || y > maxy) return true;
    return false;
  }
}
