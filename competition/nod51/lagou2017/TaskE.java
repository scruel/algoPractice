package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskE {
    static final double EPS = 1e-10;
    static final int INF = 0x3f3f3f3f;
    static final long INFL = 0x3f3f3f3f3f3f3f3fL;
    static final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Pair[] ps = new Pair[n + 10];
//        int[] mk = new int[n];
        for (int i = 1; i <= n; i++) {
            ps[i] = new Pair(in.nextInt(), in.nextInt(), i);
        }
        Arrays.sort(ps, 1, n + 1);
//        int mkId = 0;
        //or return maxy
        LinkedList<String> res = new LinkedList<String>();
        double max = 0.0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (ps[j].y < ps[i].y) continue;
                double tmp = (ps[j].y - ps[i].y) / (double) (ps[j].x - ps[i].x);
                if (tmp > max) {
                    res.clear();
                    res.add(ps[i].index + " " + ps[j].index);
                    max = tmp;
                } else if (tmp == max) {
                    res.add(ps[i].index + " " + ps[j].index);
                }
            }
        }
        for (String s : res)
            out.writeln(s);
    }

    static class Pair implements Comparable<Pair> {
        int x, y, index;

        public Pair(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x < o.x) {
                return -1;
            } else {
                if (this.y > o.y) return 1;
                else if (this.y < o.y) return -1;
                else return 0;
            }
        }
    }
}
