package algsPractice.oj.nod51;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Scruel on 2017/5/11.  
 * Github : https://github.com/scruel
 * #greedy
 */
public class Nod1255 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
  static char[] s;
  static int[][] f = new int[100001][26];
  static int mask;
  //还剩下多少个字符
  static int[] c = new int[128];
  //是否在栈中
  static boolean[] v = new boolean[128];
  static Stack<Character> stack = new Stack<Character>();

  static void solve1() throws IOException {
    int n = s.length;
    for (int i = 0; i < 26; i++) {
      f[n][i] = n;
    }
    for (int i = n - 1; i >= 0; i--) {
      mask |= (1 << (s[i] - 'a'));
      //                        System.out.println(mask);
      System.arraycopy(f[i + 1], 0, f[i], 0, f[i].length);
      f[i][s[i] - 'a'] = i;
    }

    int start = 0;
    while (mask != 0) {
      for (int i = 0; i < 26; ++i) {
        if (((mask >> i) & 1) != 0) {
          int tmp = 0;
          for (int j = 0; j < 26; ++j) {
            if (f[f[start][i]][j] < n) {
              tmp |= (1 << j);
            }
          }
          if ((tmp & mask) == mask) {
            bfw.write((char) ('a' + i));
            start = f[start][i];
            mask ^= (1 << i);
            break;
          }
        }
      }
    }
  }

  static void solve2() {
    int n = s.length;
    for (int i = 0; i < n; i++) {
      c[s[i]]++;
    }
    for (int i = 0; i < n; i++) {
      c[s[i]]--;
      if (!v[s[i]]) {
        while (!stack.isEmpty()) {
          if (s[i] > stack.peek() || c[stack.peek()] <= 0) {
            break;
          }
          v[stack.peek()] = false;
          stack.pop();
        }
        stack.add(s[i]);
        v[s[i]] = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Iterator iter = stack.iterator(); iter.hasNext(); ) {

      sb.append(iter.next());
    }
    System.out.println(sb);

  }


  public static void main(String[] args) throws IOException {
    s = bfr.readLine().toCharArray();
    solve2();
    bfr.close();
    bfw.close();
  }


}
