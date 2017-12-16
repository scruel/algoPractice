package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class Task699 {
  InputReader in;
  int maxn = 200;
  int[] sum = new int[maxn];

  // 输入并统计一棵子树，树根水平位置为p
  void build(int p) {
    int v = in.nextInt();
    if (v == -1) {
      return; // 空树
    }
    sum[p] += v;
    build(p - 1);
    build(p + 1);
  }

  // 边读入边统计
  void init(int v) {
    int pos = maxn / 2; // 树根的水平位置
    sum[pos] = v;
    build(pos - 1); // 左子树
    build(pos + 1); // 右子树
  }
  //
  //    boolean init() {
  //        int v = in.nextInt();
  //        if (v == -1) return false;
  //        int pos = maxn / 2; // 树根的水平位置
  //        sum[pos] = v;
  //        build(pos - 1); // 左子树
  //        build(pos + 1); // 右子树
  //        return true;
  //    }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;

    int kase = 0;
    int v;
    while ((v = in.nextInt()) != -1) {
      //        while (init()) {
      init(v);
      int p = 0;
      while (sum[p] == 0)
        p++; // 找最左边的叶子
      // 开始输出。因为要避免行末多余空格，所以稍微麻烦一点
      out.write("Case ", ++kase, ":\n", sum[p++]);
      while (sum[p] != 0) {
        out.write(" ", sum[p]);
        p++;
      }
      maxn = 200;
      sum = new int[maxn];
      out.writeln();
      out.writeln();
    }
  }
}
