package algsPractice.competition.nod51.mls25;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * #线段树
 */

public class TaskC {
    int n;
    int[] a;
    int[] b;
    int[][] t;
    int res = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextIntArray(n);
        b = in.nextIntArray(n);
        res = 0;
        for (int i = 0; i < n; i++) {
            int maxA = a[i];
            int maxB = b[i];
            for (int j = i; j < n; j++) {
                if (maxA < a[j]) maxA = a[j];
                if (maxB < b[j]) maxB = b[j];
                if (maxA == maxB) {
                    res++;
                }
            }
        }
        out.write(res);
    }
}
