package algsPractice.oj.luogu.L1_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Stack;

/**
 * @author Scruel Tao
 */
public class P1427 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Stack<Integer> stack = new Stack();
    for (; ; ) {
      int i = in.nextInt();
      if (i == 0) break;
      stack.add(i);
    }
    out.print(stack.pop());
    while (!stack.isEmpty()) {
      out.printf(" %d", stack.pop());
    }
  }
}
