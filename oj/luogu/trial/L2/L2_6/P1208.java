package algsPractice.oj.luogu.trial.L2.L2_6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.PriorityQueue;

/**
 * @author Scruel Tao
 */
public class P1208 {
  class NN implements Comparable<NN> {
    int price, num;

    public NN(int price, int num) {
      this.price = price;
      this.num = num;
    }

    @Override
    public int compareTo(NN o) {
      return price - o.price;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    PriorityQueue<NN> q = new PriorityQueue<>();

    for (int i = 0; i < m; i++) {
      q.add(new NN(in.nextInt(), in.nextInt()));
    }

    int res = 0;
    while (!q.isEmpty() && n > 0) {
      NN nn = q.poll();
      n -= nn.num;
      res += nn.num * nn.price;
      if (n < 0) res += n * nn.price;
    }
    out.println(res);
  }
}
