package algsPractice.competition.JSK2017.Round3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class TaskB {
    int n, m, cCnt;
    boolean[] b;
    double[] distTo;
    Edge[] edgeTo;
    PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
    double res = -1;
    boolean can = false;
    LinkedList<Edge>[] adj;

    class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        int other(int vv) {
            return vv == from ? to : from;
        }

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge edge) {
            if (this.weight < edge.weight) return -1;
            if (this.weight > edge.weight) return 1;
            return 0;
        }
    }

    class Pair implements Comparable<Pair> {
        int index;
        double weight;

        public Pair(int index, double weight) {
            this.index = index;
            this.weight = weight;
        }

        public int compareTo(Pair pair) {
            if (this.weight < pair.weight) return -1;
            if (this.weight > pair.weight) return 1;
            return 0;
        }
    }

    void init() {
        distTo = new double[n];
        adj = (LinkedList<Edge>[]) new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<Edge>();
        }
        edgeTo = new Edge[n];
    }

    void addEdge(int v, int w, double weight) {
        Edge e = new Edge(v, w, weight);
        adj[v].add(e);
    }

    void dijkstra() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(distTo, Double.POSITIVE_INFINITY);
            distTo[i] = 0.0;
            cCnt = 1;
            queue.clear();
            queue.add(new Pair(i, 0));
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                int v = p.index;
                //当前取出的值不是最短距离，就丢弃这个距离，《挑战》的优化
                //通俗一点就是，当前已经不是最短了，下面还要加上toW的边，更不可能了，所以舍弃
                if (distTo[v] < p.weight) continue;
                for (Edge e : adj[v]) {
                    int w = e.other(v);
                    if (b[w] || b[v]) can = true;
                    //满足条件，更新
                    if (distTo[w] > distTo[v] + e.weight) {
                        cCnt++;
                        distTo[w] = distTo[v] + e.weight;
                        edgeTo[w] = e;
                        if (can) {
                            double tmp = cCnt * (2 * n - cCnt);
                            tmp = (-distTo[w]) / tmp;
                            if (tmp > res) res = tmp;
                        } else {
                            double tmp = (cCnt + 1) * (2 * n - (cCnt + 1));
                            tmp = (-distTo[w]) / tmp;
                            if (tmp > res) res = tmp;
                        }
                        queue.add(new Pair(w, distTo[w]));
                    }
                }
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        res = 0;
        can = false;
        n = in.nextInt();
        m = in.nextInt();
        b = new boolean[n];
        init();
        for (int i = 0; i < m; i++) {
            addEdge(in.nextInt() - 1, in.nextInt() - 1, -in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt() == 1;
        }
        dijkstra();
        out.write(String.format("%.4f", res));
    }
}
