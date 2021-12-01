package algsPractice.oj.luogu.trial.L2.L2_1;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;

/**
 * @author Scruel Tao
 */
public class P1540 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int n = in.nextInt();
    LinkedList<Integer> list = new LinkedList<>();
    int res = 0;
    for (int i = 0; i < n; i++) {
      int v = in.nextInt();
      if (!list.contains(v)) {
        if (list.size() >= m) list.poll();
        list.add(v);
        res++;
      }
    }
    out.println(res);
  }
}
