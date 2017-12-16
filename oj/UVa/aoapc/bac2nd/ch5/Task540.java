package algsPractice.oj.UVa.aoapc.bac2nd.ch5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * #queue #datastruct
 */
@SuppressWarnings("Unchecked")
public class Task540 {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;
  int n = 0, kase = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while ((n = in.nextInt()) != 0) {
      HashMap<Integer, Integer> ti = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
        int m = in.nextInt();
        for (int j = 0; j < m; j++) {
          ti.put(in.nextInt(), i);
        }
      }
      //一个队列记录团队，一个队列数组记录团队内值
      LinkedList<Integer> q = new LinkedList<Integer>();
      LinkedList<Integer>[] q2 = new IntegerList[n];
      //            List<List<Integer>> q2 = new LinkedList<List<Integer>>();
      out.writeln("Scenario #", ++kase);
      while (true) {
        String s = in.nextString();
        if ('D' == s.charAt(0)) {
          int t = q.peek();
          out.writeln(q2[t].poll());
          if (q2[t].isEmpty()) {
            q.poll();//团队集体出队列
          }
        }
        else if ('E' == s.charAt(0)) {
          int x = in.nextInt();
          int t = ti.get(x);
          if (q2[t] == null) {
            q2[t] = new IntegerList();
          }
          if (q2[t].isEmpty()) {
            q.add(t);//团队进入队列
          }
          q2[t].add(x);
        }
        else {
          break;
        }
      }
      out.writeln();
    }
  }

  static class IntegerList extends LinkedList<Integer> {
  }
}
