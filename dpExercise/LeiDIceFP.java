package algsPractice.dpExercise;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/28.  
 * Github : https://github.com/scruel
 */
public class LeiDIceFP {
  final int MOD = 1000000007;
  Scanner in = new Scanner(System.in);
  PrintStream out = System.out;

  public static void main(String[] args) {
    new LeiDIceFP().main();
  }

  int[][] multiply(int[][] a, int[][] b) {
    int c[][] = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < b[0].length; ++j) {
        for (int k = 0; k < a[0].length; ++k) {
          c[i][j] = (int) ((c[i][j] + (long) a[i][k] * b[k][j]) % MOD);
        }
      }
    }
    return c;
  }

  int[][] pow(int[][] a, int k) {
    int[][] res = new int[a.length][a.length], cur = a;
    for (int i = 0; i < a.length; ++i) {
      res[i][i] = 1;
    }
    while (k != 0) {
      if ((k & 1) == 1) {
        res = multiply(res, cur);
      }
      cur = multiply(cur, cur);
      k /= 2;
    }
    return res;
  }

  int conv(int a) {
    return a < 3 ? a + 3 : a - 3;
  }

  void main() {
    int n = in.nextInt(), m = in.nextInt();
    int[][] x = new int[1][6], mat = new int[6][6], y = new int[6][1];
    for (int i = 0; i < 6; ++i) {
      x[0][i] = 1;
      y[i][0] = 4;
      for (int j = 0; j < 6; ++j) {
        mat[i][j] = 4;
      }
    }
    for (int i = 0; i < m; ++i) {
      int a = in.nextInt() - 1, b = in.nextInt() - 1;
      mat[a][conv(b)] = mat[b][conv(a)] = 0;
    }
    out.println(multiply(multiply(x, pow(mat, n - 1)), y)[0][0]);
  }
}