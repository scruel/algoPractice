package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task1589 {
  char[][] b;
  int[][] r;
  int n;
  int[] dx = {1, 0, 0, -1};
  int[] dy = {0, 1, -1, 0};
  int[] hdx = {2, 2, -1, 1, -1, 1, -2, -2};
  int[] hdy = {-1, 1, 2, 2, -2, -2, 1, -1};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while ((n = in.nextInt()) != 0) {
      b = new char[15][15];
      r = new int[n][2];
      int bx = in.nextInt();
      int by = in.nextInt();
      int rx = -1, ry = -1;
      //            b[bx][by] = 'B';
      if (bx == 0 || by == 0) {
        break;
      }
      for (int i = 0; i < n; i++) {
        char ch = in.nextChar();
        int cx = in.nextInt();
        int cy = in.nextInt();
        b[cx][cy] = ch;
        r[i][0] = cx;
        r[i][1] = cy;
        if (ch == 'G') {
          rx = cx;
          ry = cy;
        }
      }

      if (rangeCount(bx, by, rx, ry) == 0) {
        out.writeln("NO");
        continue;
      }
      //check check
      boolean reaWin = true;
      for (int i = 0; i < 4; i++) {
        int tx = bx + dx[i];
        int ty = by + dy[i];
        if (gmovable(tx, ty)) {
          if (!checked(tx, ty)) {
            reaWin = false;
            break;
          }
        }
      }
      out.writeln(reaWin ? "YES" : "NO");
    }
  }

  private boolean checked(int bx, int by) {
    for (int i = 0; i < n; i++) {
      int cx = r[i][0];
      int cy = r[i][1];
      char ch = b[cx][cy];
      if (cx == bx && cy == by) {
        continue;
      }
      if (ch == 'G' && G(bx, by, cx, cy)) {
        return true;
      }
      else if (ch == 'R' && R(bx, by, cx, cy)) {
        return true;
      }
      else if (ch == 'H' && H(bx, by, cx, cy)) {
        return true;
      }
      else if (ch == 'C' && C(bx, by, cx, cy)) {
        return true;
      }
    }
    return false;
  }

  private boolean C(int bx, int by, int cx, int cy) {
    return rangeCount(bx, by, cx, cy) == 1;
  }

  private boolean H(int bx, int by, int cx, int cy) {
    for (int j = 0; j < 4; j++) {
      int tx = dx[j] + cx;
      int ty = dy[j] + cy;
      for (int k = j * 2; k <= j * 2 + 1; k++) {
        int hx = hdx[k] + cx;
        int hy = hdy[k] + cy;
        if (hx == bx && hy == by && b[tx][ty] == '\u0000') {
          return true;
        }
      }
    }
    return false;
  }

  private boolean G(int bx, int by, int cx, int cy) {
    return rangeCount(bx, by, cx, cy) == 0;
  }

  private boolean R(int bx, int by, int cx, int cy) {
    return rangeCount(bx, by, cx, cy) == 0;
  }

  private boolean gmovable(int x, int y) {
    return x >= 1 && x <= 3 && y >= 4 && y <= 6;
  }


  private int rangeCount(int x1, int y1, int x2, int y2) {
    int tmp;
    int count = 0;
    if (x1 == x2) {
      if (y2 < y1) {
        tmp = y1;
        y1 = y2;
        y2 = tmp;
      }
      for (int k = y1 + 1; k < y2; k++) {
        if (b[x1][k] != '\u0000') {
          count++;
        }
      }
    }
    else if (y1 == y2) {
      if (x2 < x1) {
        tmp = x1;
        x1 = x2;
        x2 = tmp;
      }
      for (int i = x1 + 1; i < x2; i++) {
        if (b[i][y1] != '\u0000') {
          count++;
        }
      }
    }
    else {
      return -1;
    }
    return count;
  }
}
