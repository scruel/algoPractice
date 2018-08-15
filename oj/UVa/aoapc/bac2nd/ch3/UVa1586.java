package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1586 {
  double[] nums = {12.01, 1.008, 16.00, 14.01};//CHON

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      String s = in.readLine();
      double result = 0.0;
      double tempR = 0.0;
      int j = 0;
      String tempNum = "";
      while (j < s.length()) {
        char ch = s.charAt(j);
        if (Character.isDigit(ch)) {
          tempNum += ch;
        }
        else {
          if ("".equals(tempNum)) {
            result += tempR;
          }
          else {
            result += tempR * Integer.parseInt(tempNum);
          }
          tempNum = "";
          switch (ch) {
            case 'C':
              tempR = nums[0];
              break;
            case 'H':
              tempR = nums[1];
              break;
            case 'O':
              tempR = nums[2];
              break;
            case 'N':
              tempR = nums[3];
              break;
            //本水题有非法输入，必须加这一段！！！
            default:
              tempR = 0;
          }
        }
        j++;
        result += 1e-10;
      }
      if ("".equals(tempNum)) {
        result += tempR;
      }
      else {
        result += tempR * Integer.parseInt(tempNum);
      }
      result += 1e-10;
      out.printf("%.3f\n", result);
    }
  }
}
