package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/5/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa1588 {

    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static String ts, ds;

    static boolean check(char i, char j) {
        return i != '2' || j != '2';
    }

    static int min(int a, int b, int c) {
        return (a < b ? (a < c ? a : c) : (b < c ? b : c));
    }

    static int getMidRes() {
        String tmp;
        if (ds.length() < ts.length()) {
            tmp = ds;
            ds = ts;
            ts = tmp;
        }

        for (int i = 0; i <= ds.length() - ts.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < ts.length(); j++) {
                if (!check(ds.charAt(i + j), ts.charAt(j))) {
                    flag = false;
                    if (i == ds.length() - 1) return ds.length() + ts.length();
                    break;
                }
            }
            if (flag)
                return ds.length();
        }
        return Integer.MAX_VALUE;
    }

    static int getLeftRes() {
        int index = ds.length() < ts.length() ? ds.length() - 1 : ts.length() - 1;
        while (index >= 0) {
            boolean flag = true;
            for (int i = 0; i <= index; i++) {
                if (!check(ds.charAt(i), ts.charAt(ts.length() - index + i - 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return ts.length() + ds.length() - index - 1;
            index--;
        }
        return ts.length() + ds.length();
    }

    static int getRightRes() {
        int index = ds.length() < ts.length() ? 0 : ds.length() - ts.length();
        while (index < ds.length()) {
            boolean flag = true;
            for (int i = index; i < ds.length(); i++) {
                if (!check(ds.charAt(i), ts.charAt(i - index))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return ts.length() + index;
            index++;
        }
        return ts.length() + ds.length();
    }

    public static void main(String[] args) throws IOException {
        while ((ds = bfr.readLine()) != null && !ds.isEmpty()) {
            ts = bfr.readLine();
            bfw.write(min(getLeftRes(),
                getRightRes(), getMidRes()) + "\n");

        }
        bfr.close();
        bfw.close();
    }
}
