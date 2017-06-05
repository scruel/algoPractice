package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task297 {

    String s;
    int len = 32;
    boolean[][] bits = null;
    int cnt = 0;
    int p = 0;


    //f = black, e = white, p = gray
    void build(int x, int y, int l) {
        char ch = s.charAt(p++);
        if (ch == 'p') {
            build(x, y, l / 2);
            build(x, y + l / 2, l / 2);
            build(x + l / 2, y, l / 2);
            build(x + l / 2, y + l / 2, l / 2);
        } else if (ch == 'f') {
            for (int i = x; i < x + l; i++) {
                for (int j = y; j < y + l; j++) {
                    if (!bits[i][j]) {
                        bits[i][j] = true;
                        cnt++;
                    }
                }
            }
        }
    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int T = in.nextInt();
        while (T-- > 0) {
            bits = new boolean[len][len];
            cnt = 0;
            p = 0;
            s = in.nextLine();
            build(0, 0, len);
            p = 0;
            s = in.nextLine();
            build(0, 0, len);
            out.writeln("There are ", cnt, " black pixels.");
        }
    }
}
