package algsPractice.competition.codem.a;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskD {
    int maxn = 50000 + 10;
    int n, m;
    int[] nums = new int[maxn];

    int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        while (m-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            int k = in.nextInt();

        }
    }
}
