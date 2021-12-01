package algsPractice.oj.luogu.trial.L2.L2_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.TreeSet;

/**
 * @author Scruel Tao
 */
public class P1059 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    // erase(unique(v.begin(), v.end()), v.end())
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      set.add(in.nextInt());
    }
    out.println(set.size());
    while (!set.isEmpty()) {
      out.print(set.pollFirst());
      if (!set.isEmpty()) out.print(" ");
    }
  }
}