package algsPractice.oj_t;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class LQSS2017_CQ9 {
  String sa, sb;
  LinkedList<Character> listA = new LinkedList<Character>();
  LinkedList<Character> listB = new LinkedList<Character>();
  Stack<Character> ts = new Stack<Character>();
  int[] R = new int[256];


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    sa = in.nextLine();
    sb = in.nextLine();
    boolean isA = true;
    for (int i = 0; i < sa.length(); i++) {
      R[sa.charAt(i)]++;
      listA.add(sa.charAt(i));
    }

    for (int i = 0; i < sb.length(); i++) {
      R[sb.charAt(i)]++;
      listB.add(sb.charAt(i));
    }
    int ci = 0;
    for (int i = 0; i < 256; i++) {
      if (R[i] > 0) {
        ci++;
      }
    }
    if (ci == 1 && sa.length() > 1) {
      out.write(-1);
      return;
    }
    while (listA.size() != 0 && listB.size() != 0) {
      char card;
      boolean win = false;
      if (isA) {
        card = listA.poll();
      }
      else {
        card = listB.poll();
      }
      if (ts.contains(card)) {
        win = true;
        LinkedList<Character> tmp = isA ? listA : listB;
        tmp.add(card);
        char ch;
        while ((ch = ts.pop()) != card)
          tmp.add(ch);
        tmp.add(ch);
      }
      else {
        ts.add(card);
      }
      if (!win) {
        isA = !isA;
      }
    }


    LinkedList<Character> res = listA.size() == 0 ? listB : listA;
    for (int i = 0; i < res.size(); i++) {
      out.write(res.get(i));
    }

  }
}
