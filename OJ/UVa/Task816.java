package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task816 {
    int[][][][] mz;
    int[][][] d;
    Node[][][] p;
    boolean[][][] mk;
    int sx, sy, sd, ex, ey;
    //NESW = 0-3
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    String dirs = "NESW";
    String turns = "FLR";
    OutputWriter out;

    int dirID(char c) {return dirs.indexOf(c);}

    int tId(char c) {return turns.indexOf(c);}

    Node walk(Node u, int tid) {
        int d = u.d;
        if (tid == 1) d = (d + 3) % 4;
        if (tid == 2) d = (d + 1) % 4;
        return new Node(u.x + dx[d], u.y + dy[d], d);
    }

    void printRes(Node u) {
        Stack<Node> s = new Stack<Node>();
        while (true) {
            if (u == null) break;
            s.add(u);
            u = p[u.x][u.y][u.d];
        }
        s.add(new Node(sx, sy, sd));

        int len = s.size();
        int cnt = 0;
        while (!s.isEmpty()) {
            Node dots = s.pop();
            if (cnt % 10 == 0) {
                out.writeln();
                out.write("  ");
            }
            cnt++;
            if (cnt % 10 == 0 || cnt == len) {
                out.write(String.format("(%d,%d)", dots.x, dots.y));
            } else {
                out.write(String.format("(%d,%d) ", dots.x, dots.y));
            }
        }
        out.writeln();
    }

    void solve() {
        LinkedList<Node> list = new LinkedList<Node>();
        int sx1 = sx + dx[sd];
        int sy1 = sy + dy[sd];
        Node st = new Node(sx1, sy1, sd);
        list.add(st);
        while (!list.isEmpty()) {
            Node u = list.poll();
            if (u.x == ex && u.y == ey) {
                printRes(u);
                return;
            }
            //下一个转向是否可走
            for (int i = 0; i < 3; i++) {
                Node v = walk(u, i);
                if (v.x < 0 || v.x > 9 || v.y < 0 || v.y > 9) continue;
                if (mz[u.x][u.y][u.d][i] == 1 && !mk[v.x][v.y][v.d]) {
                    //last
                    //自己写的时候写写成了u.d-->v.d之间检测mk情况导致错误，
                    //其实只需要标记目标点及进入点情况
                    mk[v.x][v.y][v.d] = true;
                    p[v.x][v.y][v.d] = u;
                    list.add(v);
                }
            }
        }
        out.writeln("\n  No Solution Possible");
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String t;
        this.out = out;
        while ((t = in.nextLine()) != null && !t.equals("END")) {
            out.write(t);
            mz = new int[10][10][4][3];
            p = new Node[10][10][4];
            mk = new boolean[10][10][4];
            sx = in.nextInt();
            sy = in.nextInt();
            sd = dirID(in.nextChar());
            ex = in.nextInt();
            ey = in.nextInt();
            int mx, my;
            while ((mx = in.nextInt()) != 0) {
                my = in.nextInt();
                String ss;
                while (!(ss = in.nextString()).equals("*")) {
                    int dI = dirID(ss.charAt(0));
                    for (int i = 1; i < ss.length(); i++) {
                        mz[mx][my][dI][tId(ss.charAt(i))] = 1;
                    }
                }
            }
            solve();
        }
    }

    static class Node {
        int x, y, d;

        public Node() {;}

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
