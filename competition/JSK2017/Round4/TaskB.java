package algsPractice.competition.JSK2017.Round4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
    HashMap<Pair, Integer> map = null;

    class Pair implements Comparable<Pair> {
        String s;
        int x;
        int y;

        @Override public int hashCode() {
            return s.hashCode();
        }

        @Override public boolean equals(Object obj) {
            Pair tm = (Pair) obj;
            return s.equals(tm.s);
        }

        @Override public int compareTo(Pair o) {
            if (this.hashCode() < o.hashCode()) return -1;
            else if (this.hashCode() > o.hashCode()) return 1;
            return 0;
        }
    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        map = new HashMap<Pair, Integer>();
        int n = in.nextInt();
        int dx = 0, dy = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int xp = in.nextInt();
            int yp = in.nextInt();
            String s = (xp - x) + "," + (yp - y);
            Pair p = new Pair();
            p.s = s;
            p.x = xp - x;
            p.y = yp - y;
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
                if (map.get(p) >= n / 2) {
                    dx = xp - x;
                    dy = yp - y;
                    flag = true;
                    break;
                }
            } else {
                map.put(p, 1);
            }
        }

        if (flag) {
            out.write(dx + " " + dy);
        } else {
            Pair mp = null;
            int max = 0;
            for (Map.Entry<Pair, Integer> en : map.entrySet()) {
                if (en.getValue().compareTo(max) > 0) {
                    max = en.getValue();
                    mp = en.getKey();
                }
            }
            out.write(mp.x + " " + mp.y);

        }
    }
}
