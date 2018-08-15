package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa227 {
  int n = 5;
  int x = -1;
  int y = -1;
  char[][] puzzle = new char[n][n];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 1;
    while (true) {
      // 构建初始矩阵
      for (int i = 0; i < n; i++) {
        String s = in.readLine();
        if (s.charAt(0) == 'Z') return;
        if (s.length() == n - 1) s += ' ';
        char[] chars = s.toCharArray();
        puzzle[i] = new char[n];
        for (int j = 0; j < n; j++) {
          puzzle[i][j] = chars[j];
          if (puzzle[i][j] == ' ') {
            x = i;
            y = j;
          }
        }
      }

      boolean f = true;
      while (true) {
        char[] cmd = in.readLine().toCharArray();
        for (int i = 0; i < cmd.length; i++) {
          if (cmd[i] == 'A') {
            if (!move(x - 1, y)) {
              f = false; break;
            }
          }
          else if (cmd[i] == 'B') {
            if (!move(x + 1, y)) {
              f = false; break;
            }
          }
          else if (cmd[i] == 'L') {
            if (!move(x, y - 1)) {
              f = false; break;
            }
          }
          else if (cmd[i] == 'R') {
            if (!move(x, y + 1)) {
              f = false; break;
            }
          }
        }
        if (cmd[cmd.length - 1] == '0') { break;}
      }
      if (kase != 1) out.println();
      out.printf("Puzzle #%d:\n", kase++);
      if (!f) {
        out.println("This puzzle has no final configuration.");
      }
      else {
        print(out);
      }
    }
  }

  private void print(OutputWriter out) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(puzzle[i][j]);
        if (j != n - 1) out.print(" ");
      }
      out.println();
    }
  }

  private boolean move(int tx, int ty) {
    if (tx < 0 || tx >= n || ty < 0 || ty >= n) {
      return false;
    }

    puzzle[x][y] = puzzle[tx][ty];
    puzzle[tx][ty] = ' ';
    x = tx;
    y = ty;
    return true;
  }
}
