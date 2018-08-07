package algsPractice.oj.UVa.aoapc.bac2nd.ch1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class Task1_4 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int x = (4 * n - m) / 2;
    int y = n - x;
    if (m % 2 == 1 || x < 0 || y < 0) {
      out.println("No answer");
      return;
    }
    out.printf("%d %d\n", x, y);
  }
}
