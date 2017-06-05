package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #tree #binary-tree
 */
public class Task548 {
    int maxv = 10000 + 10;
    int[] in_order = new int[maxv];
    int[] post_order = new int[maxv];
    int[] lch = new int[maxv];
    int[] rch = new int[maxv];
    int n;
    int best, best_sum; // 目前为止的最优解和对应的权和

    int build(int L1, int R1, int L2, int R2) {
        if (L1 > R1) return 0; // 空树
        int root = post_order[R2];
        int p = L1;
        while (in_order[p] != root) p++;
        int cnt = p - L1; // 左子树的结点个数
        lch[root] = build(L1, p - 1, L2, L2 + cnt - 1);
        rch[root] = build(p + 1, R1, L2 + cnt, R2 - 1);
        return root;
    }

    void dfs(int u, int sum) {
        sum += u;
        if (lch[u] == 0 && rch[u] == 0) { // 叶子
            if (sum < best_sum || (sum == best_sum && u < best)) {
                best = u;
                best_sum = sum;
            }
        }
        if (lch[u] != 0) dfs(lch[u], sum);
        if (rch[u] != 0) dfs(rch[u], sum);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s;
        while ((s = in.nextLine()) != null && !s.isEmpty()) {
            String[] inos = s.split("\\s+");
            String[] postos = in.nextLine().split("\\s+");
            n = postos.length;
            for (int i = 0; i < n; i++) {
                in_order[i] = Integer.parseInt(inos[i]);
                post_order[i] = Integer.parseInt(postos[i]);
            }
            build(0, n - 1, 0, n - 1);
            best_sum = 1000000000;
            dfs(post_order[n - 1], 0);
            out.writeln(best);
        }
    }
}
