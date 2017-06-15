package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task_the_birthday_bar {
    int MAXN = 100 + 10;
    int n;
    int[] nums = new int[MAXN];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += nums[j];
                if (sum > d) break;
            }
            if (sum == d) res++;
        }
        out.writeln(res);
    }
}
