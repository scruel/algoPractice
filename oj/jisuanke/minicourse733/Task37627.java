package algsPractice.oj.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Stack;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37627 {
  int ops = 0;
  boolean isC = false;
  int MOD = 10000;
  Stack<Integer> ns = new Stack<Integer>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (!in.isExhausted()) {
      int num = in.nextInt() % MOD;
      if (isC) {
        int p = ns.pop();
        ns.add((p * num) % MOD);
        isC = false;
      }
      else {
        ns.add(num);
      }
      if (!in.isExhausted()) {
        char op = (char) in.read();
        if (op == '*') {
          isC = true;
        }
        else {
          ops++;
        }
      }
    }

    while (ops-- > 0) {
      int p = ns.pop();
      int q = ns.pop();
      ns.add((p + q) % MOD);
    }
    out.writeln(ns.pop() % MOD);
  }
}
