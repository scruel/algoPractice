package algsPractice.oj.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate #string #queue
 * 使用链表保存减少数组移动导致的复杂度上升
 * 为了方便起见，常在链表的第一个元素之前放置一个虚拟节点
 */
public class Task11988 {
  static StringBuilder sb;
  static char[] words;
  static int[] next;//next[i]表示字符s[i]右边的字符为s[next[i]]
  static int cur, tail;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String ts;
    while ((ts = in.readLine()) != null && !ts.isEmpty()) {
      words = new char[100005];
      next = new int[100005];
      cur = tail = 0;
      int n = ts.length();
      for (int i = 1; i <= n; i++) {
        char ch = ts.charAt(i - 1);
        if (ch == '[') {
          cur = 0;
        }
        else if (ch == ']') {
          cur = tail;
        }
        else {
          //当前字符右边的字符即为光标右边的字符
          next[i] = next[cur];
          //光标右边的字符为当前字符
          //上一个字符的右边为i（不一定要在当前循环中保存下一个值，可以在下一个循环中保存上一个值）
          next[cur] = i;
          if (cur == tail) {
            tail = i;
          }
          cur = i;//移动光标
        }
      }
      sb = new StringBuilder(1 << 16);
      for (int i = next[0]; i != 0; i = next[i]) {
        //需要为i-1，因为存入的时候下标是[1,n]
        sb.append(ts.charAt(i - 1));
      }
      out.write(sb.toString() + "\n");
    }
  }
}
