package algsPractice.oj.openjudge;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by scruel on 2017/12/07.
 * Github : https://github.com/scruel
 * http://cxsjsxmooc.openjudge.cn/2017t2wintersum/017/
 */
public class Task6047 {
  private int min = Integer.MAX_VALUE;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int w, h, m;
    while (true) {
      w = in.nextInt();
      h = in.nextInt();
      m = in.nextInt();
      min = Integer.MAX_VALUE;
      if (w == 0 && w == h && w == m) {
        break;
      }
      f(w, h, m, -1);
      out.writeln(min);
    }
  }

  private void f(int w, int h, int m, int max) {
    // System.out.printf("%d %d %d %d\n", w, h, m, max);
    if (m == 1) {
      int a = w * h;
      max = a > max ? a : max;
      min = max < min ? max : min;
      return;
    }
    for (int i = 1; i <= w / 2; i++) {
      int a = i * h;
      max = a > max ? a : max;
      f(w - i, h, m - 1, max);
    }
    for (int i = 1; i <= h / 2; i++) {
      int a = w * i;
      max = a > max ? a : max;
      f(w, h - i, m - 1, max);
    }
  }
}
