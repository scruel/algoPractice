package algsPractice.oj.luogu.trial.L2.L2_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1051 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int sum = 0;
    String maxName = null;
    int maxReward = 0;
    for (int i = 0; i < n; i++) {
      int reward = 0;
      String name = in.nextString();
      int av = in.nextInt();
      int cv = in.nextInt();
      boolean gb = in.nextString().equals("Y");
      boolean w = in.nextString().equals("Y");
      int pv = in.nextInt();
      if (av > 80 && pv >= 1) reward += 8000;
      if (av > 85 && cv > 80) reward += 4000;
      if (av > 90) reward += 2000;
      if (av > 85 && w) reward += 1000;
      if (cv > 80 && gb) reward += 850;
      sum += reward;
      if (reward > maxReward) {
        maxReward = reward;
        maxName = name;
      }
    }
    out.println(maxName);
    out.println(maxReward);
    out.println(sum);
  }
}
