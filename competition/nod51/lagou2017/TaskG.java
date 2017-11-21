package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #greedy #priority
 */
public class TaskG {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;
  int MAXN = 50000;
  int n, m;
  int[] tbs = new int[MAXN];
  Pair[] ps = new Pair[MAXN];
  PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < n; i++)
      tbs[i] = in.nextInt();
    for (int i = 0; i < m; i++) {
      Pair p = new Pair(in.nextInt(), in.nextInt());
      ps[i] = p;
    }
    Arrays.sort(tbs, 0, n);
    Arrays.sort(ps, 0, m, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return o1.d - o2.d;
      }
    });
    int res = 0;
    int i, j;
    for (i = n - 1, j = m - 1; i >= 0; i--) {
      for (; j >= 0; j--) {
        if (ps[j].d >= tbs[i]) {
          pq.add(ps[j]);
        }
        else {
          break;
        }
      }
      if (!pq.isEmpty()) {
        res += pq.poll().c;
      }
      else {
        out.writeln("No Solution\n");
        return;
      }
    }
    out.writeln(res);
  }

  static class Pair implements Comparable<Pair> {
    int d, c;

    public Pair(int d, int c) {
      this.d = d;
      this.c = c;
    }

    @Override
    public int compareTo(Pair o) {
      if (this.c > o.c) {
        return 1;
      }
      else if (this.c < o.c) {
        return -1;
      }
      else {
        if (this.c > o.c) {
          return -1;
        }
        else if (this.c < o.c) {
          return 1;
        }
        else {
          return 0;
        }
      }
    }
  }
}
