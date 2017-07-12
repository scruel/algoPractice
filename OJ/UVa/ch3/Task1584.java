package algsPractice.OJ.UVa.ch3;

import java.io.*;

/**
 * Created by Scruel on 2017/4/3.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **string** 滚动数组优化
 * #string
 */
public class Task1584 {
    static int n;
    static BufferedReader bfr;
    static BufferedWriter bfw;

    public static void main(String[] args) throws IOException {
        bfr = new BufferedReader(new InputStreamReader(System.in));
        bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bfr.readLine());
        solve2();
        bfr.close();
        bfw.close();
    }

    static void solve() throws IOException {
        for (int num = 0; num < n; num++) {
            char[] chars = bfr.readLine().toCharArray();
            String minS = new String(chars, 0, chars.length);
            for (int i = 0; i < chars.length; i++) {
                String tempS = new String(chars, 0, chars.length);
                if (minS.compareTo(tempS) > 0)
                    minS = tempS;
                char temp = chars[0];
                System.arraycopy(chars, 1, chars, 0, chars.length - 1);
//                        }
                chars[chars.length - 1] = temp;
            }
            bfw.write(minS + "\n");
        }
    }

    static void solve2() throws IOException {
        for (int num = 0; num < n; num++) {
            char[] chars = bfr.readLine().toCharArray();
            int index = 0;
            int len = chars.length;
            for (int i = 1; i < len; i++) {
                if (compareTo(chars, i, index))
                    index = i;
            }
            for (int i = 0; i < chars.length; i++)
                bfw.write(chars[(index + i) % len]);
            bfw.write("\n");
        }
    }

    static boolean compareTo(char[] chars, int i, int j) {
        int len = chars.length;
        for (int p = 0; p < len; p++) {
            if (chars[(i + p) % len] != chars[(j + p) % len])
                return chars[(i + p) % len] < chars[(j + p) % len];
//自己想的不对是因为没有考虑到全部的情况
//                        if (puzzle[(i + p) % len] < puzzle[(j + p) % len])
//                                return true;
        }
        return false;
    }

}
