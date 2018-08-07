package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Scruel Tao
 */
public class UVa202 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 0;
    while (!in.isExhausted()) {
      // if (kase++ != 0) out.println();
      int a = in.nextInt();
      int b = in.nextInt();
      out.printf("%d/%d = ", a, b);
      int r = 0;
      if (a >= b) {
        r = (int) (a / b + 1e-10);
        a = (a - r * b);
      }
      out.printf("%d.", r);
      a *= 10;
      Map<Integer, Integer> digit = new HashMap<>();
      StringBuilder decimals = new StringBuilder();
      int i = 0;
      // 模拟长除法
      for (; ; i++) {
        // 校验
        if (digit.containsKey(a)) {
          break;
        }
        digit.put(a, i);
        r = (int) (a / b + 1e-10);
        a = (a - r * b) * 10;
        decimals.append(r);
      }

      if (decimals.length() > 50) {
        String ress = decimals.substring(0, 50) + "...)";
        ress = ress.substring(0, digit.get(a)) + "(" + ress.substring(digit.get(a));
        out.print(ress);
      }
      else {
        decimals.insert(digit.get(a), "(");
        decimals.insert(decimals.length(), ")");
        out.print(decimals);
      }
      out.printf("\n   %d = number of digits in repeating cycle\n\n", i - digit.get(a));
    }
  }
}
