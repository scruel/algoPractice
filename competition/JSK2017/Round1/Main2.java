package algsPractice.competition.JSK2017.Round1;

import java.io.*;

/**
 * Created by Scruel on 2017/5/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2 {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static int n, a, b, L, R;
        static StringBuilder sb = new StringBuilder(1 << 16);
        static String ts;

        static char getChar(int w) {
                if (L <= w && w <= R) {
                        if ((w & 1) == 0)
                                return 'A';
                        else
                                return 'T';
                } else {
                        if ((w & 1) == 0)
                                return 'G';
                        else
                                return 'C';
                }
        }

        public static void main(String[] args) throws IOException {
                String[] rts = bfr.readLine().trim().split("\\s+");
                n = Integer.parseInt(rts[0]);
                a = Integer.parseInt(rts[1]);
                b = Integer.parseInt(rts[2]);
                L = Integer.parseInt(rts[3]);
                R = Integer.parseInt(rts[4]);
                ts = bfr.readLine();

                int lastW = b;
                sb.append(getChar(lastW));
                for (int i = 1; i < n; i++) {
                        int w = (lastW + a) % n;
                        System.out.println(w);
                        sb.append(getChar(w));
                        lastW = w;
                }
//

//                bfw.write(cnt + "");
                bfr.close();
                bfw.close();
        }
}
