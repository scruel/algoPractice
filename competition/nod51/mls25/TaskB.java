package algsPractice.competition.nod51.mls25;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

public class TaskB {
    int n;
    int[] nums;
    boolean[] mrks;
    int[] tmp;
    int[] nC = new int[3000 + 5];
    int cnt;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        nums = in.nextIntArray(n);
        mrks = new boolean[n];
        tmp = new int[n];
        dfs(0);
        out.write(cnt);
    }

    boolean check() {

        for (int i = 1; i < n; i++) {
            if (Math.abs(tmp[i] - tmp[i - 1]) > 1) return false;
        }
        return true;
    }

    void dfs(int index) {
        if (index == n) {
            if (check()) {
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
