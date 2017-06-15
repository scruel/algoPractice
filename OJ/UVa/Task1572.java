package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #graph #TODO
 * 首先因为可以旋转和反转，所以可以保证在拼接的过程中正方形不会自交。
 * 把边的标号看成点，将正方形的边界A+变成B+可以看做是一条边。比如说，一个正方形中有A-和B+两条边，则A-与其他正方形中A+结合后，结合前边界为A-，结合后变为B+。
 * <p>
 * 这样就得到图中的一条有向边A+ → B+
 * <p>
 * 如果能在图中找到一个环，则可以无限循环拼接正方形。
 */
public class Task1572 {
    int n;
    int[][] G;
    int[] mk;

    //编号转换十分精妙
    int getID(char a, char b) {
        return (a - 'A') * 2 + (b == '+' ? 0 : 1);
    }

    void connect(char a1, char a2, char b1, char b2) {
        if (a1 == '0' || b1 == '0') return;
        //出口，与1异或后A+会变为A-
        int u = getID(a1, a2) ^ 1;
        //入口
        int v = getID(b1, b2);
        G[v][u] = 1;
    }

    boolean dfs(int u) {
        //访问中的状态
        mk[u] = -1;
        for (int v = 0; v < 52; v++) {
            if (G[u][v] == 1) {
                if (mk[v] < 0) return true;
                if (mk[v] == 0 && dfs(v)) return true;
            }
        }
        //访问完毕的状态
        mk[u] = 1;
        return false;
    }

    boolean find_cycle() {
        for (int i = 0; i < 52; i++) {
            if (mk[i] == 0 && dfs(i)) return true;
        }
        return false;
    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        while (!in.isExhausted()) {
            mk = new int[52];
            G = new int[52][52];
            n = in.nextInt();
            while (n-- > 0) {
                char[] s = in.nextString().toCharArray();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        //自己不能和自己连
                        if (i != j) connect(s[i * 2], s[i * 2 + 1], s[j * 2], s[j * 2 + 1]);
                    }
                }

            }
            if (find_cycle()) out.write("unbounded\n");
            else out.write("bounded\n");
        }
    }
}
