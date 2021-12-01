package algsPractice.oj.luogu.trial.L2.L2_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Scruel Tao
 */
public class P1071 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String c = in.readLine().trim();
    String o = in.readLine().trim();
    String r = in.readLine().trim();

    Map<Character, Character> map = new HashMap<>();
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < c.length(); i++) {
      char cc = c.charAt(i);
      char co = o.charAt(i);
      if (!map.containsKey(cc)) {
        set.add(co);
        map.put(cc, co);
      }
      else if (map.get(cc) != co) {
        out.println("Failed");
        return;
      }
    }
    if (set.size() != 26) {
      out.println("Failed");
      return;
    }
    for (int i = 0; i < r.length(); i++) {
      out.print(map.get(r.charAt(i)));
    }
  }
}
