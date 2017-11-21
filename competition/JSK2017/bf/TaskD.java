package algsPractice.competition.JSK2017.bf;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #shortest #graph
 * http://paste.ubuntu.com/24822181/
 */
public class TaskD {
  int[] id;
  long[] distTo;
  EdgeList[] adj;
  EdgeList[] adjc;
  CityList[] city;
  CityList[] cityx;
  boolean[] mk;
  int n, m;
  PriorityQueue<Pair> queue = new PriorityQueue<Pair>();

  void addEdge(int v, int w, long weight) {
    if (v == w) {
      return;
    }
    Edge e = new Edge(v, w, weight);
    if (v == w) {
      adj[v].add(e);
    }
    else {
      adj[v].add(e);
      adj[w].add(e);
    }
  }

  void addEdgeC(int v, int w, long weight) {
    Edge e = new Edge(v, w, weight);
    if (v == w) {
      adjc[v].add(e);
    }
    else {
      adjc[v].add(e);
      adjc[w].add(e);
    }
  }

  void dijkstra(int s, int t) {
    Arrays.fill(distTo, Long.MAX_VALUE);
    distTo[s] = 0;
    queue.add(new Pair(s, 0));
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      int v = p.index;
      mk[v] = true;
      if (v == t) {
        return;
      }
      if (distTo[v] < p.weight) {
        continue;
      }
      for (Edge e : adj[v]) {
        int w = e.other(v);
        if (!mk[w] && distTo[w] > distTo[v] + e.weight) {
          //                if (distTo[w] > distTo[v] + e.weight) {
          distTo[w] = distTo[v] + e.weight;
          queue.add(new Pair(w, distTo[w]));
        }
      }
      //belong city
      for (int vc : cityx[v]) {
        for (Edge e : adjc[vc]) {
          //other city
          int wc = e.other(vc);
          for (int w : city[wc]) {
            if (!mk[w] && distTo[w] > distTo[v] + e.weight) {
              //                        if (distTo[w] > distTo[v] + e.weight) {
              distTo[w] = distTo[v] + e.weight;
              queue.add(new Pair(w, distTo[w]));
            }
          }
        }
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    n = in.nextInt();
    m = in.nextInt();//qun totals
    city = new CityList[m + 10];
    cityx = new CityList[m + 10];
    id = new int[n + 10];
    mk = new boolean[n + 10];
    distTo = new long[n + 10];
    adj = new EdgeList[n + 10];
    adjc = new EdgeList[n + 10];
    //        for (int i = 1; i < n + 10; i++) id[i] = i;
    for (int i = 1; i < n + 10; i++)
      adj[i] = new EdgeList();
    for (int i = 1; i < n + 10; i++)
      adjc[i] = new EdgeList();
    for (int i = 1; i < m + 10; i++)
      city[i] = new CityList();
    for (int i = 1; i < m + 10; i++)
      cityx[i] = new CityList();
    //        adjC = new MyList[n];
    //        for (int i = 0; i < n; i++) adjC[i] = new MyList();
    for (int i = 1; i <= m; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int c = in.nextInt();
        cityx[c].add(i);
        city[i].add(c);
      }
    }

    int m1 = in.nextInt();
    for (int i = 0; i < m1; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      int c = in.nextInt();
      addEdge(u, v, c);
    }

    int m2 = in.nextInt();
    for (int i = 0; i < m2; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      int c = in.nextInt();
      addEdgeC(u, v, c);
      //            for (int p = 0; p < city[u].size(); p++) {
      //                for (int q = 0; q < city[v].size(); q++) {
      //                    addEdge(city[u].get(p), city[v].get(q), c);
      //                }
      //            }
    }

    int s = in.nextInt();
    int t = in.nextInt();
    dijkstra(s, t);
    if (!mk[t] || !mk[s]) {
      out.writeln(-1);
    }
    else {
      out.writeln(distTo[t]);
    }
  }

  class Edge implements Comparable<Edge> {
    int from;
    int to;
    long weight;

    public Edge(int from, int to, long weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    int other(int vv) {
      return vv == from ? to : from;
    }

    public int compareTo(Edge edge) {
      if (this.weight < edge.weight) {
        return -1;
      }
      if (this.weight > edge.weight) {
        return 1;
      }
      return 0;
    }
  }

  //    int find(int p) {
  //        return id[p] == p ? p : (id[p] = find(id[p]));
  //    }

  class Pair implements Comparable<Pair> {
    int index;
    long weight;

    public Pair(int index, long weight) {
      this.index = index;
      this.weight = weight;
    }

    public int compareTo(Pair pair) {
      if (this.weight < pair.weight) {
        return -1;
      }
      if (this.weight > pair.weight) {
        return 1;
      }
      return 0;
    }
  }

  class EdgeList extends LinkedList<Edge> {
  }

  class CityList extends LinkedList<Integer> {
  }
}
