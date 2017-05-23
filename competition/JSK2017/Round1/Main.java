package algsPractice.competition.JSK2017.Round1;

import java.io.*;

/**
 * Created by Scruel on 2017/5/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static int n, a, b, L, R;
        static StringBuilder sb = new StringBuilder(1 << 16);
        static String ts;
        static private int BR;     // the radix
        static private int[] right;     // the bad-character skip array
        static private char[] pattern;  // store the pattern as a character array

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

        static public void init() {
                BR = 256;
                // position of rightmost occurrence of c in the pattern
                right = new int[BR];
                for (int c = 0; c < BR; c++)
                        right[c] = -1;
                for (int j = 0; j < ts.length(); j++)
                        right[ts.charAt(j)] = j;
        }

        static int search(String txt, int index) {

                int m = ts.length();
                int n = txt.length();
                int skip;
                for (int i = index; i <= n - m; i += skip) {
                        skip = 0;
                        for (int j = m - 1; j >= 0; j--) {
                                if (ts.charAt(j) != txt.charAt(i + j)) {
                                        skip = Math.max(1, j - right[txt.charAt(i + j)]);
                                        break;
                                }
                        }
                        if (skip == 0) return i;    // found
                }
                return -1;                       // not found
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
                        //                        System.out.println(w);
                        sb.append(getChar(w));
                        lastW = w;
                }
                init();
                String s = sb.toString();
                //                      System.out.println(preIndex);
                //                System.out.println(sb.toString());
                int cnt = 0;
                int res = search(s, 0);
                while (res != -1) {
                        res = search(s, res + 1);
                        cnt++;
                }

                bfw.write(cnt + "");
                bfr.close();
                bfw.close();
        }
}
