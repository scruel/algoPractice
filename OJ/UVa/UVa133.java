package algsPractice.OJ.UVa;

import java.io.*;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * n(n<20)个人站成一圈，逆时针编号为1～n。有两个官员，A从1开始逆时针数，B从n开
 * 始顺时针数。在每一轮中，官员A数k个就停下来，官员B数m个就停下来（注意有可能两个
 * 官员停在同一个人上）。接下来被官员选中的人（1个或者2个）离开队伍。
 * 输入n，k，m输出每轮里被选中的人的编号（如果有两个人，先输出被A选中的）。例
 * 如，n=10，k=4，m=3，输出为4 8, 9 5, 3 1, 2 6, 10, 7。注意：输出的每个数应当恰好占3列。
 * #simulate
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
            n = Integer.parseInt(rTs[0]);
            if (n == 0) break;
            int k = Integer.parseInt(rTs[1]);
            int m = Integer.parseInt(rTs[2]);
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
