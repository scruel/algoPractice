package algsPractice.oj.nod51;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * Created by Scruel on 2017/5/11.  
 * Github : https://github.com/scruel
 * #greedy
 */
public class Nod1091 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
  static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
  static Pair[] pairs;
  static int n;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(bfr.readLine());
    pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
      String[] rts = bfr.readLine().split("\\s+");
      pairs[i] = new Pair();
      pairs[i].head = Integer.parseInt(rts[0]);
      pairs[i].tail = Integer.parseInt(rts[1]);
      pq.add(pairs[i]);
    }
    int ans = 0;
    int last = pq.poll().tail;

    while (!pq.isEmpty()) {
      Pair tmp = pq.poll();
      if (tmp.tail <= last) {
        ans = Math.max(ans, tmp.tail - tmp.head);
      }
      else {
        ans = Math.max(ans, last - tmp.head);
        last = tmp.tail;
      }
    }

    //                Arrays.sort(pairs);
    //                int last = pairs[0].tail;
    //                for (int i = 1; i < n; i++) {
    //                        if (pairs[i].tail <= last) {
    //                                ans = Math.max(ans, pairs[i].tail - pairs[i].cur);
    //                        } else {
    //                                ans = Math.max(ans, last - pairs[i].cur);
    //                                last = pairs[i].tail;
    //                        }
    //                }
    bfw.write(ans + "");
    bfr.close();
    bfw.close();
  }

  static class Pair implements Comparable<Pair> {
    int head;
    int tail;

    @Override
    public int compareTo(Pair o) {
      return this.head - o.head;
    }
  }

}
