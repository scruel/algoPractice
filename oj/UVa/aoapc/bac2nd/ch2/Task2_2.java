package algsPractice.oj.UVa.aoapc.bac2nd.ch2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;
import static java.lang.Math.*;

/**
 * @author Scruel Tao
 */
public class Task2_2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    int cnt = 0;
    while (n != 1) {
      if (n % 2 != 0) {
        n = n * 3 + 1;
      }
      else {
        n = n / 2;
      }
      cnt++;
    }
    out.println(cnt);
  }
}
