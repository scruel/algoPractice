package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa232 {
  int r;
  int c;
  int cnt;
  char[][] arr;
  int[][] mk;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 1;
    while (true) {
      r = in.nextInt();
      if (r == 0) break;
      c = in.nextInt();
      arr = new char[r][c];
      mk = new int[r][c];
      cnt = 1;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          arr[i][j] = in.nextChar();
          check(i, j);
        }
      }
      if (kase != 1) out.println();
      out.printf("puzzle #%d:\nAcross\n", kase++);
      // find all across
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if ((j == 0 || arr[i][j - 1] == '*') && mk[i][j] != 0) {
            out.printf("%3d.", mk[i][j]);
            int k = j;
            while (k < c && arr[i][k] != '*') {
              out.print(arr[i][k]);
              k++;
            }
            out.println();
          }
        }
      }

      out.printf("Down\n");
      // find all down
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if ((i == 0 || arr[i - 1][j] == '*') && mk[i][j] != 0) {
            out.printf("%3d.", mk[i][j]);
            int k = i;
            while (k < r && arr[k][j] != '*') {
              out.print(arr[k][j]);
              k++;
            }
            out.println();
          }
        }
      }
    }
  }

  private void check(int i, int j) {
    if (arr[i][j] == '*') return;
    if (i == 0 || j == 0 || arr[i - 1][j] == '*' || arr[i][j - 1] == '*') {
      mk[i][j] = cnt++;
    }
  }
}
