package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task10763 {
    static class Pair implements Comparable<Pair> {
        int x, t;

        public Pair(int x, int t) {
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x > o.x) return 1;
            else if (this.x < o.x) return -1;
            else if (this.t > o.t) return 1;
            else if (this.t < o.t) return -1;
            return 0;
        }

        @Override
        public int hashCode() {
            int res = 1;
            res = res * 31 + x;
            res = res * 31 + t;
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.x == x && p.t == t;
        }
    }

    public void solve1(int testNumber, InputReader in, OutputWriter out) {
        int n;
        while ((n = in.nextInt()) != 0) {
            HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int t = in.nextInt();
                if (x == t) continue;
                Pair p = new Pair(x, t);
                if (map.containsKey(p)) map.put(p, map.get(p) + 1);
                else map.put(p, 1);
            }
            boolean flag = true;
            for (Map.Entry<Pair, Integer> e : map.entrySet()) {
                Pair p = e.getKey();
                Pair pp = new Pair(p.t, p.x);
                if (!map.containsKey(pp)) {
                    flag = false;
                    break;
                }
                if (map.get(pp) != e.getValue()) {
                    flag = false;
                    break;
                }

            }
            if (flag) out.writeln("YES");
            else out.writeln("NO");
        }
    }

    public void solve2(int testNumber, InputReader in, OutputWriter out) {
        int n;
        while ((n = in.nextInt()) != 0) {
            Pair[] ps1 = new Pair[n];
            Pair[] ps2 = new Pair[n];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int t = in.nextInt();
                Pair p1 = new Pair(x, t);
                Pair p2 = new Pair(t, x);
                ps1[i] = p1;
                ps2[i] = p2;
            }
            Arrays.sort(ps1);
            Arrays.sort(ps2);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (ps1[i].x != ps2[i].x || ps2[i].t != ps1[i].t) {
                    flag = false;
                    break;
                }

            }
            if (flag) out.writeln("YES");
            else out.writeln("NO");
        }
    }

    int[] num;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n;
        while ((n = in.nextInt()) != 0) {
            num = new int[500000 + 5];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int t = in.nextInt();
                num[x]--;
                num[t]++;
            }
            boolean flag = true;
            for (int i = 1; i <= 500000; i++) {
                if (num[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) out.writeln("YES");
            else out.writeln("NO");
        }
    }
}
