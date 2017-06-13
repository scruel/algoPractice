package algsPractice.competition.codem;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #easy
 */
public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] y1 = new int[n];
        for (int i = 0; i < n; i++) y1[i] = in.nextInt();
        int m = in.nextInt();
        int[] y2 = new int[m];
        for (int i = 0; i < m; i++) y2[i] = in.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m - n + 1; i++) {
            int sum = 0;
            for (int j = i; j < n + i; j++) {
                sum += (y1[j - i] - y2[j]) * (y1[j - i] - y2[j]);
            }
            if (sum < min) min = sum;
        }
        out.writeln(min);
    }
}
