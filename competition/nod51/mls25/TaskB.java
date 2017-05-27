package algsPractice.competition.nod51.mls25;

import algs4_new.MyTools;
import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

public class TaskB {
    static int n;
    static int[] nums;
    static boolean[] mrks;
    static int[] tmp;
    static int[] nC = new int[3000 + 5];
    static int cnt;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        nums = in.nextIntArray(n);
        mrks = new boolean[n];
        tmp = new int[n];
        dfs(0);
        out.write(cnt);
    }

    static boolean check() {

        for (int i = 1; i < n; i++) {
            if (Math.abs(tmp[i] - tmp[i - 1]) > 1)
                return false;
        }
        return true;
    }

    static void dfs(int index) {
        if (index == n) {
            if (check()) {
                MyTools.print_r(tmp);
                cnt++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!mrks[i]) {
                mrks[i] = true;
                tmp[index] = nums[i];
                dfs(index + 1);
                mrks[i] = false;
            }
        }
    }
}
