package algsPractice.OJ.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37633 {
    static final double EPS = 1e-10;
    static final int INF = 0x3f3f3f3f;
    static final long INFL = 0x3f3f3f3f3f3f3f3fL;
    static final int MOD = 1000000007;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
//            int c = in.nextInt();
//            int d = in.nextInt();
//            int w = in.nextInt();
            for (int j = 0; j < 3; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int r = 10;
            int tRf = 0;
            int tRs = 0;
            boolean canW = false;
            boolean f = true;
            for (int j = 1; j < n; j++) {
                if ((1 & (i >> j)) == 1) {
                    r -= nums[j][0];
                    if (r < 0) {
                        f = false;
                        break;
                    }
                    if (nums[j][1] == 0) {
                        tRs += nums[j][2];
                        canW = true;
                    } else {
                        tRf += nums[j][2];
                    }
                }
            }
            int tR = canW ? tRf + tRs : tRs;
            if (f && tR > res) res = tR;
        }
        out.writeln(res);
    }
}
