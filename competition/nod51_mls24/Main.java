package algsPractice.competition.nod51_mls24;


/**
 * Created by Scruel on 2017/4/26.
 */

import java.io.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
                int n = new Integer(bfr.readLine());
                /**
                 * 这题的结论是这样的：
                 1、很容易得出每个三角形的和应为3n/2，故n为奇数时无解；
                 2、当n为偶数时，总存在可行解，外圈依次填写1~n-1，内圈1和2直接填写n-1，然后构造即可
                 */
                if ((n & 1) != 0) {
                        bfw.write("0");
                } else {
                        for (int i = 1; i < n; ++i) {
                                bfw.write(String.format("%d%c", i, i == n - 1 ? '\n' : ' '));
                        }
                        for (int i = 1; i < n; ++i) {
                                bfw.write(String.format("%d%c", (i & 1) != 0 ? n / 2 - i / 2 : n - i / 2, i == n - 1 ? '\n' : ' '));
                        }
                }
                bfw.close();
                bfr.close();
        }
}