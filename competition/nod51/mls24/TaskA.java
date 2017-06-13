package algsPractice.competition.nod51.mls24;


/**
 * Created by Scruel on 2017/4/26.
 * #math
 */

import java.io.*;

public class TaskA {
        static StringBuilder sb = new StringBuilder(1 << 16);

        public static void main(String[] args) throws IOException {
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
            int n = Integer.parseInt(bfr.readLine());
                /**
                 * 这题的结论是这样的：
                 1、很容易得出每个三角形的和应为3n/2，故n为奇数时无解；
                 2、当n为偶数时，总存在可行解，外圈依次填写1~n-1，内圈1和2直接填写n-1，然后构造即可
                 */
                if ((n & 1) != 0) {
                        bfw.write("0");
                } else {
                        for (int i = 1; i < n - 1; ++i) {
                                sb.append(i).append(" ");
                        }
                        sb.append(n - 1).append("\n");
                        for (int i = 1; i < n - 1; ++i) {
                                sb.append((i & 1) != 0 ? n / 2 - i / 2 : n - i / 2).append(" ");
                        }
                        sb.append(((n - 1) & 1) != 0 ? n / 2 - (n - 1) / 2 : n - (n - 1) / 2).append("\n");
                        bfw.write(sb.toString());
                }
                bfw.close();
                bfr.close();
        }
}