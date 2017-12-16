package algsPractice.dpExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Scruel on 2017/5/11.  
 * Github : https://github.com/scruel
 * #dp-knapsack
 */
public class CF741B {
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, allW;
  static ArrayList<Integer>[] sp = new ArrayList[1005];
  static HashSet<Integer> qSet = new HashSet<Integer>();
  static int[] w = new int[2005], b = new int[2005];
  static int[][] dp = new int[1005][1005];
  static int[] id = new int[2005];

  static int find(int p) {
    return p == id[p] ? p : (id[p] = find(id[p]));
  }

  static void union(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rp != rq) {
      id[rp] = rq;
    }
  }


  public static void main(String[] args) throws IOException {
    String[] rts = bfr.readLine().split("\\s+");
    n = new Integer(rts[0]);
    m = new Integer(rts[1]);
    allW = new Integer(rts[2]);
    int i, j, k;
    for (i = 1; i <= n; i++) {
      id[i] = i;
    }
    rts = bfr.readLine().split("\\s+");
    for (i = 1; i <= n; i++) {
      w[i] = new Integer(rts[i - 1]);
    }
    rts = bfr.readLine().split("\\s+");
    for (i = 1; i <= n; i++) {
      b[i] = new Integer(rts[i - 1]);
    }

    for (i = 0; i < m; i++) {
      rts = bfr.readLine().trim().split("\\s+");
      union(new Integer(rts[0]), new Integer(rts[1]));
    }
    int[] q = new int[1005];
    int cnt = 0;
    for (i = 1; i <= n; i++) {
      int root = find(i);
      if (sp[root] == null) {
        sp[root] = new ArrayList<Integer>();
      }
      //sp并查集
      sp[root].add(i);
      //并查集群ID
      if (qSet.add(root)) {
        q[++cnt] = root;
      }
    }

    //                System.out.println(cnt);
    Arrays.sort(q, 1, 1 + cnt);
    cnt = qSet.size();
    for (i = 1; i <= cnt; i++) {
      int nu = 0, we = 0;
      //统计
      for (j = 0; j < sp[q[i]].size(); j++) {
        we += w[sp[q[i]].get(j)];
        nu += b[sp[q[i]].get(j)];
      }
      //增加一个
      //整组不选
      sp[q[i]].add(0);
      //整组都选
      sp[q[i]].add(++n);
      w[n] = we;
      b[n] = nu;
      //                        System.out.println(we);
      //                        System.out.println(nu);
    }
    //dp[i][j]表示前i个朋友圈中选取不大于j重量，b的最大数
    for (i = 1; i <= cnt; i++) {
      for (k = 0; k < sp[q[i]].size(); k++) {
        int id = sp[q[i]].get(k);
        for (j = 1; j <= allW; j++) {
          //取出id
          if (j >= w[id]) {
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[id]] + b[id]);
          }
          //                                        System.out.println(dp[i][j]);
        }
      }
    }
    bfw.write(String.format("%d\n", dp[cnt][allW]));
    bfr.close();
    bfw.close();
  }
}
