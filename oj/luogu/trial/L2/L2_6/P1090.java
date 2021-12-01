package algsPractice.oj.luogu.trial.L2.L2_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class P1090 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      q.add(in.nextInt());
    }

    int sum = 0;
    while (q.size() > 1) {
      int a = q.poll();
      int b = q.poll();
      int v = a + b;
      q.add(v);
      sum += v;
    }
    // sum += q.poll();
    out.println(sum);
  }
}
