package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #双向链表 #queue
 */
public class Task12657 {
    int[] right;
    int[] left;
    boolean inv;
    int n;

    void link(int L, int R) {
        right[L] = R;
        left[R] = L;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int kase = 0;
        while (!in.isExhausted()) {
            n = in.nextInt();
            inv = false;
            left = new int[n + 5];
            right = new int[n + 5];
            for (int i = 1; i <= n; i++) {
                left[i] = i - 1;
                right[i] = (i + 1) % (n + 1);
            }
            //增加一个虚头
            right[0] = 1;
            left[0] = n;
            int m = in.nextInt();
            while (m-- > 0) {
                int op = in.nextInt();
                if (op == 4) {
                    inv = !inv;
                } else {
                    int X = in.nextInt();
                    int Y = in.nextInt();
                    if (inv && op != 3) op = 3 - op;
                    int LX = left[X], RX = right[X], LY = left[Y], RY = right[Y];
                    if (op == 1 && RX == Y) continue;
                    if (op == 2 && LX == Y) continue;
                    if (op == 1) {
                        //左连接
                        link(LX, RX);
                        link(X, Y);
                        link(LY, X);
                    } else if (op == 2) {
                        link(LX, RX);
                        link(Y, X);
                        link(X, RY);
                    } else if (op == 3) {
                        if (RX == Y) {
                            link(LX, Y);
                            link(Y, X);
                            link(X, RY);
                        } else if (RY == X) {
                            link(Y, RX);
                            link(X, Y);
                            link(LY, X);
                        } else {
                            link(LX, Y);
                            link(Y, RX);
                            link(LY, X);
                            link(X, RY);
                        }
                    }
                }
            }

            long res = 0;
            int b = 0;

            for (int i = 1; i <= n; i++) {
                //从虚头开始
                b = right[b];
                if (i % 2 == 1) res += b;
            }
            if (inv && n % 2 == 0) res = (long) n * (n + 1) / 2 - res;
            out.write("Case ", ++kase, ": ");
            out.writeln(res);
        }
    }
}
