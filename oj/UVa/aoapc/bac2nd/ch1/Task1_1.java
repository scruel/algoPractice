package algsPractice.oj.UVa.aoapc.bac2nd.ch1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class Task1_1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    double r = in.nextDouble();
    double h = in.nextDouble();

    // Math.PI = acos(-1.0)
    double c = 2 * Math.PI * r;
    double ss = c * h;
    double bs = Math.PI * r * r * 2;

    double res = ss + bs;
    out.printf("Area = %.3f\n", res);
  }
}
