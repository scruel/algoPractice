package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #graph #bfs #TODO:WA？!!!
 */
public class Task1599 {

  int MAXN = 100000 + 10;
  int INF = 1000000000; // maximal color
  int n, m;
  MyList[] adj = new MyList[MAXN];
  boolean[] vis = new boolean[MAXN];
  int[] d = new int[MAXN];
  LinkedList<Integer> ans;

  //寻找最短路径，将当前点到终点的距离保存在d中
  void rev_bfs() {
    Arrays.fill(vis, false);
    d[n - 1] = 0;
    vis[n - 1] = true;
    LinkedList<Integer> q = new LinkedList<Integer>();
    q.add(n - 1);
    while (!q.isEmpty()) {
      int v = q.poll();
      for (Edge e : adj[v]) {
        int u = e.other(v);
        if (!vis[u]) {
          vis[u] = true;
          d[u] = d[v] + 1;
          q.add(u);
        }
      }
    }
  }

  void bfs() {
    Arrays.fill(vis, false);
    vis[0] = true;
    ans = new LinkedList<Integer>();

    LinkedList<Integer> next = new LinkedList<Integer>();
    next.add(0);
    for (int i = 0; i < d[0]; i++) {
      int min_color = INF;
      //寻找下一个节点对应的最小值，下一个节点需满足d值恰好减少1
      for (int u : next) {
        for (Edge e : adj[u]) {
          int v = e.other(u);
          if (d[u] == d[v] + 1) {
            min_color = Math.min(min_color, e.c);
          }
        }
      }
      // find out the next vertices of the next phase
      ans.add(min_color);
      LinkedList<Integer> next2 = new LinkedList<Integer>();
      for (int u : next) {
        for (Edge e : adj[u]) {
          int v = e.other(u);
          if (d[u] == d[v] + 1 && !vis[v] && e.c == min_color) {
            vis[v] = true;
            next2.add(v);
          }
        }
      }
      next = next2;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (!in.isExhausted()) {
      n = in.nextInt();
      m = in.nextInt();
      //            adj = new MyList[MAXN];
      for (int i = 0; i < n; i++)
        adj[i] = new MyList();
      int u, v, w;
      while (m-- > 0) {
        u = in.nextInt() - 1;
        v = in.nextInt() - 1;
        w = in.nextInt();
        Edge e = new Edge(u, v, w);
        adj[u].add(e);
        adj[v].add(e);
      }
      rev_bfs();
      bfs();
      out.writeln(ans.size());
      out.write(ans.get(0));
      for (int i = 1; i < ans.size(); i++) {
        out.write(" " + ans.get(i));
      }
      out.writeln();
    }

  }

  static class Edge {
    int v, u, c;

    public Edge() {}

    public Edge(int v, int u, int c) {
      this.v = v;
      this.u = u;
      this.c = c;
    }

    public int other(int v) {
      return v == this.v ? this.u : this.v;
    }
  }

  static class MyList extends LinkedList<Edge> {
  }
}
