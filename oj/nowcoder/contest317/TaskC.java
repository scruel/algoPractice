package algsPractice.oj.nowcoder.contest317;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Scruel Tao
 */
public class TaskC {
  int dv, sv, res;
  Map<Integer, List<Integer>> bitsMap = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 0; i < 32; i++) {
      bitsMap.put(i, new LinkedList<>());
    }
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    sv = a[0];
    dv = a[n - 1];
    if (a[n - 1] >= a[0]) {
      out.println(-1);
      return;
    }
    res = sv ^ dv;

    // if (num <= dv) return;
    // if (num >= sv) return;
    out.println(res);
  }

}
