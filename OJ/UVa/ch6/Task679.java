package algsPractice.OJ.UVa.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #tree #binary-tree #simulate
 */
public class Task679 {
    boolean[] s;

    //simulate each ball.
    public void solve1(int testNumber, InputReader in, OutputWriter out) {
        int T = in.nextInt();
        while (T-- > 0) {
            int D = in.nextInt();
            int I = in.nextInt();
            int k = 0;
            int n = ((1 << D) - 1);
            s = new boolean[n + 1];
            for (int i = 0; i < I; i++) {
                k = 1;
                for (; ; ) {
                    s[k] = !s[k];
                    k = s[k] ? k * 2 : k * 2 + 1;
                    if (k > n) break;
                }
            }
            out.writeln(k / 2);
        }

    }

    //simulate the last ball by math.
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int T = in.nextInt();
        while (T-- > 0) {
            int D = in.nextInt();
            int I = in.nextInt();
            int k = 1;
            //close-left
            for (int i = 0; i < D - 1; i++) {
                //I = how many balls will through in i layer.
                if ((I & 1) == 0) {
                    k = k * 2 + 1;
                } else {
                    k = k * 2;
                }
                I = (I - 1) / 2 + 1;
            }
            out.writeln(k);
        }
    }
}
