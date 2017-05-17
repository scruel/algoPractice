package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/5/17.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa11988 {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static StringBuilder sb;
        static char[] words;
        static int[] next;
        static int cur, tail;

        public static void main(String[] args) throws IOException {
                String ts;
                while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
                        words = new char[100005];
                        next = new int[100005];
                        cur = tail = 0;
                        int n = ts.length();
                        for (int i = 1; i <= n; i++) {
                                char ch = ts.charAt(i - 1);
                                if (ch == '[') {
                                        cur = 0;
                                } else if (ch == ']') {
                                        cur = tail;
                                } else {
                                        next[i] = next[cur];
                                        next[cur] = i;
                                        if (cur == tail) tail = i;
                                        cur = i;
                                }
                        }
                        sb = new StringBuilder(1 << 16);
                        for (int i = next[0]; i != 0; i = next[i]) {
                                sb.append(ts.charAt(i - 1));
                        }
                        bfw.write(sb.toString() + "\n");
                }
                bfr.close();
                bfw.close();
        }
}
