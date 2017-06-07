package algsPractice.OJ.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #binary #enum
 */
public class Task37631 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int X = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((1 & (i >> j)) == 1) sum += nums[j];
            }
            if (sum == X) res++;
        }
        out.writeln(res);
    }
}
