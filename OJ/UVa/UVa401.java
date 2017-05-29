package algsPractice.OJ.UVa;

import java.io.*;

/**
 * Created by Scruel on 2017/5/17.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa401 {

    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static char[] rev = "A   3  HIL JM O   2TUVWXY51SE Z  8 ".toCharArray();
    static String[] msg = {"not a palindrome", "a regular palindrome", "a mirrored string", "a mirrored palindrome"};

    static char getRev(char c) {
        if (Character.isDigit(c))
            return rev[c - '0' + 25];
        else
            return rev[c - 'A'];
    }

    public static void main(String[] args) throws IOException {
        String ts;
        while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
            int m = 1;
            int p = 1;
            int n = ts.length();
            for (int i = 0; i < (n + 1) / 2; i++) {
                //不是回文串
                if (ts.charAt(i) != ts.charAt(n - i - 1)) p = 0;
                //不是镜像串
                if (getRev(ts.charAt(i)) != ts.charAt(n - i - 1))
                    m = 0;
            }
            bfw.write(String.format("%s -- is %s.\n\n", ts, msg[m * 2 + p]));

        }
        bfr.close();
        bfw.close();
    }
}
