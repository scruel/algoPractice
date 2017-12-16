package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class Task220 {
  char[][] b;
  char player;
  int[] dx = {1, 0, 0, -1, 1, 1, -1, -1};
  int[] dy = {0, 1, -1, 0, 1, -1, 1, -1};
  OutputWriter out;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.out = out;
    int n = in.nextInt();
    while (n-- > 0) {
      b = new char[9][9];
      for (int i = 0; i < 8; i++) {
        b[i] = in.nextLine().toCharArray();
      }
      player = in.nextChar();
      String op;
      while (!(op = in.nextLine()).startsWith("Q")) {
        if (op.charAt(0) == 'L') {
          list();
        }
        else if (op.charAt(0) == 'M') {
          put(op.charAt(1) - 49, op.charAt(2) - 49);
          player = player == 'W' ? 'B' : 'W';
        }
      }
      print();
      if (n > 0) {
        out.writeln();
      }
    }
  }

  private void printCount() {
    int bn = 0;
    int wn = 0;
    for (int i = 0; i < 8; i++) {
      for (int k = 0; k < 8; k++) {
        if (b[i][k] == 'W') {
          wn++;
        }
        else if (b[i][k] == 'B') {
          bn++;
        }
      }
    }
    out.writeln(String.format("Black - %2d White - %2d", bn, wn));
  }

  private void put(int x, int y) {
    if (!check(x, y, true)) {
      player = player == 'W' ? 'B' : 'W';
      check(x, y, true);
    }
    printCount();
  }

  private boolean movable(int x, int y) {
    return x >= 0 && x < 8 && y >= 0 && y < 8;
  }

  private boolean check(int x, int y, boolean fill) {
    if (b[x][y] != '-') {
      return false;
    }
    boolean f = false;
    for (int i = 0; i < 8; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (movable(tx, ty) && b[tx][ty] != '-' && b[tx][ty] != player) {
        boolean pb = false;
        while (true) {
          tx += dx[i];
          ty += dy[i];
          if (!movable(tx, ty)) {
            break;
          }
          if (b[tx][ty] == '-') {
            break;
          }
          if (b[tx][ty] == player) {
            pb = true;
            break;
          }
        }
        if (pb && fill) {
          f = true;
          tx = x;
          ty = y;
          while (true) {
            tx += dx[i];
            ty += dy[i];
            if (b[tx][ty] == player) {
              break;
            }
            b[tx][ty] = player;
          }
          b[x][y] = player;
        }
        else if (pb) {
          return true;
        }
      }
    }
    return f;
  }

  private void list() {
    boolean legal = false;
    int kase = 0;
    for (int i = 0; i < 8; i++) {
      for (int k = 0; k < 8; k++) {
        if (check(i, k, false)) {
          legal = true;
          if (kase++ > 0) {
            out.write(" ");
          }
          out.write(String.format("(%d,%d)", i + 1, k + 1));
        }

      }
    }
    if (legal) {
      out.writeln();
    }
    else {
      player = player == 'W' ? 'B' : 'W';
      out.writeln("No legal move.");
    }

  }

  private void print() {
    for (int i = 0; i < 8; i++) {
      for (int k = 0; k < 8; k++) {
        out.write(b[i][k]);
      }
      out.writeln();
    }
  }
}
