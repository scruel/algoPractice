package algsPractice.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Scruel on 2017/4/6.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #graph #bfs
 */
public class Task3255 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
  LinkedList<Edge>[] adj;
  int[] distTo;
  int[] distKTo;
  Edge[] edgeTo;
  Edge[] edgeKTo;
  int V;
  boolean[] marked;

  public static void main(String[] args) throws IOException {
    new Task3255().solve();
  }

  void addEdge(int v, int w, int weight) {
    Edge e = new Edge(v, w, weight);
    adj[v].add(e);
    adj[w].add(e);
  }

  void init(int n) {
    V = n;
    adj = (LinkedList<Edge>[]) new LinkedList[V];
    distTo = new int[V];
    edgeTo = new Edge[V];
    distKTo = new int[V];
    edgeKTo = new Edge[V];
    marked = new boolean[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new LinkedList<Edge>();
    }
  }

  void solve() throws IOException {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    String[] rTs = bfr.readLine().split("\\s+");
    int n = Integer.parseInt(rTs[0]);
    int m = Integer.parseInt(rTs[1]);
    init(n);
    for (int i = 0; i < m; i++) {
      rTs = bfr.readLine().split("\\s+");
      addEdge(Integer.parseInt(rTs[0]) - 1, Integer.parseInt(rTs[1]) - 1, Integer.parseInt(rTs[2]));
    }

    Arrays.fill(distTo, Integer.MAX_VALUE);
    Arrays.fill(distKTo, Integer.MAX_VALUE);
    distTo[0] = 0;
    pq.add(new Pair(0, 0));
    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int v = p.index;
      if (distKTo[v] < p.weight) {
        continue;
      }
      for (Edge e : adj[v]) {
        int w = e.other(v);
        int d2 = p.weight + e.weight;
        if (distTo[w] > d2) {
          int temp = distTo[w];
          distTo[w] = d2;
          d2 = temp;
          edgeTo[w] = e;
          pq.add(new Pair(w, distTo[w]));
        }
        if (distKTo[w] > d2 && distTo[w] < d2) {
          distKTo[w] = d2;
          edgeKTo[w] = e;
          pq.add(new Pair(w, distKTo[w]));
        }
      }
    }

    //                int v = n - 1;
    //                int res = 0;
    //                while (edgeKTo[v] != null) {
    //                        Edge e = edgeKTo[v];
    //                        res += e.weight;
    //                        v = e.others(v);
    //                }
    System.out.println(distKTo[n - 1]);

  }

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    public int other(int vx) {
      return vx == from ? to : from;
    }

    public int compareTo(Edge edge) {
      if (this.weight > edge.weight) {
        return 1;
      }
      if (this.weight < edge.weight) {
        return -1;
      }
      return 0;
    }
  }

  static class Pair implements Comparable<Pair> {
    int index;
    int weight;

    public Pair(int index, int weight) {
      this.index = index;
      this.weight = weight;
    }

    public int compareTo(Pair p) {
      if (this.weight < p.weight) {
        return -1;
      }
      if (this.weight > p.weight) {
        return 1;
      }
      return 0;
    }
  }
}
