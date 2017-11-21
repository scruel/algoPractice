package algsPractice.oj.UVa.aoapc.bac2nd.ch5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task12504 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      HashMap<String, String> map = new HashMap<String, String>();
      LinkedList<String> rmList = new LinkedList<String>();
      LinkedList<String> chList = new LinkedList<String>();
      LinkedList<String> naList = new LinkedList<String>();
      String os = in.nextLine();
      String ns = in.nextLine();
      int i = 1;
      while (true) {
        StringBuilder k = new StringBuilder();
        StringBuilder v = new StringBuilder();
        char ch;
        while ((ch = os.charAt(i++)) != ':' && ch != '}')
          k.append(ch);
        //WA-RE-forgot check this
        if (ch == '}') {
          break;
        }
        while ((ch = os.charAt(i++)) != ',' && ch != '}')
          v.append(ch);
        String ks = k.toString();
        String vs = v.toString();
        map.put(ks, vs);
        if (ch == '}') {
          break;
        }
      }
      i = 1;
      while (true) {
        StringBuilder k = new StringBuilder();
        StringBuilder v = new StringBuilder();
        char ch;
        while ((ch = ns.charAt(i++)) != ':' && ch != '}')
          k.append(ch);
        if (ch == '}') {
          break;
        }
        while ((ch = ns.charAt(i++)) != ',' && ch != '}')
          v.append(ch);
        String ks = k.toString();
        String vs = v.toString();

        if (map.containsKey(ks)) {
          if (!map.get(ks).equals(vs)) {
            chList.add(ks);
          }
          map.remove(ks);
        }
        else {
          naList.add(ks);
        }
        if (ch == '}') {
          break;
        }
      }
      rmList.addAll(map.keySet());

      boolean flag = true;
      if (!naList.isEmpty()) {
        flag = false;
        Collections.sort(naList);
        out.write("+");
        int kase = 0;
        for (String s : naList) {
          if (kase++ > 0) {
            out.write(",");
          }
          out.write(s);
        }
        out.writeln();
      }
      if (!rmList.isEmpty()) {
        flag = false;
        Collections.sort(rmList);
        out.write("-");
        int kase = 0;
        for (String s : rmList) {
          if (kase++ > 0) {
            out.write(",");
          }
          out.write(s);
        }
        out.writeln();
      }
      if (!chList.isEmpty()) {
        flag = false;
        Collections.sort(chList);
        out.write("*");
        int kase = 0;
        for (String s : chList) {
          if (kase++ > 0) {
            out.write(",");
          }
          out.write(s);
        }
        out.writeln();
      }
      if (flag) {
        out.writeln("No changes");
      }
      out.writeln();
    }
  }
}
