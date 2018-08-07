package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * http://blog.csdn.net/crazysillynerd/article/details/43339157
 * #binary #math big --> log
 * 大数2^n转lg2^n
 *
 * @author Scruel Tao
 */
public class UVa11809 {
  double EPSINON = 1e-4;
  double[][] R = new double[20][40];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int i = 0; i <= 9; i++) {
      for (int j = 1; j <= 30; j++) {
        // 等比数列求和
        double m = 1.0 - Math.pow(2, -i - 1);
        double e = Math.pow(2, j) - 1;
        double r = Math.log10(m) + e * Math.log10(2);
        R[i][j] = r;
      }
    }
    for (; ; ) {
      String s = in.nextLine();
      if (s.equals("0e0")) {
        break;
      }
      double A = Double.parseDouble(s.split("e")[0]);
      int B = Integer.parseInt(s.split("e")[1]);
      double r = Math.log10(A) + B;

      boolean f = false;
      for (int i = 0; i <= 9; i++) {
        for (int j = 1; j <= 30; j++) {
          if (Math.abs(R[i][j] - r) < EPSINON) {
            out.printf("%d %d\n", i, j);
            f = true;
            break;
          }
        }
        if (f) break;
      }
    }
  }
}
