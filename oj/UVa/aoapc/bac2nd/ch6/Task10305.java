package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * #topological-sort #graph
 */
public class Task10305 {
  int MAXN = 100;
  int[] nums = new int[MAXN + 10];
  boolean[] mk;
  MyList[] adj;
  Stack<Integer> st = new Stack<Integer>();

  void addE(int v, int w) {
    adj[v].add(w);
  }

  void dfs(int v) {
    mk[v] = true;
    for (int w : adj[v]) {
      if (!mk[w]) {
        dfs(w);
      }
    }
    st.add(v);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n, m;
    while (true) {
      n = in.nextInt();
      m = in.nextInt();
      if (n == 0 && m == 0) {
        break;
      }
      adj = new MyList[MAXN + 10];
      mk = new boolean[MAXN + 10];
      for (int i = 1; i <= n; i++) {
        nums[i] = i;
        adj[i] = new MyList();
      }
      for (int i = 0; i < m; i++) {
        addE(in.nextInt(), in.nextInt());
      }
      for (int i = 1; i <= n; i++) {
        if (!mk[i]) {
          dfs(i);
        }
      }
      while (!st.isEmpty()) {
        int t = st.pop();
        if (st.size() == 0) {
          out.write(t);
        }
        else {
          out.write(t + " ");
        }
      }
      out.writeln();
    }
  }

  static class MyList extends LinkedList<Integer> {
  }
}
