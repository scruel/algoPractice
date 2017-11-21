package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 7. 欧拉（道路）回路（一笔画）
 * 对于无向图：
 * 如果一个无向图是连通的，且最多只有两个奇点（度数），则一定存在欧拉道路；如果有两个奇点，则必须从其中一个奇点触发，另一个奇点终止可形成欧拉道路；如果奇点不存在，则可以从任一点出发，形成欧拉回路。
 * 对于有向图：
 * 最多只有两个点的入度不等于出度，而且必须是其中一个点的出度恰好比入度答大1（起点），另一个点的入度比出度大1（终点）。（该有向图在忽略边的方向后，图是连通的）
 * <p>
 * #欧拉回路 #graph #union
 */
public class Task10129 {
  //    int MAXN = 100000 + 10;
  int n, V;
  //并查集，是否出现，单词度数
  int[] id, used, deg;

  int find(int p) {
    return p == id[p] ? p : (id[p] = find(id[p]));
  }

  void union(int p, int q) {
    int pr = find(p);
    int qr = find(q);
    if (pr != qr) {
      V--;
      id[pr] = qr;
    }
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      n = in.nextInt();
      id = new int[256];
      used = new int[256];
      deg = new int[256];
      for (int i = 1; i < 256; i++) {
        id[i] = i;
      }
      V = 26;
      for (int i = 0; i < n; i++) {
        String s = in.nextLine();
        char c1 = s.charAt(0);
        char c2 = s.charAt(s.length() - 1);
        used[c1] = used[c2] = 1;
        //统计度数
        deg[c1]++;
        deg[c2]--;
        union(c1, c2);
        //                for (int j = 0; j < s.length() - 1; j++) {
        //                    used[s.charAt(i)]++;
        //                    union(s.charAt(i), s.charAt(i + 1));
        //                    addEdge(s.charAt(i), s.charAt(i + 1));
        //                }
      }
      LinkedList<Integer> l = new LinkedList<Integer>();
      for (int ch = 'a'; ch <= 'z'; ch++) {
        if (used[ch] == 0) {
          V--; // 没出现过的字母，无需计入统计
        }
        else if (deg[ch] != 0) {
          l.add(deg[ch]);
        }
      }
      //有向图欧拉路径存在性判断方法
      if (V == 1 && (l.isEmpty() || l.size() == 2 && l.get(0) == 1 || l.get(0) == -1)) {
        out.write("Ordering is possible.\n");
      }
      else {
        out.write("The door cannot be opened.\n");
      }
    }
  }
}
