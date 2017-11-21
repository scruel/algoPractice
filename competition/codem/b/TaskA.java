package algsPractice.competition.codem.b;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskA {
  int MAXN = 100000 + 10;
  int[] father = new int[MAXN];
  int[] ks = new int[MAXN];
  int[] id = new int[MAXN];
  int n, cnt;
  boolean[] cld = new boolean[MAXN];
  boolean[] ish = new boolean[MAXN];

  int find(int p) {
    return p == id[p] ? p : (id[p] = find(id[p]));
  }

  void union(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rp == rq) {
      return;
    }
    cnt--;
    id[rp] = rq;
  }

  void uu(int v) {
    int vv = v;
    ish[vv] = true;
    if (cld[v] || v == 0) {
      return;
    }
    for (int i = 0; i < ks[vv]; i++) {
      if (v > n - 1) {
        return;
      }
      int w = father[v];
      cld[v] = true;
      cld[w] = true;
      ish[w] = false;
      union(v, w);
      if (ks[vv] - i - 1 < ks[w]) {
        ls(w);
      }
      v = w;
    }
  }

  void ls(int v) {
    int vv = v;
    if (v == 0) {
      return;
    }
    LinkedList<Integer> ls = new LinkedList<Integer>();
    for (int i = 0; i < ks[vv]; i++) {
      if (v > n - 1) {
        return;
      }
      int w = father[v];
      if (!ish[w]) {
        return;
      }
      cld[w] = false;
      id[w] = w;
      ls.add(w);
      cnt++;
      v = w;
    }
    for (int w : ls) {
      uu(w);
    }
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    cnt = n;
    for (int i = 1; i < n; i++)
      father[i] = in.nextInt() - 1;
    for (int i = 0; i < n; i++)
      ks[i] = in.nextInt() - 1;
    for (int i = 0; i < n + 1; i++)
      id[i] = i;

    for (int i = 0; i < n; i++) {
      uu(i);
    }
    out.writeln(cnt);
  }
}
