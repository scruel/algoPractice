package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task10562 {
    InputReader in;
    OutputWriter out;
    int MAXN = 200 + 10;
    char[][] t;
    int n;

    boolean isC(char c) {
        if (c == ' ') return false;
        if (c == '|') return false;
        //少了这句后会 Runtime error
        if (c == '#') return false;
        return true;
    }

    void dfs(int r, int c) {
        if (c >= t[r].length) return;
        if (isC(t[r][c])) {
            out.write(t[r][c] + "(");
            if (r + 1 < n && c < t[r + 1].length && t[r + 1][c] == '|') {
                int lc = c;
                int rc = c;
                //找左边界
                while (lc - 1 >= 0 && t[r + 2][lc - 1] == '-') {lc--;}
                //找右边界
                while (rc + 1 <= t[r + 2].length - 1 && t[r + 2][rc + 1] == '-') {
                    rc++;
                }
                for (int i = lc; i <= rc; i++) {
                    dfs(r + 3, i);
                }
            }
            out.write(")");
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        this.in = in;
        this.out = out;
        int T = in.nextInt();
        while (T-- > 0) {
            t = new char[MAXN][MAXN];
            n = 0;
            for (; ; ) {
                t[n] = in.nextLine().toCharArray();
                if (t[n][0] == '#') break;
                n++;
            }
            out.write("(");
            if (n != 0) {
                for (int i = 0; i < t[0].length; i++) {
                    dfs(0, i);
                }
            }
            out.write(")\n");
        }
    }
}
