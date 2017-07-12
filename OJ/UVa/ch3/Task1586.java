package algsPractice.OJ.UVa.ch3;

import java.io.*;

/**
 * Created by Scruel on 2017/4/3.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string
 */
public class Task1586 {
    static final double[] nums = {12.01, 1.008, 16.00, 14.01};//CHON
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);


    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            String s = bfr.readLine();
            double result = 0.0;
            double tempR = 0.0;
            int j = 0;
            String tempNum = "";
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (Character.isDigit(ch)) {
                    tempNum += ch;
                } else {
                    if ("".equals(tempNum))
                        result += tempR;
                    else
                        result += tempR * Integer.parseInt(tempNum);
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
            if ("".equals(tempNum))
                result += tempR;
            else
                result += tempR * Integer.parseInt(tempNum);
            result += 1e-10;
            bfw.write(String.format("%.3f\n", result));
        }

        bfw.close();
        bfr.close();
    }

}
