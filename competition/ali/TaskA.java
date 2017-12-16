package algsPractice.competition.ali;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskA {
  private static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;

  private static class Box implements Comparable {
    int p;
    int l;
    int w;
    int h;

    @Override
    public int compareTo(Object o) {
      Box b = (Box) o;
      if (this.p > b.p) {
        return 1;
      }
      if (this.p < b.p) {
        return -1;
      }
      return 0;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l = in.nextInt();
    int w = in.nextInt();
    int h = in.nextInt();
    int res = 0;
    int n = in.nextInt();
    PriorityQueue<Box> pq = new PriorityQueue<Box>();
    while (n-- > 0) {
      Box box = new Box();
      box.p = in.nextInt();
      if (box.p > CUSTOMS_LIMIT_MONEY_PER_BOX) {
        System.out.println(-1);
        return;
      }
      box.l = in.nextInt();
      if (box.l > l) {
        System.out.println(-1);
        return;
      }
      box.w = in.nextInt();
      if (box.w > w) {
        System.out.println(-1);
        return;
      }
      box.h = in.nextInt();
      if (box.h > h) {
        System.out.println(-1);
        return;
      }
      pq.add(box);
    }

    int cl = 0;
    int cw = 0;
    int ch = 0;
    int cp = 0;
    if (!pq.isEmpty()) {
      res++;
    }
    while (!pq.isEmpty()) {
      Box box = pq.poll();
      if (cl + box.l <= l && cw + box.w <= w && ch + box.h <= h && cp + box.p <= CUSTOMS_LIMIT_MONEY_PER_BOX) {
        cl += box.l;
        cw += box.w;
        ch += box.h;
        cp += box.p;
      }
      else {
        res++;
        cl = 0;
        cw = 0;
        ch = 0;
        cp = 0;
      }
    }


    out.writeln(res);
  }
}
