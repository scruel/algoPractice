package algsPractice.oj.luogu.trial.L2.L2_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class P1603 {
  String[] key = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "a", "both", "another", "first", "second", "third"};
  int[] v = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 0, 21, 44, 69, 96, 25, 56, 89, 24, 61, 0, 1, 4, 1, 1, 4, 9};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    Map<String, Integer> keymap = new HashMap<>();
    for (int i = 0; i < key.length; i++) {
      keymap.put(key[i], v[i]);
    }
    for (; ; ) {
      String s = in.nextString();
      if (s == null) break;
      s = s.toLowerCase();
      if (keymap.containsKey(s)) {
        q.add(keymap.get(s));
      }
    }

    StringBuilder res = new StringBuilder();
    boolean f = false;
    while (!q.isEmpty()) {
      int v = q.poll();
      if (v == 0) continue;
      if (!f) {
        f = true;
        res.append(v);
      }
      else {
        res.append(String.format("%02d", v));
      }
    }

    if (res.length() == 0) {
      out.println(0);
    }
    else {
      out.println(res);
    }

  }
}
