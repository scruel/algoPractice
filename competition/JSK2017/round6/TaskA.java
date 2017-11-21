package algsPractice.competition.JSK2017.round6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskA {
  String[] sss = {"-", "--", "---", "----", "-----"};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int d = in.nextInt();
    String m;
    if (d >= 90) {
      m = "4G";
    }
    else if (d < 90 && d >= 60) {
      m = "3G";
    }
    else {
      m = "E";
    }
    out.writeln("+-----+");


    for (int i = 0; i < 5; i++) {
      if (i >= 1) {
        m = "";
      }
      String p = "";
      if (d / 20 > i) {
        p = sss[i];
        out.writeln("|" + p + String.format("%" + (5 - p.length() == 0 ? "" : (5 - p.length())) + "s|", m));
      }
      else {
        out.writeln(String.format("|%5s|", m));
      }
    }
    out.writeln("+-----+");


  }
}
