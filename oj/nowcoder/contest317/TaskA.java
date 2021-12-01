package algsPractice.oj.nowcoder.contest317;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Stack;

/**
 * @author Scruel Tao
 */
public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long v = in.nextLong();
    Stack<Long> vs = new Stack<>();
    Stack<Integer> ops = new Stack<>();

    while (n-- > 0) {
      int op = in.nextInt();
      long x = in.nextLong();
      ops.push(op);
      vs.push(x);
    }

    vs.push(v);
    while (!ops.isEmpty()) {
      int op = ops.pop();
      long v1 = vs.pop();
      long v2 = vs.pop();
      if (op == 4) {
        vs.push(v1 * v2);
      }
      else if (op == 3) {
        vs.push(v1 / v2);
      }
      else if (op == 2) {
        vs.push(v1 + v2);
      }
      else if (op == 1) {
        vs.push(v1 - v2);
      }
    }
    out.println(vs.pop());
  }
}
