package algsPractice.competition.JSK2017.round5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskA {
  PriorityQueue<Integer> pq;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    pq = new PriorityQueue<Integer>();
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      pq.add(-in.nextInt());
    }
    int sum = 0;
    int res = 0;
    boolean isF = false;
    while (!pq.isEmpty() && sum < n) {
      int num = -pq.poll();
      if (num == 0) {
        continue;
      }
      if (isF) {
        num--;
      }
      else {
        isF = true;
      }
      sum += num;
      res++;
    }
    if (n == 1) {
      out.writeln(0);
    }
    else if (sum >= n) {
      out.writeln(res);
    }
    else {
      out.writeln("Impossible");
    }
  }
}
