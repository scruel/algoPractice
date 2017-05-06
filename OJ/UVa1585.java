package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/3.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **string**
 */
public class UVa1585 {
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {
                solve();
                bfw.close();
                bfr.close();
        }

        static void solve() throws IOException {
                int n = new Integer(bfr.readLine());
                for (int i = 0; i < n; i++) {
                        String s = bfr.readLine();
                        int sum = 0;
                        int tempSum = 0;
                        for (int j = 0; j < s.length(); j++) {
                                if (s.charAt(j) == 'O')
                                        tempSum++;
                                else
                                        tempSum = 0;
                                sum += tempSum;
                        }
                        bfw.write(sum + "\n");
                }
        }
}
