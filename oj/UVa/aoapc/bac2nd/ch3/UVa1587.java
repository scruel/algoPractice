package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Scruel Tao
 */
public class UVa1587 {
  int n = 6;

  class Board implements Comparable<Board> {
    int x;
    int y;

    public Board(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Board)) { return false;}
      Board board = (Board) obj;
      return this.x == board.x && board.y == this.y;
    }

    @Override
    public int compareTo(Board board) {
      if (this.x < board.x) return -1;
      if (this.x > board.x) return 1;
      return this.y - board.y;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (;;) {
      Board[] boards = new Board[n];
      for (int i = 0; i < n; i++) {
        String s = in.nextString();
        if (s == null) return;
        int w = Integer.parseInt(s);
        int h = in.nextInt();
        if (w > h) {
          int t = w;
          w = h;
          h = t;
        }
        boards[i] = new Board(w, h);
      }

      Arrays.sort(boards);
      // 排序后检查板块是否对应于 ab ab ac ac bc bc
      boolean f = true;
      for (int i = 0; i < n / 2; i++) {
        if (!boards[i * 2].equals(boards[i * 2 + 1])) {
          f = false;
          break;
        }
      }
      if (boards[0].x != boards[2].x
          || boards[0].y != boards[4].x
          || boards[2].y != boards[4].y) {
        f = false;
      }
      out.println(f ? "POSSIBLE" : "IMPOSSIBLE");
    }
  }

}
