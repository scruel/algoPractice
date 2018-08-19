package algsPractice.oj.luogu.L1_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1046 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l = in.nextInt();
    int t = in.nextInt();
    int[] tree = new int[10005];
    while (t-- != 0) {
      int a = in.nextInt();
      int b = in.nextInt();
      tree[a]++;
      tree[b + 1]--;
    }
    int cnt = 0;
    int res = 0;
    for (int i = 0; i <= l; i++) {
      cnt += tree[i];
      if (cnt <= 0) res++;
    }
    out.println(res);
  }
}
