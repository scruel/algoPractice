package algsPractice.oj.UVa.aoapc.bac2nd.ch5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate #queue
 */
public class Task12100 {
  public void solve1(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[] cnts = new int[10];
      int res = 0;
      LinkedList<Pair> list = new LinkedList<Pair>();
      for (int i = 0; i < n; i++) {
        int pr = in.nextInt();
        Pair p = new Pair(i, pr);
        cnts[pr]++;
        list.add(p);
      }
      int i = 9;
      while (true) {
        for (; i >= 0; i--) {
          if (cnts[i] != 0) {
            break;
          }
        }
        Pair p = list.poll();
        if (p.pr < i) {
          list.add(p);
        }
        else {
          cnts[i]--;
          res++;
          if (p.id == m) {
            break;
          }
        }
      }
      out.writeln(res);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      int res = 0;
      LinkedList<Pair> list = new LinkedList<Pair>();
      PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
      for (int i = 0; i < n; i++) {
        Pair p = new Pair(i, in.nextInt());
        pq.add(p);
        list.add(p);
      }

      while (true) {
        Pair p = list.poll();
        if (p.pr < pq.peek().pr) {
          list.add(p);
        }
        else {
          pq.poll();
          res++;//print
          if (p.id == m) {
            break;
          }
        }
      }
      out.writeln(res);
    }
  }

  static class Pair implements Comparable<Pair> {
    int id;
    int pr;

    public Pair(int id, int pr) {
      this.id = id;
      this.pr = pr;
    }

    //        @Override public boolean equals(Object obj) {
    //            return this.id == ((Pair) obj).id;
    //        }

    @Override
    public int compareTo(Pair o) {
      if (this.pr < o.pr) {
        return 1;
      }
      else if (this.pr > o.pr) {
        return -1;
      }
      return 0;
    }
  }

}
