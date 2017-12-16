package algsPractice.competition.codem.p;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskB {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;
  int MAXN = 1 << 20;
  int n;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    n--;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (m >= in.nextInt()) {
        cnt++;
      }
    }
    System.out.println(new Double(Math.log(cnt + 1) / Math.log(2)).intValue());
    int ans = 0;
    while (cnt > 0) {
      if ((cnt & 1) == 0) {
        cnt -= 2;
      }
      else {
        cnt--;
      }
      cnt /= 2;
      ans++;
    }
    out.writeln(ans);
  }
}
