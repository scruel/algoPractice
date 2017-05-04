package practice.algsoj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2012/1/7.
 */
public class POJ3723_Conscription {
        static int res;
        static int[] size;
        static int[] id;
        static Edge[] edges;
        static int V, E;

        static class Edge implements Comparable<Edge> {
                int v;
                int w;
                int weight;

                public Edge(int v, int w, int weight) {
                        this.v = v;
                        this.w = w;
                        this.weight = weight;
                }

                public int compareTo(Edge edge) {
                        if (this.weight < edge.weight) return -1;
                        if (this.weight > edge.weight) return 1;
                        return 0;
                }
        }

        static void init(int m, int n, int r) {
                V = n + m;
                E = r;
                size = new int[V];
                id = new int[V];
                edges = new Edge[E];
                for (int i = 0; i < V; i++) {
                        id[i] = i;
                }
        }

        static int find(int p) {
                while (p != id[p]) {
                        p = id[p];
                }
                return p;
        }

        static boolean connected(int p, int q) {
                return find(p) == find(q);
        }

        static void union(int p, int q) {
                int pR = find(p);
                int qR = find(q);
                if (pR == qR) return;

                if (size[pR] < size[qR]) id[pR] = qR;
                else id[qR] = pR;
                if (size[pR] == size[qR]) size[pR]++;
        }

        //        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static String[] rTs;

        static class cin {
                static int leave = 0;
                static StringTokenizer st;
                static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                static int nextInt() throws IOException {
                        while (leave == 0) {
                                st = new StringTokenizer(in.readLine());
                                leave = st.countTokens();
                        }
                        leave--;
                        return Integer.parseInt(st.nextToken());
                }
                static void close() throws IOException{
                        in.close();
                }
        }

        public static void main(String[] args) throws Exception {
//                Scanner scanner = new Scanner(System.in);
                int round = new Integer(cin.nextInt());
                while (round-- != 0) {
//                        bfr.readLine();
                        res = 0;
//                        rTs = bfr.readLine().split("\\s+");
//                        int n = new Integer(rTs[0]);
//                        int m = new Integer(rTs[1]);
//                        int r = new Integer(rTs[2]);
                        int n = cin.nextInt();
                        int m = cin.nextInt();
                        int r = cin.nextInt();
                        init(n, m, r);
                        for (int i = 0; i < E; i++) {
//                                rTs = bfr.readLine().split("\\s+");
                                edges[i] = new Edge(cin.nextInt(), n + cin.nextInt(), -cin.nextInt());
//                                edges[i] = new Edge(new Integer(rTs[0]), n + new Integer(rTs[1]), -new Integer(rTs[2]));
                        }
                        Arrays.sort(edges);
                        for (int i = 0; i < E; i++) {
                                Edge e = edges[i];
                                if (!connected(e.v, e.w)) {
                                        union(e.v, e.w);
                                        res += e.weight;
                                }
                        }
                        bfw.write(10000 * (V) + res + "\n");
                }
                bfw.close();
//                bfr.close();
        }
}