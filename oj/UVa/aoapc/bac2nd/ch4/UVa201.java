package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa201 {
  int n;
  int[] h = new int[100];
  int[] v = new int[100];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 0;
    for (; ; ) {
      String s = in.nextString();
      if (s == null) {
        break;
      }
      if (kase != 0) out.printf("\n**********************************\n\n");
      out.printf("Problem #%d\n\n", ++kase);
      n = Integer.parseInt(s);
      for (int i = 0; i < n * n; i++) {
        h[i] = i;
        v[i] = i;
      }

      int t = in.nextInt();
      while (t-- != 0) {
        char c = (char) in.read();
        int i = in.nextInt() - 1;
        int j = in.nextInt() - 1;
        if (c == 'H') {
          unionH(i, j);
        }
        else {
          unionV(j, i);
        }
      }
      boolean f = false;
      for (int c = 1; c < n; c++) {
        int cnt = 0;
        for (int i = 0; i < n - c; i++) {
          for (int j = 0; j < n - c; j++) {
            if (check(i, j, c)) {
              f = true;
              cnt++;
            }
          }
        }
        if (cnt != 0) out.printf("%d square (s) of size %d\n", cnt, c);
      }
      if (!f) out.println("No completed squares can be found.");
    }
  }

  // 四个方向检测垂直和水平的连通性, 枚举时的限制确保了检测不会出错.
  private boolean check(int i, int j, int c) {
    // 左上 左下 右上 右下
    int p = i * n + j;
    int vp = (i + c) * n + j;
    int hp = p + c;
    int vhp = vp + c;
    if (findH(p) != findH(hp)) return false;
    if (findH(vp) != findH(vhp)) return false;
    if (findV(p) != findV(vp)) return false;
    if (findV(hp) != findV(vhp)) return false;
    return true;
  }

  private void unionH(int i, int j) {
    int p = i * n + j;
    int q = i * n + (j + 1);
    int rp = findH(p);
    int rq = findH(q);
    if (rp != rq) {
      h[rp] = rq;
    }
  }

  private int findH(int p) {
    return h[p] == p ? p : (h[p] = findH(h[p]));
  }

  private void unionV(int i, int j) {
    int p = i * n + j;
    int q = (i + 1) * n + j;
    int rp = findV(p);
    int rq = findV(q);
    if (rp != rq) {
      v[rp] = rq;
    }
  }

  private int findV(int p) {
    return v[p] == p ? p : (v[p] = findV(v[p]));
  }
}
