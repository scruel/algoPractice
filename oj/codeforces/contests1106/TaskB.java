package algsPractice.oj.codeforces.contests1106;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.*;

/**
 * @author Scruel Tao
 */
public class TaskB {
  int n, m;
  int[] a;
  Map<Integer, P> id2P = new HashMap<>();
  List<P> pq = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      P p = new P(i, a[i], in.nextInt());
      pq.add(p);
      id2P.put(i, p);
    }
    Collections.sort(pq);
    int idx = 0;
    while (m-- > 0) {
      int id = in.nextInt();
      int d = in.nextInt();
      if (idx >= n) {
        out.println(0);
        continue;
      }
      long cost = 0;
      // need cost t-th
      P p = id2P.get(id);
      while (d > 0) {
        // 实际在 p 上减少了多少值
        int cnt = d > p.a ? p.a : d;
        p.a -= cnt;
        d -= cnt;
        cost += p.c * cnt;
        while (d > 0 && p.a <= 0) {
          p = pq.get(idx);
          // 最小的需要更新时才进行更新
          if (p.a <= 0) {
            if (++idx >= n) break;
            p = pq.get(idx);
          }
        }
        if (idx >= n) break;
      }
      out.println(d == 0 ? cost : 0);
    }
  }

  class P implements Comparable<P> {
    int i;
    int a;
    long c;

    public P(int i, int a, long c) {
      this.i = i;
      this.a = a;
      this.c = c;
    }

    @Override
    public int compareTo(P o) {
      if (this.c == o.c)
        return this.i - o.i;
      return (int) (this.c - o.c);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      P p = (P) o;
      return i == p.i;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i);
    }
  }
}
