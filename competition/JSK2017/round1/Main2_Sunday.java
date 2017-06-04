package algsPractice.competition.JSK2017.round1;

import java.io.*;

/**
 * Created by Scruel on 2017/5/23.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #TLE
 */
public class Main2_Sunday {

    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static int n, a, b, L, R;
    static int res = 0;
    static String pat;
    static StringBuilder txt = new StringBuilder(1 << 16);
    static int[] X = new int[256];

    static void search() {
        if (pat.length() == 0) return;
        initX();
        int i = 0;
        int k;
        while (i < txt.length()) {
            boolean flag = true;
            if (i + pat.length() > txt.length()) break;
            for (k = 0; k < pat.length(); k++) {
                if (txt.charAt(i + k) != pat.charAt(k)) {
                    flag = false;
                    break;
                }
            }

            if (flag) res++;
            int t = i + (pat.length());
            if (t >= txt.length()) break;
            if (X[txt.charAt(t)] == -1) {
                i += k + 1;
            } else {
                i += X[txt.charAt(t)];
            }
        }
    }

    static void initX() {
        for (int i = 0; i < 256; i++) {
            X[i] = -1;
        }
        for (int i = pat.length() - 1; i >= 0; i--) {
            if (X[pat.charAt(i)] == -1) X[pat.charAt(i)] = pat.length() - i;
        }
    }


    static char getChar(int w) {
        if (L <= w && w <= R) {
            if ((w & 1) == 0) return 'A';
            else return 'T';
        } else {
            if ((w & 1) == 0) return 'G';
            else return 'C';
        }
    }

    public static void main(String[] args) throws IOException {
        String[] rts = bfr.readLine().trim().split("\\s+");
        n = Integer.parseInt(rts[0]);
        a = Integer.parseInt(rts[1]);
        b = Integer.parseInt(rts[2]);
        L = Integer.parseInt(rts[3]);
        R = Integer.parseInt(rts[4]);
        pat = bfr.readLine();
        for (int i = 0; i < 256; i++) {
            X[i] = -1;
        }
        for (int i = pat.length() - 1; i >= 0; i--) {
            if (X[pat.charAt(i)] == -1) X[pat.charAt(i)] = pat.length() - i;
        }
        int lastW = b;
        txt.append(getChar(lastW));
        for (int i = 1; i < n; i++) {
            int w = (lastW + a) % n;
//                        System.out.println(w);
            txt.append(getChar(w));
            lastW = w;
        }
        search();

        bfw.write(res + "");
        bfr.close();
        bfw.close();
    }
}
