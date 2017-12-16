package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class Task272 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    boolean flag = true;
    char ch;
    while ((ch = (char) in.read()) != (char) -1) {
      if (ch == '\"') {
        if (flag) {
          out.write("``");
        }
        else {
          out.write("''");
        }
        flag = !flag;
      }
      else {
        out.write(ch);
      }
    }
  }
}
