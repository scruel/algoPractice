package algsPractice.oj.luogu.trial.L1.L1_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class P1478 {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = in.nextInt();
    int h = in.nextInt() + in.nextInt();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a <= h){
        queue.add(b);
      }
    }
    int ans = 0;
    while (!queue.isEmpty()) {
      s -= queue.poll();
      if (s < 0) break;
      ans++;
    }
    out.println(ans);
  }
}
