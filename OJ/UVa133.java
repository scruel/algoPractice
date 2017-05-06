package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa133 {
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //这里将list开成MAX_N，然后用1...n来表示可以更加清晰
        static int[] list;
        static int n;

        static void solve() throws IOException {
                while (true) {
                        String[] rTs = bfr.readLine().split("\\s+");
                        n = new Integer(rTs[0]);
                        if (n == 0) break;
                        int k = new Integer(rTs[1]);
                        int m = new Integer(rTs[2]);
                        list = new int[n];
                        for (int i = 1; i <= n; i++) {
                                list[i - 1] = i;
                        }
                        int p1 = -1;
                        int left = n;
                        int p2 = n;
                        while (left > 0) {
                                p1 = go(p1, 1, k);
                                p2 = go(p2, -1, m);
                                bfw.write(String.format("%3d", list[p1]));
                                left--;
                                if (p1 != p2) {
                                        bfw.write(String.format("%3d", list[p2]));
                                        left--;
                                }
                                list[p1] = list[p2] = 0;
                                if (left > 0)
                                        bfw.write(",");
                        }
                        bfw.write("\n");
                }
                bfr.close();
                bfw.close();
        }

        static int go(int p, int d, int t) {
                while (t-- > 0) {
                        do {
                                //对于有负数的情况，(+n)%n方式可以控制数在0~n-1范围内
                                p = (p + d + n) % n;
                        } while (list[p] == 0);
                }
                return p;
        }

        public static void main(String[] args) throws IOException {
                solve();
        }
}
