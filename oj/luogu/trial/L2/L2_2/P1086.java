package algsPractice.oj.luogu.trial.L2.L2_2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class P1086 {
  class Point implements Comparable<Point> {
    int x, y, v;

    @Override
    public int compareTo(Point o) {
      return o.v - v;
    }

    public Point(int x, int y, int v) {
      this.x = x;
      this.y = y;
      this.v = v;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int n = in.nextInt();
    int k = in.nextInt();
    PriorityQueue<Point> q = new PriorityQueue<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int v = in.nextInt();
        if (v != 0)
          q.add(new Point(i, j, v));
      }
    }
    int ans = 0;

    if (q.isEmpty()) {
      out.println(0);
      return;
    }
    k -= 2; // 跳到方格和跳回路边的消耗
    Point p = q.peek();
    int x = 0;
    int y = p.y;
    while (!q.isEmpty()) {
      p = q.poll();
      k -= Math.abs(p.x - x);
      k -= Math.abs(p.y - y);
      k--;
      if (k - p.x < 0) break;
      ans += p.v;
      x = p.x;
      y = p.y;
    }
    out.println(ans);
  }
}
