package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Stack;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * #data-struct
 */
public class Task673 {
  InputReader in;

  //注意要处理空行
  String nextLine() {
    StringBuilder res = new StringBuilder();
    int c = in.read();
    while (c != '\n') {
      res.appendCodePoint(c);
      c = in.read();
    }
    return res.toString();
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    int T = in.nextInt();
    in.read();
    while (T-- > 0) {
      Stack<Character> stack = new Stack<Character>();
      char[] chars = nextLine().toCharArray();
      boolean f = true;
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == '(' || chars[i] == '[') {
          stack.push(chars[i]);
        }
        else if (chars[i] == ')') {
          if (stack.isEmpty() || stack.pop() != '(') {
            f = false;
            break;
          }
        }
        else if (chars[i] == ']') {
          if (stack.isEmpty() || stack.pop() != '[') {
            f = false;
            break;
          }
        }
      }
      if (!stack.isEmpty()) {
        f = false;
      }

      if (f) {
        out.writeln("Yes");
      }
      else {
        out.writeln("No");
      }
    }
  }
}
