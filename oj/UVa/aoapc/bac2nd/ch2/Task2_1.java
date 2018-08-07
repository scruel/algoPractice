package algsPractice.oj.UVa.aoapc.bac2nd.ch2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class Task2_1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int a = 1; a <= 9; a++) {
      for (int b = 0; b <= 9; b++) {
        int n = a * 1100 + b * 11;
        int m = (int) Math.floor(Math.sqrt(n) + 0.5);
        if (m * m == n) {
            out.println(n);
        }
        // 为了减小误差的影响，一般改成四舍五入，即floor（x＋0.5）(2)。
        // if (Math.sqrt(aabb) == (int) (Math.sqrt(aabb))) {
        //   out.println(aabb);
        // }
      }
    }
  }
}
